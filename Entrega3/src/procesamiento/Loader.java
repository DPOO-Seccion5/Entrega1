package procesamiento;
import java.io.*;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;
import java.util.Map.Entry;

import modelo.Categoria;
import modelo.Cliente;
import modelo.ConductorExtra;
import modelo.DatosLicencia;
import modelo.DatosPago;
import modelo.Disponibilidad;
import modelo.Empleado;
import modelo.Inventario;
import modelo.Sede;
import modelo.Tarifa;
import modelo.Vehiculo;

public class Loader {

		

		public Loader() {

			}

		public Compañia CargarInformacion() {

		

			ArrayList listaSedes = new ArrayList();
			
			ArrayList inventario = new ArrayList();
			
			ArrayList listaClientes = new ArrayList();
			
			ArrayList listaEmpleados = new ArrayList();

			Map<String, Sede> sedes=CargarInformacionSedes();
			
			for (Sede sede : sedes.values())
			{
				listaSedes.add(sede);
			}
			
			
			

		

			Map<String,Vehiculo> carros = CargarCarros();
			
			
			
			for (Vehiculo carro : carros.values())
			{
				inventario.add(carro);
			}
			
			Inventario inventario1 = new Inventario(inventario);
			
			
			
			
			

			Map<String, Cliente> clientes = CargarListaClientes();
			
			for (Cliente cliente: clientes.values())
			{
				listaClientes.add(cliente);
			}


			Map<String, Empleado> empleados = CargarListaEmpleados();
			
			for (Empleado empleado : empleados.values())
			{
				listaEmpleados.add(empleado);
			}
			
			
			

			
			Compañia compañia = new Compañia(inventario1,listaSedes,listaClientes,listaEmpleados);
			System.out.println(compañia);
			
			

			
			

			return compañia;

			

			

		}

		

		

		private Map<String, String> CargarCarrosPorCategoria(){

			Map<String, String> titleInfoMap = new HashMap<>();

			try {

			

	         BufferedReader reader = new BufferedReader(new FileReader("./Data/carrosPorCategoria"));

	         String line;

	 

	         while ((line = reader.readLine()) != null) {

	             String[] parts = line.split("=");

	             if (parts.length == 2) {

	                 String title = parts[0];

	                 String info = parts[1];

	                 titleInfoMap.put(title, info);

	                 

	             }

	         }

	         reader.close();

	         

			}

			catch(IOException e){

				e.printStackTrace();

				

			}

			

			return titleInfoMap;

			

		}

		private void addCarrosPorCategoria(String nombreSede,String infoSede) {

			Map<String, String>  map = CargarCarrosPorCategoria();

			map.put(nombreSede, infoSede);

			saveCarrosPorCategoria(map);

		}

		

		private void deleteCarrosPorCategoria(String nombreSede) {

			Map<String, String>  map = CargarCarrosPorCategoria();

			

			 if (map.containsKey(nombreSede)) {

	             map.remove(nombreSede);

			 }

			 saveCarrosPorCategoria(map);

		}

		

		private void editCarrosPorCategoria(String nombreSede, String infoEditada) {

			Map<String, String>  map = CargarCarrosPorCategoria();

			if (map.containsKey(nombreSede)) {

	            String editedInfo = infoEditada;

	            map.put(nombreSede, editedInfo);

			}

			saveCarrosPorCategoria(map);

			

		}

		private void saveCarrosPorCategoria(Map<String, String> map) {

			 try {

			 BufferedWriter writer = new BufferedWriter(new FileWriter("./Data/carrosPorCategoria"));

	         for (Map.Entry<String, String> entry : map.entrySet()) {

	             writer.write(entry.getKey() + "=" + entry.getValue() + "\n");

	         }

	         writer.close();

	 

	         System.out.println("Documento Editado correctamente.");

			 }

			 catch(IOException e){

					e.printStackTrace();

					

				}

		}

		

		

