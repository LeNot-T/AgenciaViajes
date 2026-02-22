package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.PanelViajeCard;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	private ViewFacade vf;
	private ModelFacade mf;


	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
	}

	public void run() {
		vf.getVp().setVisible(true);
		asignarLectores();
		vf.getVp().mostrarPanel(vf.getVp().getPanelLogin());
	}

	private void asignarLectores() {
		vf.getVp().getPanelLogin().getRegistro().addActionListener(this);
		vf.getVp().getPanelLogin().getRegistro().setActionCommand("irRegistro");
		vf.getVp().getPanelLogin().getLogin().addActionListener(this);
		vf.getVp().getPanelLogin().getLogin().setActionCommand("login");

		vf.getVp().getPanelRegistro().getBtnRegistrar().addActionListener(this);
		vf.getVp().getPanelRegistro().getBtnRegistrar().setActionCommand("registrarUsuario");
		vf.getVp().getPanelRegistro().getBtnVolver().addActionListener(this);
		vf.getVp().getPanelRegistro().getBtnVolver().setActionCommand("volverLogin");

		vf.getVp().getPanelAdminVia().getBtnCrear().addActionListener(this);
		vf.getVp().getPanelAdminVia().getBtnCrear().setActionCommand("pantallaCrearViaje");
		vf.getVp().getPanelAdminVia().getBtnEditar().addActionListener(this);
		vf.getVp().getPanelAdminVia().getBtnEditar().setActionCommand("pantallaEditarViaje");
		vf.getVp().getPanelAdminVia().getBtnEliminar().addActionListener(this);
		vf.getVp().getPanelAdminVia().getBtnEliminar().setActionCommand("eliminarViaje");
		vf.getVp().getPanelAdminVia().getBtnVolver().addActionListener(this);
		vf.getVp().getPanelAdminVia().getBtnVolver().setActionCommand("volverLogin");
		vf.getVp().getPanelAdminVia().getBtnUsuario().addActionListener(this);
		vf.getVp().getPanelAdminVia().getBtnUsuario().setActionCommand("gestionUsuario");

		vf.getVp().getPanelAdminUsu().getBtnEditar().addActionListener(this);
		vf.getVp().getPanelAdminUsu().getBtnEditar().setActionCommand("pantallaEditarUsuario");
		vf.getVp().getPanelAdminUsu().getBtnEliminar().addActionListener(this);
		vf.getVp().getPanelAdminUsu().getBtnEliminar().setActionCommand("eliminarUsuarioAdmin");
		vf.getVp().getPanelAdminUsu().getBtnVolver().addActionListener(this);
		vf.getVp().getPanelAdminUsu().getBtnVolver().setActionCommand("volverAdminViajes");

		vf.getVp().getEditarUsuario().getBtnActualizar().addActionListener(this);
		vf.getVp().getEditarUsuario().getBtnActualizar().setActionCommand("confirmarEdicionUsuario");
		vf.getVp().getEditarUsuario().getBtnCancelar().addActionListener(this);
		vf.getVp().getEditarUsuario().getBtnCancelar().setActionCommand("gestionUsuario");

		vf.getVp().getCrearViaje().getCrear().addActionListener(this);
		vf.getVp().getCrearViaje().getCrear().setActionCommand("guardarNuevoViaje");
		vf.getVp().getCrearViaje().getVolver().addActionListener(this);
		vf.getVp().getCrearViaje().getVolver().setActionCommand("volverAdminViajes");
		vf.getVp().getCrearViaje().getBtnSubirImagen().addActionListener(this);
		vf.getVp().getCrearViaje().getBtnSubirImagen().setActionCommand("subirImagen");

		vf.getVp().getEditarViaje().getEditar().addActionListener(this);
		vf.getVp().getEditarViaje().getEditar().setActionCommand("confirmarEdicionViaje");
		vf.getVp().getEditarViaje().getVolver().addActionListener(this);
		vf.getVp().getEditarViaje().getVolver().setActionCommand("volverAdminViajes");

		vf.getVp().getPanelListadoViaje().getVolver().addActionListener(this);
		vf.getVp().getPanelListadoViaje().getVolver().setActionCommand("volverLogin");
		vf.getVp().getPanelDetalleViaje().getVolver().addActionListener(this);
		vf.getVp().getPanelDetalleViaje().getVolver().setActionCommand("volverAlListado");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		switch (comando) {
		case "irRegistro":
			vf.getVp().mostrarPanel(vf.getVp().getPanelRegistro());
			break;

		case "volverLogin":
			vf.getVp().mostrarPanel(vf.getVp().getPanelLogin());
			break;

		case "login":
			String user = vf.getVp().getPanelLogin().getUsuario().getText();
			String contrasenia = new String(vf.getVp().getPanelLogin().getContrasenia().getPassword());

			Administrador adminLogueado = mf.verificarLoginAdmin(user, contrasenia);

			if (adminLogueado != null) {
				JOptionPane.showMessageDialog(null, "Acceso concedido como Administrador");
				vf.getVp().mostrarPanel(vf.getVp().getPanelAdminVia());
			} else {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de Login",
						JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "registrarUsuario":
			vf.getVp().mostrarPanel(vf.getVp().getPanelLogin());
			break;

		case "pantallaCrearViaje":
			vf.getVp().mostrarPanel(vf.getVp().getCrearViaje());
			break;

		case "guardarNuevoViaje":
			vf.getVp().mostrarPanel(vf.getVp().getPanelAdminVia());
			break;

		case "pantallaEditarViaje":
			vf.getVp().mostrarPanel(vf.getVp().getEditarViaje());
			break;

		case "confirmarEdicionViaje":
			vf.getVp().mostrarPanel(vf.getVp().getPanelAdminVia());
			break;

		case "subirImagen":
			vf.getVp().getCrearViaje().cargarImagen();
			break;

		case "gestionUsuario":
			vf.getVp().mostrarPanel(vf.getVp().getPanelAdminUsu());
			break;

		case "pantallaEditarUsuario":
			int fila = vf.getVp().getPanelAdminUsu().getTablaUsuarios().getSelectedRow();
			if (fila != -1) {
				String nombre = vf.getVp().getPanelAdminUsu().getModelo().getValueAt(fila, 0).toString();
				String usuario = vf.getVp().getPanelAdminUsu().getModelo().getValueAt(fila, 1).toString();

				vf.getVp().getEditarUsuario().getLblUsuarioFijo().setText(usuario);
				vf.getVp().getEditarUsuario().getNombre().setText(nombre);

				vf.getVp().mostrarPanel(vf.getVp().getEditarUsuario());
			} else {
				JOptionPane.showMessageDialog(null, "Por favor seleccione un usuario de la tabla.");
			}
			break;

		case "confirmarEdicionUsuario":
			vf.getVp().mostrarPanel(vf.getVp().getPanelAdminUsu());
			break;

		case "eliminarUsuarioAdmin":
			break;

		case "volverAdminViajes":
			vf.getVp().mostrarPanel(vf.getVp().getPanelAdminVia());
			break;

		case "verDetalles":
			vf.getVp().mostrarPanel(vf.getVp().getPanelDetalleViaje());
			break;

		case "volverAlListado":
			vf.getVp().mostrarPanel(vf.getVp().getPanelListadoViaje());
			break;
		}
	}

	private void actualizarListaViajes() {
		JPanel contenedor = vf.getVp().getPanelListadoViaje().getContenedorTarjetas();
		contenedor.removeAll();
		for (int i = 0; i < 6; i++) {
			PanelViajeCard card = new PanelViajeCard();
			card.getBtnVer().addActionListener(this);
			card.getBtnVer().setActionCommand("verDetalles");
			contenedor.add(card);
		}
		contenedor.revalidate();
		contenedor.repaint();
	}
}