package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.structure.MyLinkedList;
import co.edu.unbosque.util.structure.Node;

public class AdminViaje {

	private MyLinkedList<Viaje> lista;
	private final String FILE_NAME = "viajes.bin";

	public AdminViaje() {
		FileHandler.checkFolder();
		cargar();
	}

	// CREATE
	public void agregarViaje(Viaje viaje) {
		lista.addLast(viaje);
		guardar();
	}

	// READ
	public MyLinkedList<Viaje> getLista() {
		return lista;
	}

	// UPDATE
	public boolean actualizarViaje(String nombre, Viaje nuevoViaje) {

		Node<Viaje> current = lista.getFirst();

		while (current != null) {

			if (current.getInfo().getNombre().equals(nombre)) {
				current.setInfo(nuevoViaje);
				guardar();
				return true;
			}

			current = current.getNext();
		}

		return false;
	}

	// DELETE
	public boolean eliminarViaje(String nombre) {

		if (lista.isEmpty())
			return false;

		Node<Viaje> current = lista.getFirst();
		Node<Viaje> previous = null;

		while (current != null) {

			if (current.getInfo().getNombre().equals(nombre)) {

				if (previous == null) {
					lista.extract();
				} else {
					lista.extract(previous);
				}

				guardar();
				return true;
			}

			previous = current;
			current = current.getNext();
		}

		return false;
	}
	// Guardar

	private void guardar() {
		FileHandler.writeSerializable(FILE_NAME, lista);
	}

	// Cargar
	private void cargar() {
		Object data = FileHandler.readSerializable(FILE_NAME);

		if (data == null) {
			lista = new MyLinkedList<>();
		} else {
			lista = (MyLinkedList<Viaje>) data;
		}
	}

	// Ordenar Asc/ Des

	public void ordenarAscendente() {

		if (lista == null || lista.isEmpty())
			return;

		boolean cambio;

		do {
			cambio = false;
			Node<Viaje> actual = lista.getFirst();

			while (actual.getNext() != null) {

				Viaje v1 = actual.getInfo();
				Viaje v2 = actual.getNext().getInfo();

				int total1 = v1.getCostoIda() + v1.getCostoEstadia();
				int total2 = v2.getCostoIda() + v2.getCostoEstadia();

				if (total1 > total2) {
					actual.setInfo(v2);
					actual.getNext().setInfo(v1);
					cambio = true;
				}

				actual = actual.getNext();
			}

		} while (cambio);
		guardar();
	}
	
	public void ordenarDescendente() {

	    if (lista == null || lista.isEmpty())
	        return;

	    boolean cambio;

	    do {
	        cambio = false;
	        Node<Viaje> actual = lista.getFirst();

	        while (actual.getNext() != null) {

	            Viaje v1 = actual.getInfo();
	            Viaje v2 = actual.getNext().getInfo();

	            int total1 = v1.getCostoIda() + v1.getCostoEstadia();
	            int total2 = v2.getCostoIda() + v2.getCostoEstadia();

	            if (total1 < total2) {
	                actual.setInfo(v2);
	                actual.getNext().setInfo(v1);
	                cambio = true;
	            }

	            actual = actual.getNext();
	        }

	    } while (cambio);

	    guardar();
	}

}