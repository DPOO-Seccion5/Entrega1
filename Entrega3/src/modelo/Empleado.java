package modelo;

public class Empleado extends Usuario{
	
	private String nombre;
	
	private String username;
	
	private String password;
	
	private String datosContacto;
	
	private String numeroID;
	
	
	public Empleado(String elNombre,String elUsername, String elPassword, String losDatosContacto, String elNumeroID)
	{
		this.nombre = elNombre;
		this.username = elUsername;
		this.password = elPassword;
		this.datosContacto = losDatosContacto;
		this.numeroID = elNumeroID;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public String getDatosContacto() {
		// TODO Auto-generated method stub
		return datosContacto;
	}

	@Override
	public String getNumeroID() {
		// TODO Auto-generated method stub
		return numeroID;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	
	public void actualizarDatosCarro()
	{
		
	}
	
	public void registrarConductoresAd()
	{
		
	}
	
	public Reserva getReserva()
	{
		return null;
	}
	
	public int getConductoresAdicionales()
	{
		return (Integer) null;
	}
	
	public double getCobroTotal()
	{
		return (Double) null;
	}
	
	
	
	
	

}
