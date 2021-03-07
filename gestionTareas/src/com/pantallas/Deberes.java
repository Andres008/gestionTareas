package com.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tablas.Tarea;
import com.transacciones.Transacciones;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Deberes extends JFrame {

	private JPanel contentPane;
	private Login frameLogin;
	private static Deberes frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Deberes();
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
	public Deberes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DEBERES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(360, 11, 93, 14);
		contentPane.add(lblNewLabel);

		JButton btnNuevaTarea = new JButton("NUEVA TAREA");
		btnNuevaTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevaTarea nuevaTarea = new NuevaTarea(frame);
				setVisible(false);
				nuevaTarea.show();
			}
		});
		btnNuevaTarea.setBounds(327, 60, 153, 23);
		contentPane.add(btnNuevaTarea);
		
		JList listDeberes = new JList();
		listDeberes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					if (listDeberes.getSelectedIndex() != 0) {
						setVisible(false);
						Transacciones tr = new Transacciones();
						String datos[] = listDeberes.getSelectedValue().toString().split(",");
						Tarea tarea = tr.buscarTareaCodigo(datos[0]);
						RegistrarNota nota = new RegistrarNota(frame,tarea);
						nota.show();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		listDeberes.setModel(new AbstractListModel() {
			Transacciones tr = new Transacciones();
			String[] values =tr.tareasPendientes();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listDeberes.setBounds(31, 94, 732, 230);
		contentPane.add(listDeberes);
		
		JButton btnNewButton = new JButton("Reporte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Reporte reporte = new Reporte(frame);
				reporte.show();
			}
		});
		btnNewButton.setBounds(327, 335, 153, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir del Sistema");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				frameLogin = new Login();
				frameLogin.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 347, 153, 23);
		contentPane.add(btnNewButton_1);
	}

	public Deberes(Login frame) {
		this();
		this.frameLogin = frame;
	}
}
