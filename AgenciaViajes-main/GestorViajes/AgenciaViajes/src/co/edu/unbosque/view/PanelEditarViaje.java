package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelEditarViaje extends JPanel {

	private JTextField ciudad, departamento, costoIda, costoEstadia;
	private JComboBox<Integer> rating;
	private JButton editar, volver;

	public PanelEditarViaje() {

		setBounds(0, 0, 600, 400);
		setLayout(null);
		setBackground(Color.WHITE);

		JLabel titulo = new JLabel("Editar viaje", SwingConstants.CENTER);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titulo.setForeground(new Color(46, 125, 50));
		titulo.setBounds(0, 20, 600, 30);
		add(titulo);

		JLabel lblCiudad = crearLabel("Ciudad");
		lblCiudad.setBounds(120, 80, 100, 20);
		add(lblCiudad);

		JLabel lblDepartamento = crearLabel("Departamento");
		lblDepartamento.setBounds(120, 120, 100, 20);
		add(lblDepartamento);

		JLabel lblCostoIda = crearLabel("Costo ida");
		lblCostoIda.setBounds(120, 160, 100, 20);
		add(lblCostoIda);

		JLabel lblCostoEstadia = crearLabel("Costo estadía");
		lblCostoEstadia.setBounds(120, 200, 100, 20);
		add(lblCostoEstadia);

		JLabel lblRating = crearLabel("Rating");
		lblRating.setBounds(120, 240, 100, 20);
		add(lblRating);

		ciudad = crearCampo();
		ciudad.setBounds(240, 80, 220, 26);
		add(ciudad);

		departamento = crearCampo();
		departamento.setBounds(240, 120, 220, 26);
		add(departamento);

		costoIda = crearCampo();
		costoIda.setBounds(240, 160, 220, 26);
		add(costoIda);

		costoEstadia = crearCampo();
		costoEstadia.setBounds(240, 200, 220, 26);
		add(costoEstadia);

		// ===== RATING =====
		rating = new JComboBox<>(new Integer[] { 1, 2, 3, 4, 5 });
		rating.setBounds(240, 240, 220, 26);
		rating.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rating.setBorder(new LineBorder(new Color(200, 200, 200)));
		add(rating);

		volver = new JButton("Volver");
		estiloBoton(volver, new Color(117, 117, 117));
		volver.setBounds(200, 300, 90, 32);
		add(volver);

		editar = new JButton("Editar");
		estiloBoton(editar, new Color(46, 125, 50));
		editar.setBounds(310, 300, 90, 32);
		add(editar);
	}

	private JLabel crearLabel(String texto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl.setForeground(Color.DARK_GRAY);
		return lbl;
	}

	private JTextField crearCampo() {
		JTextField campo = new JTextField();
		campo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		campo.setBorder(new CompoundBorder(
				new LineBorder(new Color(200, 200, 200)),
				new EmptyBorder(4, 6, 4, 6)
		));
		return campo;
	}

	private void estiloBoton(JButton btn, Color color) {
		btn.setBackground(color);
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn.setFocusPainted(false);
		btn.setBorder(new EmptyBorder(6, 14, 6, 14));
	}

	// ===== GETTERS =====
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

	public JButton getEditar() {
		return editar;
	}

	public JButton getVolver() {
		return volver;
	}
}