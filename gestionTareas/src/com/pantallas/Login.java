package com.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.transacciones.Transacciones;
import com.utilitarios.Utilitarios;

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
		setBounds(100, 100, 384, 300);
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
		btnIngresar.setBounds(132, 168, 89, 23);
		contentPane.add(btnIngresar);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 74, 77, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(10, 116, 77, 14);
		contentPane.add(lblNewLabel_1);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(97, 71, 132, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		pswContrase = new JPasswordField();
		pswContrase.setBounds(97, 113, 132, 20);
		contentPane.add(pswContrase);
		
		lblNewLabel_2 = new JLabel("INGRESO SISTEMA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(97, 11, 200, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Registro reg = new Registro(frame);
				reg.show();
			}
		});
		btnRegistrar.setBounds(10, 227, 107, 23);
		contentPane.add(btnRegistrar);
	}
}
