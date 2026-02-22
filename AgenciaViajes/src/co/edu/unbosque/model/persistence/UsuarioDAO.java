package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.util.structure.MyLinkedList;
import co.edu.unbosque.util.structure.Node;

public class UsuarioDAO implements OperacionDAO<Usuario> {
	
	private MyLinkedList<Usuario> listaUsuarios;
	private final String TEXT_FILE_NAME = "usuario.csv";
	
	
	public UsuarioDAO() {
		FileManager.crearCarpeta();
		listaUsuarios = new MyLinkedList<>();
		cargarDesdeArchivo();
	}
	
	public MyLinkedList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}



	public void setListaUsuarios(MyLinkedList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}



	@Override
	public void Crear(Usuario nuevoDato) {

		if (find(nuevoDato.getNombreUsuario()) != null) {
		    System.out.println("El nombre de usuario ya existe.");
		    return;
		}

	    listaUsuarios.addLast(nuevoDato);
	    EscribirEnArchivo();
	    System.out.println("Usuario creado con éxito.");
	}

	@Override
	public int Eliminar(int index) {

	    if (index < 0 || index >= listaUsuarios.size()) {
	        return 1;
	    }

	    if (index == 0) {
	        listaUsuarios.extract();
	    } else {
	        Node<Usuario> previous = listaUsuarios.get(index - 1);
	        listaUsuarios.extract(previous);
	    }

	    EscribirEnArchivo();
	    return 0;
	}
	
	@Override
	public int Eliminar(Usuario datoAEliminar) {

	    int index = listaUsuarios.indexOf(datoAEliminar);

	    if (index == -1) {
	        return 1;
	    }

	    return Eliminar(index);
	}
	
	@Override
	public Usuario find(String nombreUsuario) {
		if (listaUsuarios.isEmpty()) {
	        return null;
	    }

	    Node<Usuario> current = listaUsuarios.getFirst();

	    while (current != null) {

	        Usuario usuario = current.getInfo();

	        if (usuario.getNombreUsuario().equals(nombreUsuario)) {
	            return usuario;
	        }

	        current = current.getNext();
	    }

	    return null;
	}

	@Override
	public int Actualizar(int index, Usuario nuevoDato) {

	    Node<Usuario> node = listaUsuarios.get(index);

	    if (node == null) {
	        return 1;
	    }

	    node.setInfo(nuevoDato);

	    EscribirEnArchivo();
	    return 0;
	}

	@Override
	public String MostrarTodo() {
		
		if(listaUsuarios.isEmpty()) {
			return "No hay usuarios registrados.";
		}

	    String salida = "";
	    Node<Usuario> current = listaUsuarios.getFirst();

	    while (current != null) {
	        salida += current.getInfo().toString() + "\n";
	        current = current.getNext();
	    }

	    return salida;
	}

	@Override
	public int Cantidad() {
		return listaUsuarios.size();
	}
	
	public void EscribirEnArchivo() {

	    String contenido = "";
	    Node<Usuario> current = listaUsuarios.getFirst();

	    while (current != null) {

	        Usuario u = current.getInfo();

	        contenido += u.getNombre() + ";";
	        contenido += u.getNombreUsuario() + ";";
	        contenido += u.getCorreo() + ";";
	        contenido += u.getTelefono() + ";";
	        contenido += u.getContrasena() + "\n";

	        current = current.getNext();
	    }

	    FileManager.escribirArchivoDeTexto(TEXT_FILE_NAME, contenido);
	}
	
	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoDeTexto(TEXT_FILE_NAME);
		
		if (contenido == null || contenido.isBlank()) {
	        return;
	    }
		
		String [] filas = contenido.split("\n");
		for (String fila : filas) {

	        if (fila.isBlank()) continue;

	        String[] columnas = fila.split(",");

	        if (columnas.length < 5) continue;

	        String nombre = columnas[0];
	        String nombreUsuario = columnas[1];
	        String correo = columnas[2];
	        long telefono = Long.parseLong(columnas[3]);
	        String contrasena = columnas[4];
			listaUsuarios.addLast(new Usuario(nombre, nombreUsuario, correo, telefono, contrasena));
			
		}
	}
}
