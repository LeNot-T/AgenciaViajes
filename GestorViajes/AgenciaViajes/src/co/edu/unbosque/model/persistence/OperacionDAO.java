package co.edu.unbosque.model.persistence;

public interface OperacionDAO<C> {

	public void crear(C nuevoDato);

	public int eliminar(int index);

	public int eliminar(C datoAEliminar);

	public int actualizar(int index, C datoAActualizar);

	public String mostrarTodo();

	public int cantidad();
	
	public int comprobarPosicion(int index); 

}
