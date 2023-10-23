package procesamiento;

import java.util.ArrayList;
import procesamiento.Loader;

import modelo.*;
import java.util.List;


public class Compañia {
	
	
	private Inventario inventario;
	
	private List<Sede> sedes;
	
	private List<Cliente> clientes;
	
	private List<Empleado> empleados;
	

	
	
	public Compañia(Inventario elInventario, List<Sede> lasSedes, List<Cliente> losClientes, List<Empleado> losEmpleados)
	{
		this.inventario = elInventario;
		this.sedes = lasSedes;
		this.clientes = losClientes;
		this.empleados = losEmpleados;
	}
	
	
	public Inventario getInventario()
	{
		return inventario;
	}
	
	public List<Sede> getSedes()
	{
		return sedes;
	}
	
	public List<Cliente> getClientes()
	{
		return clientes;
	}
	
	public boolean logIn(String username, String password)
	{
		
		boolean respuesta = false;
		
		if (username.contains("empleado"))
		{
			for(Empleado y : empleados)
			{
				String user = y.getUsername();
				String pass = y.getPassword();
			
				if ((username.equals(user)) && (password.equals(pass)))
				{
					respuesta = true;
				}
				else 
				{
					respuesta = false;
				}	
			}	
		}
		else
		{
			for(Cliente x : clientes)
			{
				String user = x.getUsername();
				String pass = x.getPassword();
			
				if ((username.equals(user)) && (password.equals(pass)))
				{
					respuesta = true;
				}
				else 
				{
					respuesta = false;
				}
			}
		}
		
		return respuesta;
		
	}
	
	

	
	public void crearEmpleado(String nombre, String username, String password, String numID, String nacionalidad, String fechaNacimiento)
	{
		Empleado empleado = new Empleado(nombre,username,password,numID,nacionalidad,fechaNacimiento);
		empleados.add(empleado);
		
	}
	
}
