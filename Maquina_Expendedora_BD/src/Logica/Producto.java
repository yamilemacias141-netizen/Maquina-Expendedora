package Logica;
public class Producto 
{
	private String nombre;
	private String leyenda;
	private int precio;
	private String codigo;
	private int cantidad;
	private tipoProducto tipo;
	
	public Producto(String codigo, String nombre, String leyenda,  int precio , int cantidad)
	{
		this.nombre=nombre;
		this.leyenda=leyenda;
		this.precio=precio;
		this.codigo=codigo;
		this.cantidad=cantidad;
		this.tipo=determinarProduc(codigo);
	}
	
	
	
	
	public tipoProducto determinarProduc(String codigo)
	{
		char incial = codigo.charAt(0);
		tipoProducto tipoaux = null;
		switch(incial)
		{
		case 'A' : 
			tipoaux = tipoProducto.SANGUCHE;
			break;
		case 'B':
			tipoaux = tipoProducto.BEBIDA;
		case'C':
			tipoaux =  tipoProducto.GOLOSINA;
		case 'D':
			tipoaux = tipoProducto.SALUDABLE;

		}
		return tipoaux;
		
	}

	public String getNombre()
	{
		return nombre;
	}
	public String getLeyenda()
	{
		return leyenda;
	}
	public String getCodigo()
	{
		return codigo;
	}
	
	public int getPrecio()
	{
		return precio;
	}
	public int getCantidad()
	{
		return cantidad;
	}
	
	
	public void reducirStock()
	{
		cantidad--;
	}
	public tipoProducto getTipo()
	{
		return tipo;
	}
	

}