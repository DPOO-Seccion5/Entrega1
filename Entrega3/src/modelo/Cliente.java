package modelo;

import java.util.List;

public abstract class Cliente extends Usuario {
	
	private String nombre;
	
	private String fechaNacimiento;
	
	private String nacionalidad;
	
	private String datosContacto;
	
	private String username;
	
	private String password;
	
	private DatosPago datosMetodoPago;
	
	private Reserva reserva;
	
	private DatosLicencia licencia;
	
	private List<ConductorExtra> conductoresExtra;
	
	
	public Cliente(String elNombre, String laFechaNacimiento, String laNacionalidad, String losDatosContacto, String elUsername, String elPassword, DatosPago losDatosDePago, Reserva laReserva, DatosLicencia laLicencia, List<ConductorExtra> losConductoresExtra)
	{
		this.nombre = elNombre;
		this.fechaNacimiento = laFechaNacimiento;
		this.nacionalidad = laNacionalidad;
		this.datosContacto = losDatosContacto;
		this.username = elUsername;
		this.password = elPassword;
		this.datosMetodoPago = losDatosDePago;
		this.reserva = laReserva;
		this.licencia = laLicencia;
		this.conductoresExtra = losConductoresExtra;
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
	
	public String getDatosContacto()
	{
		return datosContacto;
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
	

}
