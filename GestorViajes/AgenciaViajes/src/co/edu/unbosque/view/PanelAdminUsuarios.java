package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PanelAdminUsuarios extends JPanel {

	private JTable tablaUsuarios;
	private DefaultTableModel modelo;
	private JButton btnEditar, btnEliminar, btnVolver;

	public PanelAdminUsuarios() {
		setBounds(0, 0, 600, 400);
		setLayout(new BorderLayout(0, 10));
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 30, 40, 30));

		JLabel titulo = new JLabel("GESTIÓN DE USUARIOS", SwingConstants.CENTER);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		titulo.setForeground(new Color(46, 125, 50));
		add(titulo, BorderLayout.NORTH);

		modelo = new DefaultTableModel(new Object[] { "Nombre", "Usuario", "Correo", "Teléfono" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tablaUsuarios = new JTable(modelo);
		tablaUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		tablaUsuarios.setRowHeight(25);
		tablaUsuarios.setSelectionBackground(new Color(200, 230, 201));
		tablaUsuarios.setGridColor(new Color(230, 230, 230));
		tablaUsuarios.setShowVerticalLines(false);

		JTableHeader header = tablaUsuarios.getTableHeader();
		header.setFont(new Font("Segoe UI", Font.BOLD, 13));
		header.setBackground(new Color(245, 245, 245));
		header.setBorder(new LineBorder(new Color(220, 220, 220)));

		JScrollPane scroll = new JScrollPane(tablaUsuarios);
		scroll.setBorder(new LineBorder(new Color(220, 220, 220)));
		scroll.getViewport().setBackground(Color.WHITE);
		add(scroll, BorderLayout.CENTER);

		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
		panelBotones.setBackground(Color.WHITE);

		btnEditar = new JButton("Editar");
		estiloBoton(btnEditar, new Color(33, 150, 243));

		btnEliminar = new JButton("Eliminar");
		estiloBoton(btnEliminar, new Color(211, 47, 47));

		btnVolver = new JButton("Volver");
		estiloBoton(btnVolver, new Color(117, 117, 117));

		panelBotones.add(btnEditar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnVolver);

		add(panelBotones, BorderLayout.SOUTH);

		modelo.addRow(new Object[] { "Ana López", "alopez", "ana@mail.com", "3001234567" });
		modelo.addRow(new Object[] { "Juan Pérez", "jperez", "juan@mail.com", "3119876543" });
	}

	private void estiloBoton(JButton btn, Color color) {
		btn.setBackground(color);
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn.setPreferredSize(new Dimension(110, 32));
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	// GETTERS
	public JTable getTablaUsuarios() {
		return tablaUsuarios;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}