		private Map<String, Vehiculo> CargarCarros(){

			Map<String, Vehiculo> titleInfoMap = new HashMap<>();
			boolean alquilado = false;

			try {

	         BufferedReader reader = new BufferedReader(new FileReader("./Data/carrosInformacion"));

	         String line;
	 

	         while ((line = reader.readLine()) != null) {

	             String[] parts = line.split("=");
	             
	          

	             if (parts.length == 2) {
	            	 

	                 String title = parts[0];

	                 String info = parts[1];
	                 String[] parts1 = parts[1].split(";");
	                 
	                 
	                 String marca = parts1[0];
	                 String placa = parts1[1];
	                 String modelo = parts1[2];
	                 String color = parts1[3];
	                 String transmision = parts1[4];
	                 
	                 String datosCategoria = parts1[5].replace("{", "");
	                 datosCategoria = datosCategoria.replace("}", "");
	               
	         
	                 
	                 String[] datosCategoria1 = datosCategoria.split(",");
	                 String nombre = datosCategoria1[0];
	                 int precio = Integer.parseInt(datosCategoria1[1]);
	                 String tamaño = datosCategoria1[2];
	            
	                 int tarifaAlta = Integer.parseInt(datosCategoria1[3]);
	                 int tarifaBaja = Integer.parseInt(datosCategoria1[4]);
	                 int tarifaSede = Integer.parseInt(datosCategoria1[5]);
	                 int tarifaConductor = Integer.parseInt(datosCategoria1[6]);
	                 
	                 Tarifa tarifa = new Tarifa(tarifaAlta,tarifaBaja,tarifaSede,tarifaConductor);
	                         
	                 Categoria categoria = new Categoria(nombre,precio,tamaño,tarifa);
	                 
	                 String datosDisp = parts1[6].replace("{", "");
	                 datosDisp = datosDisp.replace("}", "");
	                 
	                 String[] datosDisp1 = datosDisp.split(",");
	                
	                 if (datosDisp1[0].equals("false"))
	                 {
	                	 alquilado = false;
	                 }
	                 else if(datosDisp1[0].equals("true"))
	                 {
	                	 alquilado = true;
	                 }
	                 String ubicacion = datosDisp1[1];
	                 String fechaDev = datosDisp1[2];
	                 String lugarDev = datosDisp1[3];
	                 String fechaDesp = datosDisp1[4];
	                 
	                 Disponibilidad dispo = new Disponibilidad(alquilado,ubicacion,fechaDev,lugarDev,fechaDesp);
	                 
	                 
	                     
	                 Vehiculo vehiculo = new Vehiculo(title,marca,placa,modelo,color,transmision,categoria,dispo);
	                 
	                 
	                 titleInfoMap.put(title, vehiculo);

	               

	             }

	         }

	         reader.close();

	         

			}

			catch(IOException e){

				e.printStackTrace();

				

			}

			return titleInfoMap;

			

		}

		

		

