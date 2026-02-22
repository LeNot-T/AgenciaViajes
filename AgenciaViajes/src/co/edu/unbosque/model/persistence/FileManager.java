package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {

	private static Scanner lectorDeArchivo;
	private static File archivo;
	private static PrintWriter escritorDeArchivo;
	private static final String RUTA_CARPETA = "src/archivos";

	public static void crearCarpeta() {

		archivo = new File(RUTA_CARPETA);
		if (!archivo.exists() || !archivo.isDirectory()) {
			archivo.mkdir();
		}

	}

	public static void escribirArchivoDeTexto(String nombreArchivo, String contenido) {

		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritorDeArchivo = new PrintWriter(archivo);
			escritorDeArchivo.println(contenido);
			escritorDeArchivo.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo de texto.(Creación del archivo).");
			e.printStackTrace();
		}

	}

	public static String leerArchivoDeTexto(String nombreArchivo) {

		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			lectorDeArchivo = new Scanner(archivo);
			String contenido = "";
			while(lectorDeArchivo.hasNext()) {
				contenido += lectorDeArchivo.nextLine()+"\n";
			}
			lectorDeArchivo.close();
			return contenido;
			
		} catch (IOException e) {
			System.out.println("Error al leer el archivo. (Creación del archivo).");
			e.printStackTrace();
		}
		
		return null;


	}

}
