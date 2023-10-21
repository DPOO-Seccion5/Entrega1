package modelo;

public class DatosPago {
	
	private String numero;
	
	private String fechaVencimiento;
	
	private String nombreTitular;
	
	private String numSeguridad;
	
	
	public DatosPago(String elNumero, String laFechaVencimiento, String elNombreTitular, String elNumSeguridad)
	{
		this.numero = elNumero;
		this.fechaVencimiento = laFechaVencimiento;
		this.nombreTitular = elNombreTitular;
		this.numSeguridad = elNumSeguridad;
	}

}
