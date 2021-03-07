package com.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tablas.Tarea;
import com.transacciones.Transacciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;

public class RegistrarNota extends JFrame {

	private JPanel contentPane;
	private Deberes deberFrame;
	private Tarea tarea;
	private JLabel lblTarea;
	private JLabel lblFechas;
	private JLabel lblFecha;
	private JLabel lblFechaEnt;
	private JLabel lblFechaEntrega;
	private JLabel lblMat;
	private JLabel lblMateria;
	private JLabel lblProfe;
	private JLabel lblProfesor;
	private JLabel lblNota;
	private JTextField txtNota;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarNota frame = new RegistrarNota();
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
	public RegistrarNota() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				deberFrame = new Deberes();
				deberFrame.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 320, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Tarea:");
		lblNewLabel.setBounds(24, 50, 46, 14);
		contentPane.add(lblNewLabel);

		lblTarea = new JLabel("New label");
		lblTarea.setBounds(131, 50, 293, 14);
		contentPane.add(lblTarea);

		lblFechas = new JLabel("Fecha:");
		lblFechas.setBounds(24, 75, 46, 14);
		contentPane.add(lblFechas);

		lblFecha = new JLabel("New label");
		lblFecha.setBounds(131, 75, 293, 14);
		contentPane.add(lblFecha);

		lblFechaEnt = new JLabel("Fecha Entrega:");
		lblFechaEnt.setBounds(24, 100, 89, 14);
		contentPane.add(lblFechaEnt);

		lblFechaEntrega = new JLabel("New label");
		lblFechaEntrega.setBounds(131, 100, 293, 14);
		contentPane.add(lblFechaEntrega);

		lblMat = new JLabel("Materia:");
		lblMat.setBounds(24, 125, 89, 14);
		contentPane.add(lblMat);

		lblMateria = new JLabel("New label");
		lblMateria.setBounds(131, 125, 293, 14);
		contentPane.add(lblMateria);

		lblProfe = new JLabel("Profesor:");
		lblProfe.setBounds(24, 150, 89, 14);
		contentPane.add(lblProfe);

		lblProfesor = new JLabel("New label");
		lblProfesor.setBounds(131, 150, 293, 14);
		contentPane.add(lblProfesor);

		lblNota = new JLabel("Nota");
		lblNota.setBounds(24, 175, 89, 14);
		contentPane.add(lblNota);

		txtNota = new JTextField();
		txtNota.setBounds(131, 175, 103, 20);
		contentPane.add(txtNota);
		txtNota.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Registro Nota");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(143, 11, 169, 28);
		contentPane.add(lblNewLabel_1);

		btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Transacciones tr = new Transacciones();
					tarea.setNota(Double.parseDouble(txtNota.getText()));
					System.out.println(tarea.getNota());
					JOptionPane.showMessageDialog(null, tr.modificarNotaTarea(tarea));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(75, 216, 89, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transacciones tr = new Transacciones();
				try {
					int res = JOptionPane.showConfirmDialog(null, "Desea eliminar la tarea?",
							"Confirmación de eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (res == 0) {
						JOptionPane.showMessageDialog(null, tr.eliminarTarea(tarea));
						setVisible(false);
						deberFrame = new Deberes();
						deberFrame.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(223, 216, 89, 23);
		contentPane.add(btnNewButton_2);
	}

	public RegistrarNota(Deberes pFrame, Tarea pTarea) {
		this();
		deberFrame = pFrame;
		tarea = pTarea;
		lblTarea.setText(pTarea.getTarea());
		lblFecha.setText(pTarea.getFecha());
		lblFechaEntrega.setText(pTarea.getFechaEntrega());
		lblMateria.setText(pTarea.getMateria());
		lblProfesor.setText(pTarea.getProfesor());
		txtNota.setText(pTarea.getNota().toString());
	}
}
