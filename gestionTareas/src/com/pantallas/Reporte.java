package com.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.transacciones.Transacciones;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reporte extends JFrame {

	private JPanel contentPane;
	private JList lstLista;
	private JSpinner spinner;
	private Deberes deberFrame;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte frame = new Reporte();
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
	public Reporte() {
		Transacciones tr = new Transacciones();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 654, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				llenarLista();
			}
		});
		try {
			spinner.setModel(new SpinnerListModel(tr.buscarTareas()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spinner.setBounds(239, 11, 163, 20);
		contentPane.add(spinner);
		
		 lstLista = new JList();
		 llenarLista();
		lstLista.setBounds(24, 46, 564, 322);
		contentPane.add(lstLista);
		
		btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				deberFrame.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 378, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public Reporte(Deberes frame) {
		this();
		deberFrame=frame;
	}

	public void llenarLista() {
		Transacciones tr = new Transacciones();
		lstLista.setModel(new AbstractListModel() {
			String[] values = tr.tareasMateria(spinner.getValue().toString());
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}
}
