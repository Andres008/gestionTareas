package com.transacciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.conexion.Conexion;

public class Transacciones {

	Conexion conn = new Conexion();

	public String ingresarUsuario(String nombre, String apellido, String email, String direccion, String usuario,
			String clave) throws Exception {
		String sql = "INSERT INTO usuarios(nombre, apellido, email, direccion, usuario,clave) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement statement = conn.getConnection().prepareStatement(sql);
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setString(3, email);
			statement.setString(4, direccion);
			statement.setString(5, usuario);
			statement.setString(6, clave);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0)
				return "Ingreso Correcto";
			else
				throw new Exception("Error al ingresar usuarios, ");
		} catch (SQLException e) {
			throw new Exception("Error al ingresar usuarios, " + e.getMessage());
		}

	}

	public String ingresarTarea(String tarea, Date fecha, Date fecha_entrega, String materia, String profesor)
			throws Exception {
		String sql = "INSERT INTO tarea(tarea, fecha, fecha_entrega, materia, profesor) VALUES (?,?,?,?,?)";

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		PreparedStatement statement = conn.getConnection().prepareStatement(sql);
		statement.setString(1, tarea);
		statement.setString(2, formatoFecha.format(fecha));
		statement.setString(3, formatoFecha.format(fecha_entrega));
		statement.setString(4, materia);
		statement.setString(5, profesor);
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0)
			return "Ingreso Correcto";
		else
			throw new Exception("Error al ingresar usuarios, ");
	}

	public boolean logear(String usuario, String contrasenia) {
		String sql = "SELECT * FROM usuarios where usuario ='" + usuario + "' AND CLAVE = '" + contrasenia + "' ";
		Statement statement;
		try {
			statement = conn.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			int count = 0;
			while (result.next()) {
				count++;
			}
			if (count == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public String[] tareasPendientes() {
		String sql = "SELECT codigo, tarea, fecha, fecha_entrega,materia, profesor FROM tarea where fecha_entrega>NOW() order by fecha_entrega ASC";
		Statement statement;
		try {
			statement = conn.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			int tamanio = 0;
			while (result.next()) {
				tamanio++;
			}
			String resultado[] = new String[tamanio];
			result.beforeFirst();
			tamanio = 0;
			while (result.next()) {
				resultado[tamanio] = result.getString(1) + ",   " + result.getString(2) + ",      " + result.getString(3)
						+ ",      " + result.getString(4) + ",      " + result.getString(5) + ",      " + result.getString(6);
				tamanio++;
			}
			return resultado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
