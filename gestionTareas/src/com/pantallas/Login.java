package com.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.transacciones.Transacciones;
import com.utilitarios.Utilitarios;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pswContrase;
	private JLabel lblNewLabel_2;
	private static Login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Utilitarios utilitarios = new Utilitarios();
				Transacciones tr = new Transacciones();
				if (tr.logear(txtUsuario.getText(), utilitarios.getMd5(pswContrase.getText()))){
					Deberes deber = new Deberes(frame);
					setVisible(false);
					deber.show();
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña invalido.\n Si no se encuentra registrado favor realizar el registro.");
			}
		});
		btnIngresar.setBounds(249, 260, 89, 23);
		contentPane.add(btnIngresar);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(178, 170, 77, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(178, 212, 77, 14);
		contentPane.add(lblNewLabel_1);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(265, 167, 132, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		pswContrase = new JPasswordField();
		pswContrase.setBounds(265, 209, 132, 20);
		contentPane.add(pswContrase);
		
		lblNewLabel_2 = new JLabel("INGRESO SISTEMA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(223, 11, 200, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Registro reg = new Registro(frame);
				reg.show();
			}
		});
		btnRegistrar.setBounds(10, 342, 107, 23);
		contentPane.add(btnRegistrar);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(Login.class.getResource("/imagenes/TAREAS.png")));
		lblImagen.setBounds(141, 36, 387, 123);
		contentPane.add(lblImagen);
	}
}
