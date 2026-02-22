package co.edu.unbosque.model;

public class Usuario {

	private String nombre;
	private String nombreUsuario;
	private String correo;
	private long telefono;
	private String contrasena;

	public Usuario() {
	}

	public Usuario(String nombre, String nombreUsuario, String correo, long telefono, String contrasena) {
		super();
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.telefono = telefono;
		this.contrasena = contrasena;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;

	    Usuario other = (Usuario) obj;
	    return nombreUsuario.equals(other.nombreUsuario);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", correo=" + correo + ", telefono="
				+ telefono + ", contrasena=" + contrasena + "]";
	}
	
	
	
}