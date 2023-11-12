package consola;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import modelo.*;
import procesamiento.Compañia;
import procesamiento.Loader;

public class Consola {
	
	

		private Compañia compañia;
		private Loader cargaDatos;

	///////////////////////////////////////////////////////////Aplicacion/////////////////////////////////////

		public void ejecutarAplicacion()

		{

			System.out.println("Bienvenido a Alquiler y reservas de carros");

	 

			boolean continuar = true;

			while (continuar)

			{

				try

				{

					mostrarMenu();

					int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));

					if (opcion_seleccionada == 1)

						cargar_los_datos();

					else if (opcion_seleccionada == 2)

						menuRegistro();

					else if (opcion_seleccionada == 3)

					{

						System.out.println("Saliendo de la aplicación ...");

						continuar = false;

					}


					else

					{

						System.out.println("Por favor seleccione una opción válida.");

					}

				}

				catch (NumberFormatException e)

				{

					System.out.println("Debe seleccionar uno de los números de las opciones.");

				}

			}

		}

	 

	 

	///////////////////////////////////////////////////////////menuPrincipal/////////////////////////////////////

		public void mostrarMenu()

		{   


			System.out.println("\nOpciones de la aplicación\n");

			System.out.println("1. Cargar un archivo de Reservas y Alquiler");

			System.out.println("2. Registrarse");

			System.out.println("3. Salir de la aplicación\n");

	}


	///////////////////////////////////////////////////////////menuRegistro/////////////////////////////////////

		public void menuRegistro()

		{

			System.out.println("\nOpciones de la aplicación\n");

			System.out.println("1. Log in");

			System.out.println("2. Sing in");

			System.out.println("3. Salir de la aplicación\n");	

			boolean continuar = true;


			while (continuar)

			{

				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));

				if (opcion_seleccionada == 1)

					ejecutarLogIn();

				else if (opcion_seleccionada == 2)

					ejecutarSingIn();

				else if (opcion_seleccionada == 3)

				{

					System.out.println("Saliendo de la aplicación ...");

					continuar = false;

			}	

		

			}

		}
		

	///////////////////////////////////////////////////////////Log in/////////////////////////////////////

		private void ejecutarLogIn()

		{

			String usuario = input("Por favor digite su usuario");		

			String contraseña = input("Por favor digite su clave");	
			
			if (usuario.contains("empleado"))
			{
				Empleado elEmpleado = compañia.logInEmpleado(usuario, contraseña);
				
				ejecutarManejoVehiculo(elEmpleado);
			}
			else if (usuario.contains("administrador"))
			{
				ejecutarMenuAdmin();
			}
			else
			{

				Cliente elCliente = compañia.logIn(usuario,contraseña);
			
				String reserva = input("Desea crear una reserva?");
			
				if (reserva.equals("si"))
				{
					ejecutarCrearReserva(elCliente);			
				}
				else
				{
					String modificacion = input("Desea modificar su reserva?");
					if (modificacion.equals("si"))
					{
						ejecutarModificarReserva(elCliente);
					}
				}
				
			}
		}

		
		
///////////////////////////////////////////////////////////Menu admin///////////////////////////////////////////////

		public void ejecutarMenuAdmin()
		{
			String x = input("Desea añadir o eliminar un vehiculo? añadir/eliminar");
			
			if (x.equals("añadir"))
			{
				String nombre = input("Ingrese el nombre del vehiculo");

				String marca = input("Ingrese la marca del vehiculo");
				
				String placa= input("Ingrese la placa del vehiculo");
				
				String modelo = input("Ingrese el modelo del vehiculo");
				
				String color = input("Ingrese el color del vehiculo");
				
				String tipoTransmision = input("Ingrese el tipo de transimision del vehiculo");
				
				String ubicacion = input("Ingrese el nombre del vehiculo");
				
				String categoria = input("Ingrese la categoria del vehiculo");
				
				double precio = Integer.parseInt(("Ingrese el precio del vehiculo"));
				
				String tamaño = input("Ingrese el tamaño del vehiculo");
				
				double tarifaTempAlta = Integer.parseInt(("Ingrese la tarifa temporada alta del vehiculo"));
				
				double tarifaTempBaja = Integer.parseInt(("Ingrese la tarifa tempordad baja del vehiculo"));
				
				double tarifaOtraSede = Integer.parseInt(("Ingrese la tarifa cambio de sede del vehiculo"));
				
				double tarifaConductorAdicional = Integer.parseInt(("Ingrese la tarifa conductor adicional del vehiculo"));
							
			}
			else if(x.equals("eliminar"))
			{
				String laPlaca = input("Ingrese la placa del vehiculo que desea eliminar");
				
				compañia.eliminarVehiculo(laPlaca);
				
			}
			
		}
		
