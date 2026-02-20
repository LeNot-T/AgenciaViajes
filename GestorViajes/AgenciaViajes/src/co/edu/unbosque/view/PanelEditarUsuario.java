package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelEditarUsuario extends JPanel {

	private JTextField nombre, correo, telefono, password;
	private JLabel lblUsuarioFijo; // El nombre de usuario suele ser el ID, mejor no editarlo
	private JButton btnActualizar, btnCancelar;

	public PanelEditarUsuario() {
		setBounds(0, 0, 600, 400);
		setLayout(null);
		setBackground(Color.WHITE);

		JLabel titulo = new JLabel("Editar Información de Usuario", SwingConstants.CENTER);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titulo.setForeground(new Color(33, 150, 243)); // Azul para diferenciar de "Crear"
		titulo.setBounds(0, 30, 600, 30);
		add(titulo);

		int xLabel = 120, xCampo = 240, ancho = 220, alto = 28, gap = 40;

		add(crearLabel("Usuario:", xLabel, 80));
		lblUsuarioFijo = new JLabel("user123"); // Se llenará dinámicamente
		lblUsuarioFijo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsuarioFijo.setBounds(xCampo, 80, ancho, alto);
		add(lblUsuarioFijo);

		add(crearLabel("Nombre:", xLabel, 120));
		nombre = crearCampo(xCampo, 120, ancho, alto);
		add(nombre);

		add(crearLabel("Correo:", xLabel, 160));
		correo = crearCampo(xCampo, 160, ancho, alto);
		add(correo);

		add(crearLabel("Teléfono:", xLabel, 200));
		telefono = crearCampo(xCampo, 200, ancho, alto);
		add(telefono);

		add(crearLabel("Contraseña:", xLabel, 240));
		password = crearCampo(xCampo, 240, ancho, alto);
		add(password);

		btnCancelar = new JButton("Cancelar");
		estiloBoton(btnCancelar, new Color(117, 117, 117));
		btnCancelar.setBounds(180, 310, 110, 35);
		add(btnCancelar);

		btnActualizar = new JButton("Actualizar");
		estiloBoton(btnActualizar, new Color(33, 150, 243));
		btnActualizar.setBounds(310, 310, 110, 35);
		add(btnActualizar);
	}

	private JLabel crearLabel(String texto, int x, int y) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl.setBounds(x, y, 100, 25);
		return lbl;
	}

	private JTextField crearCampo(int x, int y, int w, int h) {
		JTextField txt = new JTextField();
		txt.setBounds(x, y, w, h);
		txt.setBorder(new CompoundBorder(new LineBorder(new Color(200, 200, 200)), new EmptyBorder(2, 5, 2, 5)));
		return txt;
	}

	private void estiloBoton(JButton btn, Color color) {
		btn.setBackground(color);
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	// GETTERS
	public JTextField getNombre() {
		return nombre;
	}

	public JTextField getCorreo() {
		return correo;
	}

	public JTextField getTelefono() {
		return telefono;
	}

	public JTextField getPassword() {
		return password;
	}

	public JLabel getLblUsuarioFijo() {
		return lblUsuarioFijo;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}