package modelo;

public class Cobros {
	
	
	private DatosPago infoTarjeta;
	
	private boolean entregaDondeRecogio;
	
	
	public Cobros(DatosPago laInfoTarjeta, boolean laEntregaDondeRecogio)
	{
		this.infoTarjeta = laInfoTarjeta;
		this.entregaDondeRecogio = laEntregaDondeRecogio;
		
	}
	
	
	public DatosPago getInfoTarjeta()
	{
		return infoTarjeta;
	}
	
	public boolean getEntregaDondeRecogio()
	{
		return entregaDondeRecogio;
	}
	

}
