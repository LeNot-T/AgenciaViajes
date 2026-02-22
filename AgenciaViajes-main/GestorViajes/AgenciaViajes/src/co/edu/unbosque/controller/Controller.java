package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.AdminViaje;
import co.edu.unbosque.model.Viaje;
import co.edu.unbosque.util.structure.Node;
import co.edu.unbosque.view.PanelViajeCard;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

    private ViewFacade vf;
    private AdminViaje adminViaje;

    public Controller() {
        vf = new ViewFacade();
        adminViaje = new AdminViaje();
    }

    public void run() {
        vf.getVp().setVisible(true);
        asignarLectores();
        vf.getVp().mostrarPanel("LOGIN");
    }

    private void asignarLectores() {

        // LOGIN
        vf.getVp().getPanelAdminVia().getRegistro().addActionListener(this);
        vf.getVp().getPanelAdminVia().getRegistro().setActionCommand("irRegistro");

        vf.getVp().getPanelAdminVia().getLogin().addActionListener(this);
        vf.getVp().getPanelAdminVia().getLogin().setActionCommand("login");

        // REGISTRO
        vf.getVp().getPanelRegistro().getBtnVolver().addActionListener(this);
        vf.getVp().getPanelRegistro().getBtnVolver().setActionCommand("volverLogin");

        // ADMIN VIAJES
        vf.getVp().getPanelAdminVia().getBtnCrear().addActionListener(this);
        vf.getVp().getPanelAdminVia().getBtnCrear().setActionCommand("pantallaCrearViaje");

        vf.getVp().getPanelAdminVia().getBtnEliminar().addActionListener(this);
        vf.getVp().getPanelAdminVia().getBtnEliminar().setActionCommand("eliminarViaje");

        vf.getVp().getPanelAdminVia().getBtnVolver().addActionListener(this);
        vf.getVp().getPanelAdminVia().getBtnVolver().setActionCommand("volverLogin");

        // CREAR VIAJE
        vf.getVp().getCrearViaje().getCrear().addActionListener(this);
        vf.getVp().getCrearViaje().getCrear().setActionCommand("guardarNuevoViaje");

        vf.getVp().getCrearViaje().getVolver().addActionListener(this);
        vf.getVp().getCrearViaje().getVolver().setActionCommand("volverAdminViajes");

        vf.getVp().getCrearViaje().getBtnSubirImagen().addActionListener(this);
        vf.getVp().getCrearViaje().getBtnSubirImagen().setActionCommand("subirImagen");

        // LISTADO
        vf.getVp().getPanelListadoViaje().getVolver().addActionListener(this);
        vf.getVp().getPanelListadoViaje().getVolver().setActionCommand("volverLogin");

        // DETALLE
        vf.getVp().getPanelDetalleViaje().getVolver().addActionListener(this);
        vf.getVp().getPanelDetalleViaje().getVolver().setActionCommand("volverAlListado");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        switch (comando) {

        case "irRegistro":
            vf.getVp().mostrarPanel("REGISTRO");
            break;

        case "volverLogin":
            vf.getVp().mostrarPanel("LOGIN");
            break;

        case "login":
            actualizarListaViajes();
            vf.getVp().mostrarPanel("ADMIN_VIA");
            break;

        case "pantallaCrearViaje":
            vf.getVp().mostrarPanel("CREAR_VIAJE");
            break;

        case "guardarNuevoViaje":

            try {

                String ciudad = vf.getVp().getCrearViaje().getCiudad().getText();
                String depto = vf.getVp().getCrearViaje().getDepartamento().getText();
                int ida = Integer.parseInt(vf.getVp().getCrearViaje().getCostoIda().getText());
                int estadia = Integer.parseInt(vf.getVp().getCrearViaje().getCostoEstadia().getText());
                int rating = Integer.parseInt(
                        vf.getVp().getCrearViaje().getRating().getSelectedItem().toString()
                );
                String ruta = vf.getVp().getCrearViaje().getRutaImagen();

                Viaje nuevo = new Viaje(ciudad, depto, ida, estadia, rating, ruta);

                adminViaje.agregarViaje(nuevo);

                actualizarListaViajes();

                vf.getVp().mostrarPanel("ADMIN_VIA");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Datos inválidos");
            }

            break;

        case "eliminarViaje":

            int fila = vf.getVp().getPanelAdminVia().getTablaViajes().getSelectedRow();

            if (fila != -1) {

                String nombre = vf.getVp()
                        .getPanelAdminVia()
                        .getModelo()
                        .getValueAt(fila, 0)
                        .toString();

                adminViaje.eliminarViaje(nombre);

                actualizarListaViajes();

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un viaje.");
            }

            break;

        case "subirImagen":
            vf.getVp().getCrearViaje().cargarImagen();
            break;

        case "volverAdminViajes":
            vf.getVp().mostrarPanel("ADMIN_VIA");
            break;

        case "verDetalles":
            vf.getVp().mostrarPanel("DETALLE_VIAJE");
            break;

        case "volverAlListado":
            vf.getVp().mostrarPanel("LISTADO_VIAJE");
            break;
        }
    }

    private void actualizarListaViajes() {

        vf.getVp().getPanelListadoViaje().limpiarTarjetas();

        Node<Viaje> actual = adminViaje.getLista().getFirst();

        while (actual != null) {

            Viaje viaje = actual.getInfo();

            PanelViajeCard card = new PanelViajeCard(viaje);

            card.getBtnVer().addActionListener(this);
            card.getBtnVer().setActionCommand("verDetalles");

            vf.getVp().getPanelListadoViaje().agregarTarjeta(card);

            actual = actual.getNext();
        }
    }
}