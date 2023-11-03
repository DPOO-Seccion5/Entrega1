package consola;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import modelo.Cliente;
import modelo.ConductorExtra;
import modelo.DatosLicencia;
import modelo.DatosPago;
import modelo.Empleado;
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

			System.out.println("\nOpciones de la aplicación\n");

			System.out.println("1. Log in");

			System.out.println("2. Sing in");

			System.out.println("3. Salir de la aplicación\n");	


			}

		}

	///////////////////////////////////////////////////////////Log in/////////////////////////////////////

		private void ejecutarLogIn()

		{

			String usuario = input("Por favor digite su usuario");		

			String contraseña = input("Por favor digite su clave");	

			compañia.logIn(usuario,contraseña);

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
				
			}


		}
		
		
		
///////////////////////////////////////////////////////////cargar archivos/////////////////////////////////////

		public void cargar_los_datos() {
			Loader loader = new Loader();
			Compañia compañia = loader.CargarInformacion();	
			
				
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





