package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Usuario;

public interface OperacionDAO <C> {

	public void Crear(C nuevoDato);

	public int Eliminar(int index);

	public int Eliminar(C datoAEliminar);

	public int Actualizar(int index, C nuevoDato);

	public String MostrarTodo();

	public int Cantidad();

	Usuario find(String nombreUsuario);
	
}