		public static void addCarros(String nombre,Vehiculo vehiculo)
		{
			String file = "./Data/carrosInformacion";
		
			String marca = vehiculo.getMarca();
			String placa = vehiculo.getPlaca();
			String modelo = vehiculo.getModelo();
			String color = vehiculo.getColor();
			String tipoTrans = vehiculo.getTipoTransmision();
			
			Disponibilidad disp = vehiculo.getDisponibilidad();
			boolean alquilado = disp.getIfAlquilado();
			String ubicacion = disp.getUbicacion();
			String fechaDev = disp.getFechaDevolucion();
			String lugarDev = disp.getLugarDevolucion();
			String fechaDis = disp.getFechaDisponibilidad();
			
			Categoria cat = vehiculo.getCategoria();
			String nomCat = cat.getCategoria();
			double precio = cat.getPrecio();
			String tamaño = cat.getTamaño();
			
			Tarifa taf = cat.getTarifa();	
			double tarAlta = taf.getTarifaAlta();
			double tarBaja = taf.getTarifaBaja();
			double otraSede = taf.getTarifaOtraSede();
			double conAd = taf.getTarifaConductor();
			
			String nuevaLinea = nombre+"="+marca+";"+placa+";"+modelo+";"+color+";"+tipoTrans+";"+"{"+nomCat+","+precio+","+tamaño+","+"{"+tarAlta+","+tarBaja+","+otraSede+","+conAd+"}"+";"+"{"+alquilado+","+ubicacion+","+fechaDev+","+lugarDev+","+fechaDis+"}";

			try {
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
				bufferedWriter.write(nuevaLinea);
				bufferedWriter.newLine();
				
				bufferedWriter.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		

		/*public void deleteCarros(String nombreSede) {

			Map<String, Vehiculo>  map = CargarCarros();

			

			 if (map.containsKey(nombreSede)) {

	             map.remove(nombreSede);

			 }

			 saveCarros(map);

		}

		

		public void editCarros(String nombreSede, Vehiculo infoEditada) {

			Map<String, Vehiculo>  map = CargarCarros();

			if (map.containsKey(nombreSede)) {

	            Vehiculo editedInfo = infoEditada;

	            map.put(nombreSede, editedInfo);

			}

			saveCarros(map);

			

		}

		public void saveCarros(Map<String, Vehiculo> map) {

			 try {

			 BufferedWriter writer = new BufferedWriter(new FileWriter("./Data/carrosInformacion"));

	         for (Entry<String, Vehiculo> entry : map.entrySet()) {

	             writer.write(entry.getKey() + "=" + entry.getValue() + "\n");

	         }

	         writer.close();

	 

	         System.out.println("Documento Editado correctamente.");

			 }

			 catch(IOException e){

					e.printStackTrace();

					

				}

		}
		*/

		

		

		

		private Map<String, Cliente> CargarListaClientes(){

			Map<String, Cliente> titleInfoMap = new HashMap<>();

			try {

			

	         BufferedReader reader = new BufferedReader(new FileReader("./Data/listaClientes"));

	         String line;

	 

	         while ((line = reader.readLine()) != null) {

	             String[] parts = line.split("=");
	             
	             
	             if (parts.length == 2) {

	                 String title = parts[0];
	                 String info = parts[1];
	                 
	                 

	                 
	                 String[] parts1 = info.split(";");
	                 
	                 
	                 
	                
	                 String nombre = parts1[0];
	                 String fecha = parts1[1];
	               	 String numId = parts1[2];
	               	 String nacionalidad = parts1[3];
	               	 String password = parts1[4];
	                
	               	 String datosTarjeta = parts1[5].replace("{", "");
	               	 datosTarjeta = datosTarjeta.replace("}", "");
	               	 String[] datosTarjeta1 = datosTarjeta.split(",");
	               	 
	               	 String numeroTar = datosTarjeta1[0];
	               	 String fechaVencimiento = datosTarjeta1[1];
	               	 String nombreTar = datosTarjeta1[2];
	               	 String cvc = datosTarjeta1[3];
                	 DatosPago claseTarjeta = new DatosPago(numeroTar,fechaVencimiento,nombreTar,cvc);
	               
                	 String datosLicencia = parts1[6].replace("{", "");
	               	 datosLicencia = datosLicencia.replace("}", "");
	               	 String[] datosLicencia1 = datosLicencia.split(",");
	               	 String numeroLic = datosLicencia1[0];
	               	 String paisExpedicion = datosLicencia1[1];
	               	 String fechaVen = datosLicencia1[2];
	               	 DatosLicencia claseLicencia = new DatosLicencia(numeroLic,paisExpedicion,fechaVen);
	                 
	               	 
	               	 Cliente cliente = new Cliente(nombre,numId,fecha,nacionalidad,title,password,claseLicencia,claseTarjeta, null);
	                 

                	 titleInfoMap.put(title, cliente);
                	 
	                 
	                 

	             }

	         }

	         reader.close();

	         

			}

			catch(IOException e){

				e.printStackTrace();

				

			}

			

			return titleInfoMap;

			

		}
		
		
		public static void saveCliente(String nombre,String numID, String fechaNacimiento, String nacionalidad, String username, String password, String numeroLicencia, String paisExpedicion,String numeroTarjeta, String fechaVencimiento, String nombreTitular, String cvc)
		{
			FileWriter fw = null;
			BufferedWriter bw = null;
					
			
			try {
				String data = username +"="+nombre+";"+fechaNacimiento+";"+numID+";"+nacionalidad+";"+password+";"+"{"+numeroTarjeta+","+fechaVencimiento+","+nombreTitular+","+cvc+"}"+";"+"{"+numeroLicencia+","+paisExpedicion+","+fechaNacimiento+"}";
				
				File file = new File("./Data/listaClientes");
				fw = new FileWriter(file.getAbsoluteFile(),true);
				bw = new BufferedWriter(fw);
				bw.write(data);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					if (bw != null)
						bw.close();
					if (fw != null)
						fw.close();
					
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}
				
			}
			
	
			
		}

		

		

		

		/*public void deleteClientes(String nombreSede) {

			Map<String, Cliente>  map = CargarListaClientes();

			

			 if (map.containsKey(nombreSede)) {

	             map.remove(nombreSede);

			 }

			 saveClientes(map);

		}

		

		private void editClientes(String nombreSede, Cliente infoEditada) {

			Map<String, Cliente>  map = CargarListaClientes();

			if (map.containsKey(nombreSede)) {

	            Cliente editedInfo = infoEditada;

	            map.put(nombreSede, editedInfo);

			}

			saveClientes(map);

			

		}

		private void saveClientes(Map<String, Cliente> map) {

			 try {

			 BufferedWriter writer = new BufferedWriter(new FileWriter("./Data/listaClientes"));

	         for (Map.Entry<String, Cliente> entry : map.entrySet()) {

	             writer.write(entry.getKey() + "=" + entry.getValue() + "\n");

	         }

	         writer.close();

	 

	         System.out.println("Documento Editado correctamente.");

			 }

			 catch(IOException e){

					e.printStackTrace();

					

				}

		}
		*/

		

		

		private Map<String, Empleado> CargarListaEmpleados(){

			Map<String, Empleado> titleInfoMap = new HashMap<>();

			try {

			

	         BufferedReader reader = new BufferedReader(new FileReader("./Data/listaEmpleados"));

	         String line;

	 

	         while ((line = reader.readLine()) != null) {

	             String[] parts = line.split("=");

	             if (parts.length == 2) {

	                 String title = parts[0];

	                 String info = parts[1];
	                 
	                 String[] parts1 = parts[1].split(";");
	                 
	                 String nombre = parts1[0];
	                 String fecha = parts1[1];
	                 String numId = parts1[2];
	                 String nacionalidad = parts1[3];
	                 String password = parts1[4];
	                 
	                 Empleado empleado = new Empleado(nombre,title,password,numId,fecha,nacionalidad);
	                 

	                 titleInfoMap.put(title, empleado);


	             }

	         }

	         reader.close();

	         

			}

			catch(IOException e){

				e.printStackTrace();

				

			}

			

			return titleInfoMap;

			

		}

		

		/*private void addEmpleados(String nombreSede,Empleado infoSede) {

			Map<String, Empleado>  map = CargarListaEmpleados();

			map.put(nombreSede, infoSede);

			saveEmpleados(map);

		}

		

		private void deleteEmpleados(String nombreSede) {

			Map<String, Empleado>  map = CargarListaEmpleados();

			

			 if (map.containsKey(nombreSede)) {

	             map.remove(nombreSede);

			 }

			 saveEmpleados(map);

		}

		

		private void editEmpleados(String nombreSede, Empleado infoEditada) {

			Map<String, Empleado>  map = CargarListaEmpleados();

			if (map.containsKey(nombreSede)) {

	            Empleado editedInfo = infoEditada;

	            map.put(nombreSede, editedInfo);

			}

			saveEmpleados(map);

			

		}
		*/

		public static void saveEmpleado(String nombre,String username,String password,String numID,String nacionalidad,String fechaNacimiento)
		{

			FileWriter fw = null;
			BufferedWriter bw = null;
					
			
			try {
				String data = username +"="+nombre+";"+fechaNacimiento+";"+numID+";"+nacionalidad+";"+password;
				
				File file = new File("./Data/listaEmpleados");
				fw = new FileWriter(file.getAbsoluteFile(),true);
				bw = new BufferedWriter(fw);
				bw.write(data);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					if (bw != null)
						bw.close();
					if (fw != null)
						fw.close();
					
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}
				
			}

		}

		

		

		

