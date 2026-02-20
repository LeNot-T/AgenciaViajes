package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelViajeCard extends JPanel {

    private JButton btnVer;

    public PanelViajeCard() {

        setPreferredSize(new Dimension(220, 300));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(10, 10));
        setBorder(new CompoundBorder(
                new LineBorder(Color.decode("#A5D6A7"), 2),
                new EmptyBorder(10, 10, 10, 10)
        ));

        // ===== TITULO =====
        JLabel lblTitulo = new JLabel("Cartagena", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(Color.decode("#1B5E20"));

        // ===== IMAGEN (placeholder) =====
        JLabel lblImagen = new JLabel("Imagen", SwingConstants.CENTER);
        lblImagen.setPreferredSize(new Dimension(180, 120));
        lblImagen.setOpaque(true);
        lblImagen.setBackground(Color.decode("#E8F5E9"));
        lblImagen.setBorder(new LineBorder(Color.decode("#C8E6C9")));
        lblImagen.setForeground(Color.decode("#2E7D32"));

        // ===== INFO =====
        JLabel lblInfo = new JLabel(
                "<html>"
                + "<b>Departamento:</b> Bolívar<br>"
                + "<b>Ida:</b> $300.000<br>"
                + "<b>Estadía:</b> $500.000<br>"
                + "<b>Rating:</b> ★★★★☆"
                + "</html>"
        );
        lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblInfo.setForeground(Color.decode("#33691E"));

        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BorderLayout());
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

    public void setBtnVer(JButton btnVer) {
        this.btnVer = btnVer;
    }
}