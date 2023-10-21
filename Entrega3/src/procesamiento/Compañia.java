package procesamiento;

import java.util.List;

import modelo.*;

public class Compañia {
	
	
	private Inventario inventario;
	
	private List<Sede> sedes;
	
	private List<Cliente> clientes;
	
	
	public Compañia(Inventario elInventario, List<Sede> lasSedes, List<Cliente> losClientes)
	{
		this.inventario = elInventario;
		this.sedes = lasSedes;
		this.clientes = losClientes;
	}
	
	

}
