package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	
	private String nombre;
	
	private String numID; 
	
	private String fechaNacimiento;
	
	private String nacionalidad;
	
	private String username;
	
	private String password;
	
	private DatosPago datosMetodoPago;
	
	private Reserva reserva;
	
	private DatosLicencia licencia;
	
	private ArrayList<ConductorExtra> conductoresExtra;
	
	
	public Cliente(String elNombre, String elNumID,String laFechaNacimiento, String laNacionalidad, String elUsername, String elPassword, DatosLicencia laLicencia, ArrayList<ConductorExtra> losConductoresExtra, DatosPago losDatosMetodoPago)
	{
		this.nombre = elNombre;
		this.numID = elNumID;
		this.fechaNacimiento = laFechaNacimiento;
		this.nacionalidad = laNacionalidad;
		this.username = elUsername;
		this.password = elPassword;
		this.licencia = laLicencia;
		this.conductoresExtra = losConductoresExtra;
		this.datosMetodoPago = losDatosMetodoPago;
	}
	
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getFechaNacimiento()
	{
		return fechaNacimiento;
	}
	
	public String getNacionalidad()
	{
		return nacionalidad;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public DatosPago getDatosMetodoPago()
	{
		return datosMetodoPago;
	}
	
	public Reserva getReserva()
	{
		return reserva;
	}
	
	public DatosLicencia getLicencia()
	{
		return licencia;
	}
	
	public List<ConductorExtra> getConductoresExtra()
	{
		return conductoresExtra;
	}
	
	
	public Reserva crearReserva(String ubicacion, Vehiculo vehiculo, Sede sedeRecogida,Sede sedeDevuelta,Cobros cobro, String fecha, String rangoHoras)
	{
		Reserva nuevaReserva = new Reserva(ubicacion, vehiculo, sedeRecogida,sedeDevuelta,cobro,fecha,rangoHoras);
		return nuevaReserva;
	}





	@Override
	public String getNumeroID() {
		// TODO Auto-generated method stub
		return numID;
	}
	

}
