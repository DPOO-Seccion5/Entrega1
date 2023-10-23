package modelo;

import java.util.List;

public class Vehiculo {

	private String marca;
	
	private String placa;
	
	private String modelo;
	
	private String color;
	
	private String tipoTransmision;
	
	
	private Categoria categoria;
	
	
	public Vehiculo(String laMarca, String laPlaca, String elModelo, String elColor, String elTipoTransmision, Categoria laCategoria) 
	{
		this.marca = laMarca;
		this.placa = laPlaca;
		this.modelo = elModelo;
		this.color = elColor;
		this.tipoTransmision = elTipoTransmision;
		this.categoria = laCategoria;
	
	}
	
	public String getMarca()
	{
		return marca;
	}
	
	public String getPlaca()
	{
		return placa;
	}
	
	public String getModelo()
	{
		return modelo;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public String getTipoTransmision()
	{
		return tipoTransmision;
	}
	
	
	public Categoria getCategoria()
	{
		return categoria;
	}
	
}
