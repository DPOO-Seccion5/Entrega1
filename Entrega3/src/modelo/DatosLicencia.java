package modelo;

public class DatosLicencia {
	
	private String numero;
	
	private String paisExpedicion;
	
	private String fechaNacimiento;
	
	private String imagenDocumento;
	
	
	public DatosLicencia(String elNumero, String elPaisExpedicion, String laFechaNacimiento, String laImagenDocumento)
	{
		this.numero = elNumero;
		this.paisExpedicion = elPaisExpedicion;
		this.fechaNacimiento = laFechaNacimiento;
		this.imagenDocumento = laImagenDocumento;
		
	}

}
