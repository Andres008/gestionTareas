package com.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.transacciones.Transacciones;
import com.utilitarios.Utilitarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtDirecion;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private  Login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setBounds(262, 10, 164, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(173, 55, 79, 13);
		contentPane.add(lblNewLabel_1);

		txtNombre = new JTextField();
		txtNombre.setBounds(262, 52, 164, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(262, 92, 164, 19);
		contentPane.add(txtApellido);

		JLabel lblNewLabel_1_1 = new JLabel("APELLIDO");
		lblNewLabel_1_1.setBounds(173, 95, 79, 13);
		contentPane.add(lblNewLabel_1_1);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(262, 133, 164, 19);
		contentPane.add(txtEmail);

		JLabel lblNewLabel_1_1_1 = new JLabel("EMAIL");
		lblNewLabel_1_1_1.setBounds(173, 136, 79, 13);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("DIRECCI\u00D3N");
		lblNewLabel_1_1_1_1.setBounds(173, 179, 79, 13);
		contentPane.add(lblNewLabel_1_1_1_1);

		txtDirecion = new JTextField();
		txtDirecion.setColumns(10);
		txtDirecion.setBounds(262, 176, 164, 19);
		contentPane.add(txtDirecion);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(262, 220, 164, 19);
		contentPane.add(txtUsuario);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("USUARIO");
		lblNewLabel_1_1_1_1_1.setBounds(173, 223, 79, 13);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("CLAVE");
		lblNewLabel_1_1_1_1_1_1.setBounds(173, 267, 79, 13);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);

		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(262, 264, 164, 19);
		contentPane.add(txtClave);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transacciones tr = new Transacciones();
				try {
					Utilitarios utilitarios = new Utilitarios();
					JOptionPane.showMessageDialog(null, tr.ingresarUsuario(txtNombre.getText(), txtApellido.getText(), txtEmail.getText(),
							txtDirecion.getText(), txtUsuario.getText(),utilitarios.getMd5(txtClave.getText())));
					txtNombre.setText("");
					txtApellido.setText("");
					txtClave.setText("");
					txtDirecion.setText("");
					txtEmail.setText("");
					txtUsuario.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnIngresar.setBounds(294, 303, 85, 21);
		contentPane.add(btnIngresar);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(70, 412, 89, 23);
		contentPane.add(btnNewButton);
	}

	public Registro(Login frame) {
		this();
		this.frame=frame;
	}
}
