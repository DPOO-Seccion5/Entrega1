package modelo;

public class Categoria {
	
	private String categoria;
	
	private double precio;
	
	private String tamaño;
	
	private Tarifa tarifa;
	
	
	public Categoria(String laCategoria, double elPrecio, String elTamaño, Tarifa laTarifa)
	{
		this.categoria = laCategoria;
		this.precio = elPrecio;
		this.tamaño = elTamaño;
		this.tarifa = laTarifa;
		
	}
	
}
