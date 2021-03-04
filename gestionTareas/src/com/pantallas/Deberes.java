package com.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.transacciones.Transacciones;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;

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
		setBounds(100, 100, 537, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DEBERES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(216, 11, 93, 14);
		contentPane.add(lblNewLabel);

		JButton btnNuevaTarea = new JButton("NUEVA TAREA");
		btnNuevaTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevaTarea nuevaTarea = new NuevaTarea(frame);
				setVisible(false);
				nuevaTarea.show();
			}
		});
		btnNuevaTarea.setBounds(208, 51, 112, 23);
		contentPane.add(btnNuevaTarea);
		
		JList listDeberes = new JList();
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
		listDeberes.setBounds(31, 94, 452, 230);
		contentPane.add(listDeberes);
	}

	public Deberes(Login frame) {
		this();
		this.frame = new Deberes();
		this.frame.setVisible(true);
		this.frameLogin = frame;
	}
}
