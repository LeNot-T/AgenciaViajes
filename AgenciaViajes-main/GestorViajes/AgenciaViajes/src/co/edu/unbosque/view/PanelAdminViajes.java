package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelAdminViajes extends JPanel {

    private JTable tablaViajes;
    private DefaultTableModel modelo;

    private JButton btnCrear;
    private JButton btnEliminar;
    private JButton btnAsc;
    private JButton btnDesc;
    private JButton btnVolver;

    public PanelAdminViajes() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Columnas de la tabla
        String[] columnas = {
                "Ciudad",
                "Departamento",
                "Costo Ida",
                "Costo Estadía",
                "Rating"
        };

        // 🔥 IMPORTANTE: modelo vacío
        modelo = new DefaultTableModel(columnas, 0);
        tablaViajes = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tablaViajes);
        add(scroll, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();

        btnCrear = new JButton("Crear Viaje");
        btnEliminar = new JButton("Eliminar Viaje");
        btnAsc = new JButton("Orden Ascendente");
        btnDesc = new JButton("Orden Descendente");
        btnVolver = new JButton("Volver");

        panelBotones.add(btnCrear);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnAsc);
        panelBotones.add(btnDesc);
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.SOUTH);
    }

    // =======================
    // GETTERS NECESARIOS
    // =======================

    public JTable getTablaViajes() {
        return tablaViajes;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnAsc() {
        return btnAsc;
    }

    public JButton getBtnDesc() {
        return btnDesc;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}