package Dao;

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
	private String psw = "admin";
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
	public void agregarProducto(Producto p) {
		Connection conexion = null;
		
		String sql = "INSERT INTO producto (codigo,nombre,leyenda,precio,cantidad) dni)VALUES(?,?,?,?,?);";
		try {
			conexion = conectar();
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, p.getCodigo() );
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getLeyenda());
			stmt.setInt(4, p.getPrecio());
			stmt.setInt(5, p.getCantidad());
		
		 
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
		String sql = "SELECT * FROM tabla ";
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
				Producto p = new Producto(codigo,nombre,leyenda,precio,cantidad);
				solucion.add(p);
				
			}
		} catch (SQLException e) {
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
	
	
	public void actualizar(String codigo, Producto p)
	{
		Producto p1 = p;
		String sql = "UPDATE tabla SET cantidad = ? WHERE codigo = ?;";
		Connection conexion = null;
		try {
			conexion = conectar();
			PreparedStatement stnt = conexion.prepareStatement(sql);
			stnt.setString(2, codigo);
			stnt.setInt(1, p.getCantidad());
			
		
			System.out.println("se actualizo");
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
