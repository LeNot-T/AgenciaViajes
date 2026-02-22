package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import co.edu.unbosque.model.Viaje;

public class PanelViajeCard extends JPanel {

    private JButton btnVer;
    private Viaje viaje; // 🔥 guardamos el viaje

    public PanelViajeCard(Viaje viaje) {

        this.viaje = viaje;

        setPreferredSize(new Dimension(220, 300));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(10, 10));
        setBorder(new CompoundBorder(
                new LineBorder(Color.decode("#A5D6A7"), 2),
                new EmptyBorder(10, 10, 10, 10)
        ));

        // ===== TITULO =====
        JLabel lblTitulo = new JLabel(viaje.getNombre(), SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(Color.decode("#1B5E20"));

        // ===== IMAGEN =====
        JLabel lblImagen = new JLabel("", SwingConstants.CENTER);
        lblImagen.setPreferredSize(new Dimension(180, 120));
        lblImagen.setOpaque(true);
        lblImagen.setBackground(Color.decode("#E8F5E9"));
        lblImagen.setBorder(new LineBorder(Color.decode("#C8E6C9")));

        if (viaje.getRutaImagen() != null && !viaje.getRutaImagen().isEmpty()) {
            ImageIcon icon = new ImageIcon(viaje.getRutaImagen());
            Image img = icon.getImage().getScaledInstance(170, 110, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(img));
        } else {
            lblImagen.setText("Sin imagen");
            lblImagen.setForeground(Color.decode("#2E7D32"));
        }

        // ===== INFO DINÁMICA =====
        int total = viaje.getCostoIda() + viaje.getCostoEstadia();

        JLabel lblInfo = new JLabel(
                "<html>"
                + "<b>Departamento:</b> " + viaje.getDepartamento() + "<br>"
                + "<b>Ida:</b> $" + viaje.getCostoIda() + "<br>"
                + "<b>Estadía:</b> $" + viaje.getCostoEstadia() + "<br>"
                + "<b>Total:</b> $" + total + "<br>"
                + "<b>Rating:</b> " + viaje.getRating() + "/5"
                + "</html>"
        );

        lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblInfo.setForeground(Color.decode("#33691E"));

        JPanel panelInfo = new JPanel(new BorderLayout());
        panelInfo.setBackground(Color.WHITE);
        panelInfo.add(lblInfo, BorderLayout.CENTER);

        // ===== BOTON =====
        btnVer = new JButton("Ver detalles");
        btnVer.setBackground(Color.decode("#2E7D32"));
        btnVer.setForeground(Color.WHITE);
        btnVer.setFocusPainted(false);
        btnVer.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnVer.setBorder(new EmptyBorder(8, 10, 8, 10));

        // ===== ARMADO =====
        add(lblTitulo, BorderLayout.NORTH);
        add(lblImagen, BorderLayout.CENTER);
        add(panelInfo, BorderLayout.SOUTH);

        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBtn.setBackground(Color.WHITE);
        panelBtn.add(btnVer);

        add(panelBtn, BorderLayout.PAGE_END);
    }

    public JButton getBtnVer() {
        return btnVer;
    }

    public Viaje getViaje() {
        return viaje;
    }
}