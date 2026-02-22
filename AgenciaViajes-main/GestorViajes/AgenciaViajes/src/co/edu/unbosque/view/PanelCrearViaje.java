package co.edu.unbosque.view;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelCrearViaje extends JPanel {

	private JTextField ciudad, departamento, costoIda, costoEstadia;
	private JComboBox<Integer> rating;
	private JButton crear, volver, btnSubirImagen;
	private JLabel lblPreview;
	private String rutaImagen;

	public PanelCrearViaje() {

		// Mantenemos tu tamaño original
		setBounds(0, 0, 600, 400);
		setLayout(null);
		setBackground(Color.WHITE);

		// --- TÍTULO ---
		JLabel titulo = new JLabel("Crear nuevo viaje", SwingConstants.CENTER);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titulo.setForeground(new Color(46, 125, 50));
		titulo.setBounds(0, 15, 600, 30);
		add(titulo);

		// --- COLUMNA IZQUIERDA (CAMPOS) ---
		int xLabel = 50;
		int xCampo = 150;
		int anchoCampo = 180;

		add(crearLabel("Ciudad", xLabel, 60, 80, 25));
		ciudad = crearCampo(xCampo, 60, anchoCampo, 26);
		add(ciudad);

		add(crearLabel("Depto", xLabel, 100, 80, 25));
		departamento = crearCampo(xCampo, 100, anchoCampo, 26);
		add(departamento);

		add(crearLabel("Costo Ida", xLabel, 140, 80, 25));
		costoIda = crearCampo(xCampo, 140, anchoCampo, 26);
		add(costoIda);

		add(crearLabel("Estadía", xLabel, 180, 80, 25));
		costoEstadia = crearCampo(xCampo, 180, anchoCampo, 26);
		add(costoEstadia);

		add(crearLabel("Rating", xLabel, 220, 80, 25));
		rating = new JComboBox<>(new Integer[] { 1, 2, 3, 4, 5 });
		rating.setBounds(xCampo, 220, anchoCampo, 26);
		rating.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rating.setBackground(Color.WHITE);
		rating.setBorder(new LineBorder(new Color(200, 200, 200)));
		add(rating);

		// --- COLUMNA DERECHA (IMAGEN) ---
		int xImagen = 360;

		JLabel lblImgTit = crearLabel("Imagen del Viaje", xImagen, 60, 180, 20);
		lblImgTit.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblImgTit);

		btnSubirImagen = new JButton("Seleccionar...");
		estiloBoton(btnSubirImagen, new Color(33, 150, 243));
		btnSubirImagen.setBounds(360, 85, 180, 30);
		add(btnSubirImagen);

		lblPreview = new JLabel("Vista previa", SwingConstants.CENTER);
		lblPreview.setFont(new Font("Segoe UI", Font.ITALIC, 10));
		lblPreview.setBorder(new LineBorder(new Color(230, 230, 230)));
		lblPreview.setBounds(360, 125, 180, 120); // Recuadro más vertical y estético
		add(lblPreview);

		// --- BOTONES DE ACCIÓN (ABAJO) ---
		JSeparator sep = new JSeparator();
		sep.setBounds(50, 280, 500, 2);
		add(sep);

		volver = new JButton("Volver");
		estiloBoton(volver, new Color(117, 117, 117));
		volver.setBounds(190, 310, 100, 35);
		add(volver);

		crear = new JButton("Crear");
		estiloBoton(crear, new Color(46, 125, 50));
		crear.setBounds(310, 310, 100, 35);
		add(crear);
	}

	public void cargarImagen() {
		JFileChooser buscador = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg");
		buscador.setFileFilter(filtro);

		if (buscador.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File archivo = buscador.getSelectedFile();
			rutaImagen = archivo.getAbsolutePath();

			ImageIcon imageIcon = new ImageIcon(rutaImagen);
			// Escalado adaptado al nuevo tamaño del preview (180x120)
			Image newimg = imageIcon.getImage().getScaledInstance(170, 110, Image.SCALE_SMOOTH);
			lblPreview.setText("");
			lblPreview.setIcon(new ImageIcon(newimg));
		}
	}

	// Helper para etiquetas con posición
	private JLabel crearLabel(String texto, int x, int y, int w, int h) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl.setForeground(Color.DARK_GRAY);
		lbl.setBounds(x, y, w, h);
		return lbl;
	}

	// Helper para campos con posición
	private JTextField crearCampo(int x, int y, int w, int h) {
		JTextField campo = new JTextField();
		campo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		campo.setBorder(new CompoundBorder(new LineBorder(new Color(200, 200, 200)), new EmptyBorder(4, 6, 4, 6)));
		campo.setBounds(x, y, w, h);
		return campo;
	}

	private void estiloBoton(JButton btn, Color color) {
		btn.setBackground(color);
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public JTextField getCiudad() {
		return ciudad;
	}

	public JTextField getDepartamento() {
		return departamento;
	}

	public JTextField getCostoIda() {
		return costoIda;
	}

	public JTextField getCostoEstadia() {
		return costoEstadia;
	}

	public JComboBox<Integer> getRating() {
		return rating;
	}

	public JButton getCrear() {
		return crear;
	}

	public JButton getVolver() {
		return volver;
	}

	public JButton getBtnSubirImagen() {
		return btnSubirImagen;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}
}