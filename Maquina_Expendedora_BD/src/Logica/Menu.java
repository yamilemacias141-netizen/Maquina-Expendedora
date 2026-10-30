package Logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu 
{
	private MaquinaExpendedora maquina;
	private Scanner lectura= new Scanner (System.in);;
	
	
	public Menu(MaquinaExpendedora maquina)
	{
		this.maquina=maquina;
	}
	public void menu()
	{
		
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
				ArrayList<Producto> sanguches = maquina.verSanguches();
				    for(Producto p : sanguches) {
				        System.out.println(p.getCodigo() + " | " + p.getNombre() + " | $" + p.getPrecio() + " | Stock: " + p.getCantidad());
				    }
				break;
			case 2:
				System.out.println("-----BEBIDAS------");
				ArrayList<Producto> bebidas = maquina.verBebidas();
			    for(Producto p : bebidas) {
			        System.out.println(p.getCodigo() + " | " + p.getNombre() + " | $" + p.getPrecio() + " | Stock: " + p.getCantidad());
			    }
				break;
			case 3:
				System.out.println("-----GOLOSINAS-----");
				ArrayList<Producto> golosinas = maquina.verGolosinas();
			    for(Producto p : golosinas) {
			        System.out.println(p.getCodigo() + " | " + p.getNombre() + " | $" + p.getPrecio() + " | Stock: " + p.getCantidad());
			    }
				break;
			case 4:
				System.out.println("-----SALUDABLES----- ");
				ArrayList<Producto> saludables = maquina.verSaludables();
			    for(Producto p : saludables) {
			        System.out.println(p.getCodigo() + " | " + p.getNombre() + " | $" + p.getPrecio() + " | Stock: " + p.getCantidad());
			    }
				break;
			case 5:
				System.out.print("ingrese el dinero:");
				int dinero = lectura.nextInt();
				System.out.println( );
				System.out.println("---------PRODUCTOS QUE LE ALCANZAN---------");
				ArrayList<Producto> alcanzados = maquina.verParaQueLeAlcanza(dinero);
			    for(Producto p : alcanzados) {
			        System.out.println(p.getCodigo() + " | " + p.getNombre() + " | $" + p.getPrecio() + " | Stock: " + p.getCantidad());
			    }
				break;
			case 6:
				lectura.nextLine();
				System.out.print("ingrese el codigo del producto:");
				String codigo = lectura.nextLine();
				System.out.println("si quiere continuar ingrese '1' sino ingrese '2' para volver: ");
				int eleccion = lectura.nextInt();
				if (eleccion == 1)
				{
					System.out.print("ingrese el dinero: ");
					int dinero2 = lectura.nextInt();
					lectura.nextLine();
					maquina.comprar(codigo  , dinero2);
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


}
