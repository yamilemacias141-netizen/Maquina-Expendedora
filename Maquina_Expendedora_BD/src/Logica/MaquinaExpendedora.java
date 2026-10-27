package Logica;
import java.util.ArrayList;
import java.util.Scanner;
public class MaquinaExpendedora 
{
	ArrayList<Producto> maquina = new ArrayList<>();
	
	public MaquinaExpendedora()
	{
		
	}
	
	

	public void agregarProductos(String [][] products)
	{
		for(int i=0 ; i < products.length ; i++)
		{
			Producto p = new Producto(products[i][0], products[i][1], products[i][2], Integer.valueOf(products[i][3]) , Integer.valueOf(products[i][4]));
			maquina.add(p);
		}
		
		
	}
	
	public void verSanguches()
	{
		for(Producto p:maquina)
		{
			if(p.getTipo() == tipoProducto.SANGUCHE)
			{
				System.out.println(p.getCodigo() + " " + p.getNombre());
			}
			
		}
	
	}
	public void verBebidas()
	{
		for(Producto p:maquina)
		{
			if(p.getTipo() == tipoProducto.BEBIDA)
			{
				System.out.println(p.getCodigo() + " " + p.getNombre());
			}
		
			
		}
	}
	public void verGolosinas()
	{
		for(Producto p:maquina)
		{
			if(p.getTipo() == tipoProducto.GOLOSINA)
			{
				System.out.println(p.getCodigo()+ " " + p.getNombre());
			}
		
			
		}
	}
	public void verSaludables()
	{
		for(Producto p:maquina)
		{
			if(p.getTipo() == tipoProducto.SALUDABLE)
			{
				System.out.println(p.getCodigo() + " " + p.getNombre());
			}
		
			
		}
	}
	
	public void comprar(String codigo , int dinero)
	{
		
		Producto encontrado = null;
		for(Producto p:maquina)
		{
			if(p.getCodigo().equals(codigo))
			{
				encontrado = p;
				break;
			}
		}
		if(encontrado != null)
		{
		    System.out.println(encontrado.getLeyenda());
		    if(encontrado.getCantidad() > 0)
			{
		    	
				if(dinero >= encontrado.getPrecio())
				{
					System.out.println("Compra realizada");
					encontrado.reducirStock();
					int vuelto = dinero - encontrado.getPrecio();
					System.out.println("Su vuelto es " + vuelto);
				}
				else
				{
					System.out.println("Dinero insuficiente");
				}
			}
		    else
		    {
		    	System.out.println("Mo hay stock");
		    }
			
		}
		else
		{
			System.out.println("Producto no encontrado");
		}
		
		
	
		
	}
	public void verParaQueLeAlcanza(int dinero)
	{
		for(Producto p: maquina)
		{
			if(dinero >= p.getPrecio())
			{
				System.out.println(p.getCodigo() + " " + p.getNombre());
			}
		}
	}
	
	public void menu()
	{
		Scanner lectura = new Scanner (System.in);
		int opcion;
		
		do 
		{
			System.out.println();
			System.out.println("--------MENU--------");
			System.out.println("1.VER SANGUCHES");
			System.out.println("2.VER BEBIDAS");
			System.out.println("3.VER GOLOSINAS");
			System.out.println("4.VER SALUDABLES");
			System.out.println("5.VER PARA QUE LE ALCANZA");
			System.out.println("6.COMPRAR");
			System.out.println("8.SALIR");
			System.out.println();
			System.out.print("ingrese una opcion:");
			opcion = lectura.nextInt();
			
			switch (opcion)
			{
			case 1:
				System.out.println("-----SANGUCHES-----");
				verSanguches();
				break;
			case 2:
				System.out.println("-----BEBIDAS------");
				verBebidas();
				break;
			case 3:
				System.out.println("-----GOLOSINAS-----");
				verGolosinas();
				break;
			case 4:
				System.out.println("-----SALUDABLES----- ");
				verSaludables();
				break;
			case 5:
				System.out.print("ingrese el dinero:");
				int dinero = lectura.nextInt();
				System.out.println( );
				System.out.println("---------PRODUCTOS QUE LE ALCANZAN---------");
				verParaQueLeAlcanza(dinero);
				break;
			case 6:
				lectura.nextLine();
				System.out.print("ingrese el codigo del producto:");
				String codigo = lectura.nextLine();
				System.out.println("si quiere continuar ingrese 'A' sino ingrese 'B' para volver: ");
				String eleccion = lectura.nextLine();
				if (eleccion.equals("A"))
				{
					System.out.print("ingrese el dinero: ");
					int dinero2 = lectura.nextInt();
					lectura.nextLine();
					comprar(codigo  , dinero2);
				}
				break;
			case 7:
				break;
			default:
				System.out.println("opcion invalida");
		  
				
				break;
			
			}
		}
		while(opcion != 8);
		
	}
	
	
	public ArrayList<Producto> getMaquina()
	{
		return maquina;
	}

}