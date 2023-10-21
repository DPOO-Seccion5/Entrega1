package modelo;

public class Vehiculo {

	private String marca;
	
	private String placa;
	
	private String modelo;
	
	private String color;
	
	private String tipoTransmision;
	
	private Disponibilidad disponibilidad;
	
	private Categoria categoria;
	
	
	public Vehiculo(String laMarca, String laPlaca, String elModelo, String elColor, String elTipoTransmision, Disponibilidad laDisponibilidad, Categoria laCategoria) 
	{
		this.marca = laMarca;
		this.placa = laPlaca;
		this.modelo = elModelo;
		this.color = elColor;
		this.tipoTransmision = elTipoTransmision;
		this.disponibilidad = laDisponibilidad;
		this.categoria = laCategoria;
	
	}
	
	
}
