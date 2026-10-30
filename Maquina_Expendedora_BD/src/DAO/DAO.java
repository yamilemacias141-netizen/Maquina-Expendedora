package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Logica.Producto;

public class DAO 
{
	private String user = "root";
	private String psw = "123456";
	private String path = "jdbc:mysql://localhost:3306/maquina";

	int filas;

	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(path, user, psw);

			System.out.println("se conecto");
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return conexion;
	}
	
	public void agregarProductos(Producto p ) {
		Connection conexion = null;
		
		String sql = "INSERT INTO productos (codigo,nombre,leyenda,precio,cantidad)VALUES(?,?,?,?,?);";
		try {
			conexion = conectar();
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, p.getCodigo());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getLeyenda());
			stmt.setInt(4, p.getPrecio());
			stmt.setInt(5, p.getCantidad());
		
			stmt.executeUpdate();
			System.out.println("se agrego");
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<Producto> consultar()
	{
		String sql = "SELECT * FROM productos ";
		Connection conexion = null;
		ArrayList<Producto> solucion = new ArrayList<>();
		try {
			conexion = conectar();
			Statement stnt = conexion.createStatement();
		    ResultSet rs = stnt.executeQuery(sql);	
			while(rs.next())
			{
				String codigo = rs.getString("codigo");
				String nombre = rs.getString("nombre");
				String leyenda = rs.getString("leyenda");
				int precio = rs.getInt("precio");
				int cantidad = rs.getInt("cantidad");
				Producto p= new Producto(codigo,nombre,leyenda,precio,cantidad);
				solucion.add(p);
			
				
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return solucion;
	}
	
	public void  actualizarStock(Producto p)
	{
	
		String sql = "UPDATE productos SET cantidad = cantidad-1 WHERE codigo = ?;";
		Connection conexion = null;
		try {
		
			conexion = conectar();
	        PreparedStatement stnt = conexion.prepareStatement(sql);
	        stnt.setString(1, p.getCodigo());
			
			stnt.executeUpdate();
			System.out.println("se desconto el stock");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}


}
