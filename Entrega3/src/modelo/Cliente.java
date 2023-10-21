package modelo;

public abstract class Cliente {
	
	private String nombre;
	
	private String fechaNacimiento;
	
	private String nacionalidad;
	
	private String datosContacto;
	
	private String username;
	
	private String password;
	
	private DatosPago datosMetodoPago;
	
	private Reserva reserva;
	
	private DatosLicencia licencia;
	
	
	public Cliente(String elNombre, String laFechaNacimiento, String laNacionalidad, String losDatosContacto, String elUsername, String elPassword, DatosPago losDatosDePago, Reserva laReserva, DatosLicencia laLicencia)
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
	}
	
	
	
	
	
	

}
