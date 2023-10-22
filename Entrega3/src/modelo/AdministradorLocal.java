package modelo;

import java.util.List;

public class AdministradorLocal {

	
	
	private Sede sede;

	
	public List<Empleado> getEmpleados(Sede sede)
	{
		List<Empleado> empleados = sede.getEmpleados();
		
		return empleados;
	}
	
	public void modificarEmpleados()
	{
		
	}
	
	public void modificarClientes()
	{
		
	}
	
	

}
