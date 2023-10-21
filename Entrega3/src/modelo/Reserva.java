package modelo;

public class Reserva {
	
	
	private String ubicacion;
	
	private Vehiculo vehiculo;
	
	private Sede sedeRecogida;
	
	private Sede sedeDevuelta;
	
	private Cobros cobro;
	
	public Reserva(String laUbicacion, Vehiculo elVehiculo, Sede laSedeRecogida, Sede laSedeDevuelta, Cobros elCobro)
	{
		this.ubicacion = laUbicacion;
		this.vehiculo = elVehiculo;
		this.sedeRecogida = laSedeRecogida;
		this.sedeDevuelta = laSedeDevuelta;
		this.cobro = elCobro;
	}

}
