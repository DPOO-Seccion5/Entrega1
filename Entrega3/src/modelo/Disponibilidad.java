package modelo;

public class Disponibilidad {
	
	private boolean alquilado;
	
	private String ubicacion;
	
	private String fechaDevolucion;
	
	private String lugarDevolucion;
	
	private String fechaDisponibilidad;
	
	private Cliente cliente;
	
	
	public Disponibilidad(boolean estaAlquilado, String laUbicacion, String laFechaDevolucion, String elLugarDevolucion, String laFechaDisponibilidad, Cliente elCliente)
	{
		this.alquilado = estaAlquilado;
		this.ubicacion = laUbicacion;
		this.fechaDevolucion = laFechaDevolucion;
		this.lugarDevolucion = elLugarDevolucion;
		this.fechaDisponibilidad = laFechaDisponibilidad;
		this.cliente = elCliente;
	}
	
	public boolean getIfAlquilado()
	{
		return alquilado;
	}
	
	public String getUbicacion()
	{
		return ubicacion;
	}
	
	public String getFechaDevolucion()
	{
		return fechaDevolucion;
	}

	public String getLugarDevolucion()
	{
		return lugarDevolucion;
	}
	
	public String getFechaDisponibilidad()
	{
		return fechaDisponibilidad;
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}
}
