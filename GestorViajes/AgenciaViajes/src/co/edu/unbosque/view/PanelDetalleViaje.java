package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PanelDetalleViaje extends JPanel {

	private JLabel titulo, imagen;
	private JTextArea info;
	private JButton volver;

	public PanelDetalleViaje() {
		// Manteniendo el tamaño estándar
		setBounds(0, 0, 600, 400);
		setLayout(null);
		setBackground(Color.WHITE);

		// --- TÍTULO ---
		titulo = new JLabel("Detalle del Viaje", SwingConstants.CENTER);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
		titulo.setForeground(new Color(46, 125, 50)); // Verde acorde al resto del app
		titulo.setBounds(0, 20, 600, 40);
		add(titulo);

		// --- IMAGEN PRINCIPAL ---
		imagen = new JLabel("Cargando imagen...", SwingConstants.CENTER);
		imagen.setBorder(new LineBorder(new Color(230, 230, 230), 2));
		imagen.setBackground(new Color(250, 250, 250));
		imagen.setOpaque(true);
		imagen.setBounds(40, 80, 280, 220); // Espacio generoso para la foto
		add(imagen);

		// --- ÁREA DE INFORMACIÓN ---
		info = new JTextArea();
		info.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		info.setEditable(false);
		info.setBackground(new Color(252, 252, 252));
		info.setBorder(new EmptyBorder(10, 15, 10, 15));
		info.setText(
				"Ciudad: Medellín\n\nDepartamento: Antioquia\n\nCosto Ida: $200.000\n\nCosto Estadía: $400.000\n\nRating: 4/5");

		// Un scroll pequeño por si el texto crece
		JScrollPane scrollInfo = new JScrollPane(info);
		scrollInfo.setBounds(340, 80, 220, 220);
		scrollInfo.setBorder(new LineBorder(new Color(230, 230, 230)));
		add(scrollInfo);

		// --- BOTÓN VOLVER ---
		volver = new JButton("Regresar al Listado");
		estiloBoton(volver, new Color(117, 117, 117));
		volver.setBounds(210, 330, 180, 35);
		add(volver);
	}

	private void estiloBoton(JButton btn, Color color) {
		btn.setBackground(color);
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	// --- GETTERS ---
	public JLabel getTitulo() {
		return titulo;
	}

	public JLabel getImagen() {
		return imagen;
	}

	public JTextArea getInfo() {
		return info;
	}

	public JButton getVolver() {
		return volver;
	}
}