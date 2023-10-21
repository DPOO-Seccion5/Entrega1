package modelo;

public class Tarifa {
	
	private String categoria;
	
	private double tarifaTempAlta;
	
	private double tarifaTempBaja;
	
	private double tarifaOtraSede;
	
	private double tarifaConductorAdicional;
	
	
	public Tarifa(String laCategoria, double laTarifaTempAlta, double laTarifaTempBaja, double laTarifaOtraSede, double laTarifaCondutorAdicional)
	{
		this.categoria = laCategoria;
		this.tarifaTempAlta = laTarifaTempAlta;
		this.tarifaTempBaja = laTarifaTempBaja;
		this.tarifaOtraSede = laTarifaOtraSede;
		this.tarifaConductorAdicional = laTarifaCondutorAdicional;
		
	}

}
