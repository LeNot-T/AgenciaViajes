package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.view.Consola;

public class Controller {

	private Consola con;
	private ModelFacade mf;

	public Controller() {
		con = new Consola();
		mf = new ModelFacade();
	}

	public void run() {
		mainLoop: while (true) {

			System.out.println("Bienvenido, escoga una opción");
			System.out.println("1. Crear usuario");
			System.out.println("2. Actualizar usuario.");
			System.out.println("3. Eliminar usuario");
			System.out.println("4. Mostrar usuarios");
			System.out.println("5. Salir.");

			int opcion = con.leerEntero();
			switch (opcion) {
			// Crear
			case 1: {
				con.quemarLinea();
				System.out.print("Digite su nombre: ");
				String nombre = con.leerLinea();
				System.out.print("Digite su usuario: ");
				String nombreUsuario = con.leerLinea();
				System.out.print("Digite su correo: ");
				String correo = con.leerLinea();
				System.out.print("Digite su número de telefono: ");
				long telefono = con.leerLong();
				con.quemarLinea();
				System.out.print("Digite su contraseña: ");
				String contrasena = con.leerLinea();

				mf.getUsuarioDAO().Crear(new Usuario(nombre, nombreUsuario, correo, telefono, contrasena));

				break;
			}

			// Actualizar usuario
			case 2: {
				con.quemarLinea();
				System.out.print("Que usuario desea actualizar? ");
				String nombreUsuario = con.leerLinea();
				Usuario usuarioEncontrado = mf.getUsuarioDAO().find(nombreUsuario);

				if (usuarioEncontrado != null) {

					System.out.println("Usuario encontrado. Ingrese nuevos datos:");

					System.out.println("Nombre:");
					String nuevoNombre = con.leerLinea();

					System.out.println("Correo:");
					String nuevoCorreo = con.leerLinea();

					System.out.println("Telefono:");
					long nuevoTelefono = con.leerLong();

					con.quemarLinea();
					System.out.println("Contraseña:");
					String nuevaContrasena = con.leerLinea();

					Usuario actualizado = new Usuario(nuevoNombre, nombreUsuario, nuevoCorreo, nuevoTelefono,
							nuevaContrasena);

					int index = mf.getUsuarioDAO().getListaUsuarios().indexOf(usuarioEncontrado);

					mf.getUsuarioDAO().Actualizar(index, actualizado);

					System.out.println("Usuario actualizado.");

				} else {
					System.out.println("Usuario no encontrado.");
				}
				break;
			}

			// Eliminar usuario
			case 3: {
				con.quemarLinea();
				System.out.print("Ingrese el usuario que desea eliminar: ");
				String nombreUsuario = con.leerLinea();

				Usuario encontrado = mf.getUsuarioDAO().find(nombreUsuario);

				if (encontrado != null) {

					int resultado = mf.getUsuarioDAO().Eliminar(encontrado);

					if (resultado == 0) {
						System.out.println("Usuario eliminado correctamente.");
					} else {
						System.out.println("Error al eliminar el usuario.");
					}

				} else {
					System.out.println("Usuario no encontrado.");
				}
				break;

			}

			// Mostrar usuarios
			case 4: {
				System.out.println("Mostrando usuarios...");
				con.imprimirConSalto(mf.getUsuarioDAO().MostrarTodo());
				break;
			}

			// Salir
			case 5: {
				System.out.println("Tenga un buen día.");
				break mainLoop;
			}

			default: {
				System.out.println("The fuck did you do.");
				break;
			}
			}
		}
	}

}
