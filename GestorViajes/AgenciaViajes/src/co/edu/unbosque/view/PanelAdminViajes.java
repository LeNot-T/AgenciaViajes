package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelAdminViajes extends JPanel {

	private JTable tablaViajes;
	private JButton btnCrear, btnEditar, btnEliminar, btnVolver, btnUsuario;

	public PanelAdminViajes() {

		setBounds(0, 0, 600, 400);
		setLayout(null);
		setBackground(Color.WHITE);

		// ===== TITULO =====
		JLabel titulo = new JLabel("Gestión de viajes", SwingConstants.CENTER);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titulo.setForeground(new Color(46, 125, 50));
		titulo.setBounds(0, 15, 600, 25);
		add(titulo);

		// ===== TABLA =====
		String[] columnas = { "Ciudad", "Departamento", "Costo ida", "Costo estadía", "Rating" };

		Object[][] datosEjemplo = {
				{ "Cartagena", "Bolívar", "$300k", "$500k", "3/5" },
				{ "Medellín", "Antioquia", "$200k", "$400k", "5/5" },
				{ "Santa Marta", "Magdalena", "$280k", "$450k", "4/5" }
		};

		tablaViajes = new JTable(datosEjemplo, columnas);
		tablaViajes.setRowHeight(22);
		tablaViajes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tablaViajes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		tablaViajes.setSelectionBackground(new Color(200, 230, 201));

		JScrollPane scrollTabla = new JScrollPane(tablaViajes);
		scrollTabla.setBounds(40, 60, 520, 220);
		scrollTabla.setBorder(new LineBorder(new Color(180, 180, 180)));
		add(scrollTabla);

		// ===== BOTONES CRUD =====
		btnCrear = crearBoton("Crear", new Color(46, 125, 50));
		btnCrear.setBounds(50, 310, 85, 32);
		add(btnCrear);

		btnEditar = crearBoton("Editar", new Color(30, 136, 229));
		btnEditar.setBounds(145, 310, 85, 32);
		add(btnEditar);

		btnEliminar = crearBoton("Eliminar", new Color(198, 40, 40));
		btnEliminar.setBounds(240, 310, 95, 32);
		add(btnEliminar);

		btnUsuario = crearBoton("Usuarios", new Color(123, 31, 162));
		btnUsuario.setBounds(345, 310, 95, 32);
		add(btnUsuario);

		btnVolver = crearBoton("Volver", new Color(117, 117, 117));
		btnVolver.setBounds(450, 310, 90, 32);
		add(btnVolver);
	}

	// ===== ESTILO BOTONES =====
	private JButton crearBoton(String texto, Color color) {
		JButton btn = new JButton(texto);
		btn.setBackground(color);
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn.setFocusPainted(false);
		btn.setBorder(new EmptyBorder(6, 12, 6, 12));
		return btn;
	}

	public JTable getTablaViajes() {
		return tablaViajes;
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnUsuario() {
		return btnUsuario;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}