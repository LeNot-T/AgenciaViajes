package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.util.structure.MyLinkedList;
import co.edu.unbosque.util.structure.Node;

public class AdministradorDAO implements OperacionDAO<Administrador> {

	private MyLinkedList<Administrador> listaAdministradores;
	private final String TEXT_FILE_NAME = "administrador.csv";

	public AdministradorDAO() {
		listaAdministradores = new MyLinkedList<>();

		cargarDesdeArchivo();
	}

	@Override
	public void crear(Administrador nuevoDato) {
		listaAdministradores = new MyLinkedList<>();
		listaAdministradores.addLast(nuevoDato);
		escribirArchivo();

	}

	@Override
	public int eliminar(int index) {
		if (index < 0 || index >= listaAdministradores.size()) {
			return 0;
		}
		if (index == 0) {
			listaAdministradores.extract();
		} else {
			Node<Administrador> previo = listaAdministradores.get(index - 1);
			listaAdministradores.extract(previo);

		}
		escribirArchivo();
		return 1;

	}

	@Override
	public int eliminar(Administrador datoAEliminar) {
		int index = listaAdministradores.indexOf(datoAEliminar);

		return eliminar(index);
	}

	@Override
	public int actualizar(int index, Administrador datoAActualizar) {
		if (index < 0 || index >= listaAdministradores.size()) {
			return 0;
		}
		Node<Administrador> nodo = listaAdministradores.get(index);
		nodo.setInfo(datoAActualizar);
		escribirArchivo();
		return 1;
	}

	@Override
	public String mostrarTodo() {
		return listaAdministradores.toString();
	}

	@Override
	public int cantidad() {
		return listaAdministradores.size();
	}

	@Override
	public int comprobarPosicion(int index) {
		if (index >= 0 && index < listaAdministradores.size()) {
			return 0;
		}
		if (listaAdministradores.get(index) != null) {
			return 1;
		} else {
			return 0;
		}
	}

	public void escribirArchivo() {
		String contenido = "";
		Node<Administrador> actual = listaAdministradores.getFirst();
		while (actual != null) {
			Administrador admin = actual.getInfo();
			contenido += admin.getId() + ";";
			contenido += admin.getNombreUsuario() + ";";
			contenido += admin.getNivelAccseso() + ";";
			contenido += admin.getContrasena() + "\n";
			actual = actual.getNext();

		}

		FileManager.escribirArchivoDeTexto(TEXT_FILE_NAME, contenido);
	}

	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoTexto(TEXT_FILE_NAME);

		if (contenido.isBlank() || contenido.isEmpty()) {
			return;
		}

		String[] fila = contenido.split("\n");
		for (int i = 0; i < fila.length; i++) {
			String[] columna = fila[i].split(";");
			int id = Integer.parseInt(columna[0]);
			String nombreUsuario = columna[1];
			String contrasena = columna[2];
			int nivelAcceso = Integer.parseInt(columna[3]);
			listaAdministradores.add(new Administrador(nombreUsuario, contrasena, nivelAcceso, id));
		}
	}

	public MyLinkedList<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

}
