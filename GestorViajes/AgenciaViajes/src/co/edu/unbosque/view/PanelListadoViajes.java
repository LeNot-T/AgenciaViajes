package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelListadoViajes extends JPanel {

	private JButton btnNombre, btnIda, btnEstadia, btnRating, volver;
	private JPanel contenedorTarjetas;

	public PanelListadoViajes() {
		// Usamos BorderLayout para que el scroll ocupe todo el espacio central
		setLayout(new BorderLayout());
		setBounds(0, 0, 600, 400);
		setBackground(Color.WHITE);

		// --- PANEL DE FILTROS (NORTE) ---
		JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panelFiltros.setBackground(new Color(245, 245, 245));
		panelFiltros.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

		btnNombre = estiloBotonFiltro("Nombre");
		btnIda = estiloBotonFiltro("Costo Ida");
		btnEstadia = estiloBotonFiltro("Estadía");
		btnRating = estiloBotonFiltro("Rating");
		volver = estiloBotonFiltro("Volver");
		volver.setBackground(new Color(200, 50, 50)); // Rojo suave para volver

		panelFiltros.add(new JLabel("Ordenar por: "));
		panelFiltros.add(btnNombre);
		panelFiltros.add(btnIda);
		panelFiltros.add(btnEstadia);
		panelFiltros.add(btnRating);
		panelFiltros.add(Box.createHorizontalStrut(20)); // Espacio
		panelFiltros.add(volver);

		// --- CONTENEDOR DE TARJETAS (CENTRO) ---
		// GridLayout con 2 columnas. Las filas se ajustan automáticamente (0)
		contenedorTarjetas = new JPanel(new GridLayout(0, 2, 15, 15));
		contenedorTarjetas.setBackground(Color.WHITE);
		contenedorTarjetas.setBorder(new EmptyBorder(15, 25, 15, 25));

		// IMPORTANTE NIÑOS BORREN ESTO, ES DE PRUEBA
		for (int i = 0; i < 8; i++) {
			contenedorTarjetas.add(new PanelViajeCard());
		}

		// --- SCROLL PERMANENTE ---
		JScrollPane scroll = new JScrollPane(contenedorTarjetas);
		scroll.setBorder(null);
		scroll.getVerticalScrollBar().setUnitIncrement(16); // Scroll suave
		// Forzamos que solo sea vertical
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		add(panelFiltros, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
	}

	private JButton estiloBotonFiltro(String texto) {
		JButton btn = new JButton(texto);
		btn.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn.setFocusPainted(false);
		btn.setBackground(Color.WHITE);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		return btn;
	}

	// Getters
	public JButton getBtnNombre() {
		return btnNombre;
	}

	public JButton getBtnIda() {
		return btnIda;
	}

	public JButton getBtnEstadia() {
		return btnEstadia;
	}

	public JButton getBtnRating() {
		return btnRating;
	}

	public JButton getVolver() {
		return volver;
	}

	public JPanel getContenedorTarjetas() {
		return contenedorTarjetas;
	}

	public void setContenedorTarjetas(JPanel contenedorTarjetas) {
		this.contenedorTarjetas = contenedorTarjetas;
	}

	public void setBtnNombre(JButton btnNombre) {
		this.btnNombre = btnNombre;
	}

	public void setBtnIda(JButton btnIda) {
		this.btnIda = btnIda;
	}

	public void setBtnEstadia(JButton btnEstadia) {
		this.btnEstadia = btnEstadia;
	}

	public void setBtnRating(JButton btnRating) {
		this.btnRating = btnRating;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}
	
	
}