package com.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import com.transacciones.Transacciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevaTarea extends JFrame {

	private JPanel contentPane;
	private JTextField txtTarea;
	private JTextField txtMateria;
	private JTextField txtProfesor;
	private JCalendar clFecha;
	private JCalendar clFechaEntrega;
	private static Deberes deberes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaTarea frame = new NuevaTarea();
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
	public NuevaTarea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("TAREA");
		lblNewLabel.setBounds(10, 39, 102, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("FECHA");
		lblNewLabel_1.setBounds(10, 64, 102, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("FECHA ENTREGA");
		lblNewLabel_2.setBounds(281, 64, 102, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("MATERIA");
		lblNewLabel_3.setBounds(10, 231, 102, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("PROFESOR");
		lblNewLabel_4.setBounds(10, 262, 102, 14);
		contentPane.add(lblNewLabel_4);

		txtTarea = new JTextField();
		txtTarea.setBounds(109, 36, 162, 20);
		contentPane.add(txtTarea);
		txtTarea.setColumns(10);

		txtMateria = new JTextField();
		txtMateria.setColumns(10);
		txtMateria.setBounds(109, 228, 162, 20);
		contentPane.add(txtMateria);

		txtProfesor = new JTextField();
		txtProfesor.setColumns(10);
		txtProfesor.setBounds(109, 259, 162, 20);
		contentPane.add(txtProfesor);

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Transacciones tr = new Transacciones();
				try {
					tr.ingresarTarea(txtTarea.getText(), clFecha.getCalendar().getTime(),
							clFechaEntrega.getCalendar().getTime(), txtMateria.getText(), txtProfesor.getText());
					txtTarea.setText("");
					txtProfesor.setText("");
					txtMateria.setText("");
					JOptionPane.showMessageDialog(null, "Tarea ingresada correctamente.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(253, 290, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Regresar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				deberes= new Deberes();
				deberes.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(23, 364, 89, 23);
		contentPane.add(btnNewButton_1);

		clFecha = new JCalendar();
		clFecha.setBounds(87, 64, 184, 153);
		contentPane.add(clFecha);

		clFechaEntrega = new JCalendar();
		clFechaEntrega.setBounds(383, 64, 184, 153);
		contentPane.add(clFechaEntrega);
	}

	public NuevaTarea(Deberes frame) {
		this();
		deberes= frame;
	}

	
}
