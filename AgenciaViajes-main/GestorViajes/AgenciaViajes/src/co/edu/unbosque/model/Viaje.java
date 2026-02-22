package co.edu.unbosque.model;

import java.io.Serializable;

public class Viaje implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String departamento;
	private int costoIda;
	private int costoEstadia;
	private int rating;
	private String rutaImagen;

	public Viaje(String nombre, String departamento, int costoIda, int costoEstadia, int rating, String rutaImagen) {
		this.nombre = nombre;
		this.departamento = departamento;
		this.costoIda = costoIda;
		this.costoEstadia = costoEstadia;
		this.rating = rating;
		this.rutaImagen = rutaImagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getCostoIda() {
		return costoIda;
	}

	public void setCostoIda(int costoIda) {
		this.costoIda = costoIda;
	}

	public int getCostoEstadia() {
		return costoEstadia;
	}

	public void setCostoEstadia(int costoEstadia) {
		this.costoEstadia = costoEstadia;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	@Override
	public String toString() {
		return nombre + " - " + departamento;
	}
}
