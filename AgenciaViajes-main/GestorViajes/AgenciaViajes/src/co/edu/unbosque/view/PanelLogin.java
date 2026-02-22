package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelLogin extends JPanel {

    private JPasswordField contrasenia;
    private JTextField usuario;
    private JLabel lblUsuario, lblContrasenia, lblTitulo, lblSubtitulo;
    private JButton login, registro;

    public PanelLogin() {

        setBounds(0, 0, 600, 400);
        setLayout(null);
        setBackground(Color.decode("#E8F5E9")); // fondo verde suave

        inicializarComponentes();
        agregarComponentes();
    }

    private void inicializarComponentes() {

        lblTitulo = new JLabel("Viajes sin dinero $$$", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 30, 600, 40);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(Color.decode("#1B5E20"));

        lblSubtitulo = new JLabel("Descubre destinos increíbles", SwingConstants.CENTER);
        lblSubtitulo.setBounds(0, 65, 600, 20);
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(Color.decode("#2E7D32"));

        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(180, 120, 100, 25);
        lblUsuario.setForeground(Color.decode("#1B5E20"));

        lblContrasenia = new JLabel("Contraseña:");
        lblContrasenia.setBounds(180, 170, 100, 25);
        lblContrasenia.setForeground(Color.decode("#1B5E20"));

        usuario = new JTextField();
        usuario.setBounds(180, 145, 240, 30);
        usuario.setBackground(Color.WHITE);

        contrasenia = new JPasswordField();
        contrasenia.setBounds(180, 195, 240, 30);
        contrasenia.setBackground(Color.WHITE);
        
        login = new JButton("Iniciar sesión ✈️");
        login.setBounds(180, 245, 240, 35);
        login.setBackground(Color.decode("#2E7D32"));
        login.setForeground(Color.WHITE);
        login.setFocusPainted(false);

        registro = new JButton("Registrarse");
        registro.setBounds(180, 290, 240, 35);
        registro.setBackground(Color.decode("#FBC02D"));
        registro.setForeground(Color.decode("#1B5E20"));
        registro.setFocusPainted(false);
    }

    private void agregarComponentes() {
        add(lblTitulo);
        add(lblSubtitulo);
        add(lblUsuario);
        add(usuario);
        add(lblContrasenia);
        add(contrasenia);
        add(login);
        add(registro);
    }

	public JPasswordField getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(JPasswordField contrasenia) {
		this.contrasenia = contrasenia;
	}

	public JTextField getUsuario() {
		return usuario;
	}

	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
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

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getRegistro() {
		return registro;
	}

	public void setRegistro(JButton registro) {
		this.registro = registro;
	}

    
}