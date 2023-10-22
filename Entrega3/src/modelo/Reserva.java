package modelo;

public class Reserva {
	
	
	private String ubicacion;
	
	private Vehiculo vehiculo;
	
	private Sede sedeRecogida;
	
	private Sede sedeDevuelta;
	
	private Cobros cobro;
	
	private String fecha;
	
	private String rangoHoras;
	
	public Reserva(String laUbicacion, Vehiculo elVehiculo, Sede laSedeRecogida, Sede laSedeDevuelta, Cobros elCobro, String laFecha, String elRangoHoras)
	{
		this.ubicacion = laUbicacion;
		this.vehiculo = elVehiculo;
		this.sedeRecogida = laSedeRecogida;
		this.sedeDevuelta = laSedeDevuelta;
		this.cobro = elCobro;
		this.fecha = laFecha;
		this.rangoHoras = elRangoHoras;
	}
	
	
	public String getUbicacion()
	{
		return ubicacion;
	}
	
	public Vehiculo getVehiculo()
	{
		return vehiculo;
	}
	
	public Sede getSedeRecogida()
	{
		return sedeRecogida;
	}
	
	public Sede getSedeDevuelta()
	{
		return sedeDevuelta;
	}
	
	public Cobros getCobro()
	{
		return cobro;
	}

	public String getFecha()
	{
		return fecha;
	}
	
	public String getRangoHoras()
	{
		return rangoHoras;
	}
	
	public ConductorExtra añadirConductorExtra()
	{
		return null;
	}
	
}