		private Map<String, Sede> CargarInformacionSedes() {

			Map<String, Sede> titleInfoMap = new HashMap<>();

			try {

			

	         BufferedReader reader = new BufferedReader(new FileReader("./Data/datosSede"));

	         String line;

	 

	         while ((line = reader.readLine()) != null) {

	             String[] parts = line.split("=");

	             if (parts.length == 2) {

	                 String title = parts[0];

	                 String info = parts[1];
	                 
	                 String[] parts1 = parts[1].split(";");
	                 
	                 String ubicacion = parts1[0];
	                 String horaAtencion = parts1[1];
	                 String empleados = parts1[2].replace("{", "");
	                 empleados = empleados.replace("}", "");
	                 String[] empleados1 = empleados.split(",");    
	                 
	                 Sede sede = new Sede(title,ubicacion,horaAtencion,empleados1);

	                 titleInfoMap.put(title, sede);

	                 

	             }

	         }

	         reader.close();

	         

			}

			catch(IOException e){

				e.printStackTrace();

				

			}

			

			return titleInfoMap;	

			

		}

		private void addInfoSede(String nombreSede,Sede infoSede) {

			Map<String, Sede>  map = CargarInformacionSedes();

			map.put(nombreSede, infoSede);

			saveInfoSede(map);

		}

		

		private void deleteInfoSede(String nombreSede) {

			Map<String, Sede>  map = CargarInformacionSedes();

			

			 if (map.containsKey(nombreSede)) {

	             map.remove(nombreSede);

			 }

			 saveInfoSede(map);

		}

		

		private void editInfoSede(String nombreSede, Sede infoEditada) {

			Map<String, Sede>  map = CargarInformacionSedes();

			if (map.containsKey(nombreSede)) {

	            Sede editedInfo = infoEditada;

	            map.put(nombreSede, editedInfo);

	            

	        }

			saveInfoSede(map);

			

		}

		private void saveInfoSede(Map<String, Sede> map) {

			 try {

			 BufferedWriter writer = new BufferedWriter(new FileWriter("./Data/datosSede"));

	         for (Map.Entry<String, Sede> entry : map.entrySet()) {

	             writer.write(entry.getKey() + "=" + entry.getValue() + "\n");

	         }

	         writer.close();

	 

	         System.out.println("Documento Editado correctamente.");

			 }

			 catch(IOException e){

					e.printStackTrace();

					

				}

		}

		

	}



