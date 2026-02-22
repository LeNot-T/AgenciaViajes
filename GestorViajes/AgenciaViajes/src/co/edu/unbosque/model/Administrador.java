package co.edu.unbosque.model;

public class Administrador {
	private String nombreUsuario;
	private String contrasena;
	private int nivelAccseso;
	private int id;

	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public Administrador(String nombreUsuario, String contrasena, int nivelAccseso, int id) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.nivelAccseso = nivelAccseso;
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getNivelAccseso() {
		return nivelAccseso;
	}

	public void setNivelAccseso(int nivelAccseso) {
		this.nivelAccseso = nivelAccseso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Administrador [nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", nivelAccseso="
				+ nivelAccseso + ", id=" + id + "]";
	}

}
