package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.utilitarios.Utilitarios;

public class Conexion {

	static String bd = "gestiontareas";
	static String login = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost/" + bd;
	Connection connection = null;

	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null) {
				System.out.println("Conexión a base de datos " + bd + " OK\n");				
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		connection = null;
	}

}
