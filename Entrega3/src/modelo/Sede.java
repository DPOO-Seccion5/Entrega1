package modelo;

import java.util.List;

public class Sede {
	
	private String nombre;
	
	private String ubicacion;
	
	private String horaDeAtencion;
	
	private List<Empleado> empleados;
	
	
	
	public Sede(String elNombre, String laUbicacion, String laHoraAtencion, List<Empleado> losEmpleados) 
	{
		this.nombre = elNombre;
		this.ubicacion = laUbicacion;
		this.horaDeAtencion = laHoraAtencion;
		this.empleados = losEmpleados;
	}

}
