package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class VentanaPrincipal extends JFrame {

    private PanelLogin panelLogin;
    private PanelRegistro panelRegistro;
    private PanelAdminViajes panelAdminVia;
    private PanelDetalleViaje panelDetalleViaje;
    private PanelListadoViajes panelListadoViaje;
    private PanelCrearViaje crearViaje;
    private PanelEditarViaje editarViaje;

    private CardLayout cardLayout;
    private JPanel contenedor;

    public VentanaPrincipal() {

        setTitle("Agencia de Viajes");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        inicializarPaneles();

        add(contenedor);
        setVisible(true);
    }

    private void inicializarPaneles() {

        panelLogin = new PanelLogin();
        panelRegistro = new PanelRegistro();
        panelAdminVia = new PanelAdminViajes();
        panelDetalleViaje = new PanelDetalleViaje();
        panelListadoViaje = new PanelListadoViajes();
        crearViaje = new PanelCrearViaje();
        editarViaje = new PanelEditarViaje();

        contenedor.add(panelLogin, "LOGIN");
        contenedor.add(panelRegistro, "REGISTRO");
        contenedor.add(panelAdminVia, "ADMIN_VIA");
        contenedor.add(panelDetalleViaje, "DETALLE_VIAJE");
        contenedor.add(panelListadoViaje, "LISTADO_VIAJE");
        contenedor.add(crearViaje, "CREAR_VIAJE");
        contenedor.add(editarViaje, "EDITAR_VIAJE");

        mostrarPanel("LOGIN");
    }

    public void mostrarPanel(String nombre) {
        cardLayout.show(contenedor, nombre);
    }

    // -------- GETTERS --------

    public PanelListadoViajes getPanelListadoViaje() {
        return panelListadoViaje;
    }

    public PanelDetalleViaje getPanelDetalleViaje() {
        return panelDetalleViaje;
    }

    public PanelAdminViajes getPanelAdminVia() {
        return panelAdminVia;
    }

    public PanelCrearViaje getCrearViaje() {
        return crearViaje;
    }

    public PanelEditarViaje getEditarViaje() {
        return editarViaje;
    }
}