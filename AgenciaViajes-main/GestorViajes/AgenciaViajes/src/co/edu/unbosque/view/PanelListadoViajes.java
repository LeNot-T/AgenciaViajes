package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelListadoViajes extends JPanel {

    private JButton btnNombre, btnIda, btnEstadia, btnRating, volver;
    private JPanel contenedorTarjetas;

    public PanelListadoViajes() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // -------- PANEL FILTROS --------
        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelFiltros.setBackground(new Color(245, 245, 245));
        panelFiltros.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        btnNombre = estiloBotonFiltro("Nombre");
        btnIda = estiloBotonFiltro("Costo Ida");
        btnEstadia = estiloBotonFiltro("Estadía");
        btnRating = estiloBotonFiltro("Rating");
        volver = estiloBotonFiltro("Volver");
        volver.setBackground(new Color(200, 50, 50));

        panelFiltros.add(new JLabel("Ordenar por: "));
        panelFiltros.add(btnNombre);
        panelFiltros.add(btnIda);
        panelFiltros.add(btnEstadia);
        panelFiltros.add(btnRating);
        panelFiltros.add(Box.createHorizontalStrut(20));
        panelFiltros.add(volver);

        // -------- CONTENEDOR TARJETAS --------
        contenedorTarjetas = new JPanel(new GridLayout(0, 2, 15, 15));
        contenedorTarjetas.setBackground(Color.WHITE);
        contenedorTarjetas.setBorder(new EmptyBorder(15, 25, 15, 25));

        JScrollPane scroll = new JScrollPane(contenedorTarjetas);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
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

    // -------- METODOS IMPORTANTES PARA EL CONTROLLER --------

    public void limpiarTarjetas() {
        contenedorTarjetas.removeAll();
        contenedorTarjetas.revalidate();
        contenedorTarjetas.repaint();
    }

    public void agregarTarjeta(PanelViajeCard card) {
        contenedorTarjetas.add(card);
        contenedorTarjetas.revalidate();
        contenedorTarjetas.repaint();
    }

    // -------- GETTERS --------

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
}