package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {

    // Paneles
    private PanelLogin panelLogin;
    private PanelRegistro panelRegistro;
    private PanelAdminUsuarios panelAdminUsu;
    private PanelAdminViajes panelAdminVia;
    private PanelDetalleViaje panelDetalleViaje;
    private PanelListadoViajes panelListadoViaje;
    private PanelViajeCard viajeCard;
    private PanelCrearViaje crearViaje;
    private PanelEditarViaje editarViaje;
    private PanelEditarUsuario editarUsuario;


    public VentanaPrincipal() {
        setTitle("Agencia de Viajes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        inicializarPaneles();
        mostrarPanel(panelLogin);
    }

    private void inicializarPaneles() {
        panelLogin = new PanelLogin();
        panelRegistro = new PanelRegistro();
        panelAdminUsu = new PanelAdminUsuarios();
        panelAdminVia = new PanelAdminViajes();
        panelDetalleViaje = new PanelDetalleViaje();
        panelListadoViaje = new PanelListadoViajes();
        viajeCard = new PanelViajeCard();
        crearViaje = new PanelCrearViaje();
        editarViaje = new PanelEditarViaje();
        editarUsuario = new PanelEditarUsuario();

        add(panelLogin);
        add(panelRegistro);
        add(panelAdminUsu);
        add(panelAdminVia);
        add(panelDetalleViaje);
        add(panelListadoViaje);
        add(viajeCard);
        add(crearViaje);
        add(editarViaje);
        add(editarUsuario);
    }

    public void mostrarPanel(JPanel panel) {
        panelLogin.setVisible(false);
        panelRegistro.setVisible(false);
        panelAdminUsu.setVisible(false);
        panelAdminVia.setVisible(false);
        panelDetalleViaje.setVisible(false);
        panelListadoViaje.setVisible(false);
        viajeCard.setVisible(false);
        crearViaje.setVisible(false);
        editarViaje.setVisible(false);
        editarUsuario.setVisible(false);

        panel.setVisible(true);
    }
	public PanelLogin getPanelLogin() {
		return panelLogin;
	}

	public void setPanelLogin(PanelLogin panelLogin) {
		this.panelLogin = panelLogin;
	}

	public PanelRegistro getPanelRegistro() {
		return panelRegistro;
	}

	public void setPanelRegistro(PanelRegistro panelRegistro) {
		this.panelRegistro = panelRegistro;
	}

	public PanelAdminUsuarios getPanelAdminUsu() {
		return panelAdminUsu;
	}

	public void setPanelAdminUsu(PanelAdminUsuarios panelAdminUsu) {
		this.panelAdminUsu = panelAdminUsu;
	}

	public PanelAdminViajes getPanelAdminVia() {
		return panelAdminVia;
	}

	public void setPanelAdminVia(PanelAdminViajes panelAdminVia) {
		this.panelAdminVia = panelAdminVia;
	}

	public PanelDetalleViaje getPanelDetalleViaje() {
		return panelDetalleViaje;
	}

	public void setPanelDetalleViaje(PanelDetalleViaje panelDetalleViaje) {
		this.panelDetalleViaje = panelDetalleViaje;
	}

	public PanelListadoViajes getPanelListadoViaje() {
		return panelListadoViaje;
	}

	public void setPanelListadoViaje(PanelListadoViajes panelListadoViaje) {
		this.panelListadoViaje = panelListadoViaje;
	}

	public PanelViajeCard getViajeCard() {
		return viajeCard;
	}

	public void setViajeCard(PanelViajeCard viajeCard) {
		this.viajeCard = viajeCard;
	}

	public PanelCrearViaje getCrearViaje() {
		return crearViaje;
	}

	public void setCrearViaje(PanelCrearViaje crearViaje) {
		this.crearViaje = crearViaje;
	}

	public PanelEditarViaje getEditarViaje() {
		return editarViaje;
	}

	public void setEditarViaje(PanelEditarViaje editarViaje) {
		this.editarViaje = editarViaje;
	}

	public PanelEditarUsuario getEditarUsuario() {
		return editarUsuario;
	}

	public void setEditarUsuario(PanelEditarUsuario editarUsuario) {
		this.editarUsuario = editarUsuario;
	}

    
    
    

}