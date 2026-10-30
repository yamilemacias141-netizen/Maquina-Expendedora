package Logica;


import java.util.ArrayList;
import java.util.Scanner;

import DAO.DAO;
public class MaquinaExpendedora 
{
	ArrayList<Producto> maquina = new ArrayList<>();
	DAO dao = new DAO();
	public MaquinaExpendedora()
	{
		maquina = dao.consultar();
	}
	
	

	
	
	public ArrayList<Producto> verSanguches()
	{
		ArrayList<Producto> sanguches = new ArrayList<>();
		for(Producto p:maquina)
		{
			if(p.getTipo() == tipoProducto.SANGUCHE)
			{
				sanguches.add(p);
			}
			
		}
		return sanguches;
	}
	public ArrayList<Producto> verBebidas()
	{
		ArrayList<Producto> bebidas = new ArrayList<>();
		for(Producto p:maquina)
		{
			if(p.getTipo() == tipoProducto.BEBIDA)
			{
				bebidas.add(p);
			}
		
			
		}
		return bebidas;

	}
	public ArrayList<Producto> verGolosinas()
	{
		ArrayList<Producto> golosinas = new ArrayList<>();
		for(Producto p:maquina)
		{
			if(p.getTipo() == tipoProducto.GOLOSINA)
			{
				golosinas.add(p);
			}
			
		}
		return golosinas;

	}
	public ArrayList<Producto> verSaludables()
	{
		ArrayList<Producto> saludables = new ArrayList<>();
		for(Producto p:maquina)
		{
			if(p.getTipo() == tipoProducto.SALUDABLE)
			{
				saludables.add(p);
			}
		
			
		}
		return saludables;
	
	}
	
	public String  comprar(String codigo , int dinero)
	{
		int vuelto = 0;
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
		   
		    if(encontrado.getCantidad() > 0)
			{
		    	
				if(dinero >= encontrado.getPrecio())
				{
					
					encontrado.reducirStock();
					dao.actualizarStock(encontrado);
					vuelto = dinero - encontrado.getPrecio();
					
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
		return encontrado.getLeyenda() + "\n Compra realizada \n Su vuelto es:"+ vuelto;
		
	
		
	}
	public ArrayList<Producto> verParaQueLeAlcanza(int dinero)
	{
		ArrayList<Producto> alcanzados = new ArrayList<>();
		for(Producto p: maquina)
		{
			if(dinero >= p.getPrecio())
			{
				alcanzados.add(p);
			}
		}
		return alcanzados;
	}
	
	
}
