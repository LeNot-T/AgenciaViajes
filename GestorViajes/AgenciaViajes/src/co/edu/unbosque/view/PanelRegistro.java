package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelRegistro extends JPanel {

    private JTextField txtNombre;
    private JTextField txtUsuario;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JPasswordField txtContrasenia;

    private JLabel lblTitulo, lblSubtitulo;
    private JLabel lblNombre, lblUsuario, lblCorreo, lblTelefono, lblContrasenia;

    private JButton btnRegistrar, btnVolver;

    public PanelRegistro() {

        setBounds(0, 0, 600, 400);
        setLayout(null);
        setBackground(Color.decode("#E8F5E9"));

        inicializarComponentes();
        agregarComponentes();
    }

    private void inicializarComponentes() {

        // ===== TITULOS =====
        lblTitulo = new JLabel("Crear cuenta", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 20, 600, 35);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.decode("#1B5E20"));

        lblSubtitulo = new JLabel("Registro de usuario", SwingConstants.CENTER);
        lblSubtitulo.setBounds(0, 50, 600, 20);
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblSubtitulo.setForeground(Color.decode("#2E7D32"));

        // ===== LABELS =====
        lblNombre = new JLabel("Nombre completo:");
        lblNombre.setBounds(120, 90, 150, 25);

        lblUsuario = new JLabel("Nombre de usuario:");
        lblUsuario.setBounds(120, 130, 150, 25);

        lblCorreo = new JLabel("Correo electrónico:");
        lblCorreo.setBounds(120, 170, 150, 25);

        lblTelefono = new JLabel("Número de teléfono:");
        lblTelefono.setBounds(120, 210, 150, 25);

        lblContrasenia = new JLabel("Contraseña:");
        lblContrasenia.setBounds(120, 250, 150, 25);

        Color texto = Color.decode("#1B5E20");
        lblNombre.setForeground(texto);
        lblUsuario.setForeground(texto);
        lblCorreo.setForeground(texto);
        lblTelefono.setForeground(texto);
        lblContrasenia.setForeground(texto);

        // ===== CAMPOS =====
        txtNombre = new JTextField();
        txtNombre.setBounds(280, 90, 200, 28);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(280, 130, 200, 28);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(280, 170, 200, 28);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(280, 210, 200, 28);

        txtContrasenia = new JPasswordField();
        txtContrasenia.setBounds(280, 250, 200, 28);

        // ===== BOTONES =====
        btnRegistrar = new JButton("Registrarse");
        btnRegistrar.setBounds(170, 300, 150, 35);
        btnRegistrar.setBackground(Color.decode("#2E7D32"));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(330, 300, 150, 35);
        btnVolver.setBackground(Color.decode("#FBC02D"));
        btnVolver.setForeground(Color.decode("#1B5E20"));
        btnVolver.setFocusPainted(false);
    }

    private void agregarComponentes() {
        add(lblTitulo);
        add(lblSubtitulo);

        add(lblNombre);
        add(lblUsuario);
        add(lblCorreo);
        add(lblTelefono);
        add(lblContrasenia);

        add(txtNombre);
        add(txtUsuario);
        add(txtCorreo);
        add(txtTelefono);
        add(txtContrasenia);

        add(btnRegistrar);
        add(btnVolver);
    }

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JPasswordField getTxtContrasenia() {
		return txtContrasenia;
	}

	public void setTxtContrasenia(JPasswordField txtContrasenia) {
		this.txtContrasenia = txtContrasenia;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblSubtitulo() {
		return lblSubtitulo;
	}

	public void setLblSubtitulo(JLabel lblSubtitulo) {
		this.lblSubtitulo = lblSubtitulo;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JLabel getLblTelefono() {
		return lblTelefono;
	}

	public void setLblTelefono(JLabel lblTelefono) {
		this.lblTelefono = lblTelefono;
	}

	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

    
}