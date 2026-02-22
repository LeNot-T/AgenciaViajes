package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AdministradorDAO;
import co.edu.unbosque.util.structure.Node;

public class ModelFacade {
	private AdministradorDAO adminDAO;

	public ModelFacade() {
		adminDAO = new AdministradorDAO();
		if (adminDAO.cantidad() == 0) {
			adminDAO.crear(new Administrador("admin", "1234", 1, 1));
		}
	}

	public void crearAdmin(String usuario, String password, int nivel, int id) {
		adminDAO.crear(new Administrador(usuario, password, nivel, id));
	}

	public int eliminarAdmin(int index) {
		return adminDAO.eliminar(index);
	}

	public int actualizarAdmin(int index, String usuario, String password, int nivel, int id) {
		return adminDAO.actualizar(index, new Administrador(usuario, password, nivel, id));
	}

	public String mostrarAdmins() {
		return adminDAO.mostrarTodo();
	}

	public Administrador verificarLoginAdmin(String usuario, String password) {
		Node<Administrador> actual = adminDAO.getListaAdministradores().getFirst();

		while (actual != null) {
			Administrador admin = actual.getInfo();

			if (admin.getNombreUsuario().equals(usuario) && admin.getContrasena().equals(password)) {
				return admin;
			}

			actual = actual.getNext();
		}

		return null;
	}

}