///////////////////////////////////////////////////////////Manejo de los vehiculos///////////////////////////////////////////////
		
		public void ejecutarManejoVehiculo(Empleado empleado)
		{
			String placa = input("Ingrese la placa del vehiculo que desea buscar");
			
			Vehiculo vehiculo = compañia.buscarVehiculo(placa);
			
			String respuesta = compañia.conocerDisponibilidad(vehiculo);
			
			System.out.println(respuesta);
			
			String mantenimiento = input("Desea enviar el vehiculo a mantenimiento? si/no");
			
			if (mantenimiento.equals("si"))
			{
				String fechaDisponible = input("Ingrese la nueva fecha de disponibilidad del vehiculo");
				Disponibilidad dispo = vehiculo.getDisponibilidad();
				dispo.setFechaDevolucion(fechaDisponible);
				
			}
			
			
		}
		

	///////////////////////////////////////////////////////////Sing in/////////////////////////////////////

		private void ejecutarSingIn()
		{
			String respuesta = input("Es cliente o empleado?");
			Loader loader = new Loader();
			
			if (respuesta.equals("cliente"))
			{
				String nombre = input("Por favor digite su nombre");
				String fechaNacimiento = input("Por favor digite su fecha de nacimiento");
				String nacionalidad = input("Por favor digite su nacionalidad");
				String username = input("Por favor digite su username");
				String password = input("Por favor digite su password");
				String numID = input("Por favor digite su numero de identificacion");
				System.out.println("Datos de la licencia:");
				String numero = input("Por favor digite el numero de su licencia");
				String paisExpedicion = input("Por favor digite el pais de expedicion de su licencia");
				System.out.println("Datos de pago:");
				String numeroTarjeta = input("Por favor digite el numero de la tarjeta");
				String fechaVenicimiento = input("Por favor digite la fecha de vencimiento");
				String nombreTitular = input("Por favor digite el nombre del titular");
				String cvc = input("Por favor digite el codigo de seguridad");
				
				Cliente informacion = compañia.crearCliente(nombre, numID, fechaNacimiento, nacionalidad, username, password, numero, paisExpedicion, numeroTarjeta, fechaVenicimiento, nombreTitular, cvc);
				
				if (informacion != null)
					System.out.println("Se creo correctamente el usuario!");
				else
					System.out.println("No se creo el usuario");
				
			}
			else if (respuesta.equals("empleado")) 
			{
				String nombre = input("Por favor digite su nombre");
				String username = input("Por favor digite su username");
				String password = input("Por favor digite su password");
				String numID = input("Por favor digite su numero de identificacion");	
				String fechaNacimiento = input("Por favor digite su fecha de nacimiento");
				String nacionalidad = input("Por favor digite su nacionalidad");
				
				Empleado nuevoEmpleado = compañia.crearEmpleado(nombre, username, password, numID, nacionalidad, fechaNacimiento);
				if (nuevoEmpleado != null)
					System.out.println("Se creo correctamente el usuario!");
				else
					System.out.println("No se creo el usuario");
				
			}
			
			ejecutarLogIn();
			


		}
		
///////////////////////////////////////////////////////////Creacion de Reserva////////////////////////////////////////////////
		
		public void ejecutarCrearReserva(Cliente cliente)
		{
			String categoria = input("Que categoria de vehiculo desea reservar?");
			
			System.out.println("Si no sabe los siguientes datos por favor escriba 'n/a' y podra modificarlos despues.");
			
			String sedeRecogida = input("En que sede recogera el vehiculo?");
			
			String sedeDevuelta = input("En que sede devolvera el vehiculo?");
			
			String fecha = input("En que fecha recogera el vehiculo?");
			
			String rangoHoras = input("En que rango de horas recogera el vehiculo?");
			
			String temporada = input("En que temporada va a tomar el vehiculo? alta/baja");
			
			DatosPago datoTarjeta = cliente.getDatosMetodoPago();
			
			Cobros cobro = new Cobros(datoTarjeta);
			
			int numConExtra = Integer.parseInt(input("Cuantos conductores extra van a usar el vehiculo (si es el unico conductor escriba 0)"));
			
			ArrayList<ConductorExtra> lista = null;
			for (int i = 0;i<numConExtra;i++)
			{
				System.out.println("Ingreso de informacion de conductores extra:");
				String numero = input("Ingrese el numero de la licencia de conducir");
				String pais = input("Ingrese el pais de expedicion");
				String fechaL = input("Ingrese la fecha de vencimiento");
				DatosLicencia licencia = new DatosLicencia(numero,pais,fechaL);
				ConductorExtra conductor = new ConductorExtra(licencia);
				lista.add(conductor);
			}
			
			
			
			double precio = compañia.crearReserva(cliente, categoria, sedeRecogida, sedeDevuelta, cobro, fecha, rangoHoras,temporada, lista);
			precio = precio*0.3;
			System.out.println("Se hara el cobro del 30% que suma: "+precio);
	
		}
		

///////////////////////////////////////////////////////////Modificacion de Reserva////////////////////////////////////////////////
		
		public void ejecutarModificarReserva(Cliente cliente)
		{
			boolean x = true;
			while (x)
			{ 
				System.out.println("Que desea modificar entre:");
				System.out.println("1. Sede de recogida");
				System.out.println("2. Sede de entrega");
				System.out.println("3. Fecha de entrega");
				System.out.println("4. Rango de horas");
				
				String opcion = input("Escriba el numero de la opcion que desea");
				
				String modificacion = input("Escriba la modificacion");
				
				compañia.modificarReserva(cliente, modificacion, opcion);
				
				String bucle = input("Quiere modificar algo mas? si/no");
				
				if (bucle.equals("no"))
				{
					x = false;
				}
				
				
			}
		}
		
///////////////////////////////////////////////////////////cargar archivos/////////////////////////////////////

		public void cargar_los_datos() {
			Loader loader = new Loader();
			compañia = loader.CargarInformacion();	
			
			
				
		}
	 

	///////////////////////////////////////////////////////////input/////////////////////////////////////

		public String input(String mensaje)

		{

			try

			{

				System.out.print(mensaje + ": ");

				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

				return reader.readLine();

			}

			catch (IOException e)

			{

				System.out.println("Error leyendo de la consola");

				e.printStackTrace();

			}

			return null;

		}

	 

	///////////////////////////////////////////////////////////main/////////////////////////////////////

		public static void main(String[] args)

		{

		Consola consola = new Consola();

		consola.ejecutarAplicacion();
		
		

		}



	}





