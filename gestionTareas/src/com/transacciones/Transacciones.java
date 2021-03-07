package com.transacciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.conexion.Conexion;
import com.tablas.Tarea;

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
		String sql = "INSERT INTO tarea(tarea, fecha, fecha_entrega, materia, profesor,nota) VALUES (?,?,?,?,?,?)";

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		PreparedStatement statement = conn.getConnection().prepareStatement(sql);
		statement.setString(1, tarea);
		statement.setString(2, formatoFecha.format(fecha));
		statement.setString(3, formatoFecha.format(fecha_entrega));
		statement.setString(4, materia);
		statement.setString(5, profesor);
		statement.setDouble(6, 0);
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
		String sql = "SELECT codigo, tarea, fecha, fecha_entrega,materia, profesor,nota FROM tarea where fecha_entrega>NOW() order by fecha_entrega ASC";
		Statement statement;
		try {
			statement = conn.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			int tamanio = 0;
			while (result.next()) {
				tamanio++;
			}
			String resultado[] = new String[tamanio + 1];
			result.beforeFirst();
			tamanio = 1;
			resultado[0] = "CÓDIGO,   TAREA,   FECHA,   FECHA_ENTREGA,   MATERIA,   PROFESOR, NOTA";
			while (result.next()) {
				String res = result.getString(1) + ",     " + result.getString(2) + ",     " + result.getString(3)
						+ ",     " + result.getString(4) + ",     " + result.getString(5) + ",     "
						+ result.getString(6) + ",     " + result.getString(7);
				resultado[tamanio] = res;
				tamanio++;
			}
			return resultado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Tarea buscarTareaCodigo(String string) throws SQLException {
		String sql = "SELECT * FROM tarea WHERE codigo =" + string;
		Statement statement;
		Tarea tarea;
		statement = conn.getConnection().createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			tarea = new Tarea(Integer.parseInt(result.getString(1)), result.getString(2), result.getString(3),
					result.getString(4), result.getString(5), result.getString(6),
					Double.parseDouble(result.getString(7)));
			return tarea;
		}
		return null;
	}

	public String modificarNotaTarea(Tarea tarea) throws SQLException {
		String sql = "UPDATE tarea SET nota=" + tarea.getNota() + " WHERE codigo=" + tarea.getCodigo();
		PreparedStatement statement = conn.getConnection().prepareStatement(sql);
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			return "Actualización Correcta";
		}
		return "No se actualizó ningun dato.";

	}

	public String eliminarTarea(Tarea tarea) throws SQLException {

		String sql = "DELETE FROM tarea WHERE codigo=" + tarea.getCodigo();
		PreparedStatement statement = conn.getConnection().prepareStatement(sql);
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0)
			return "Tarea borrada exitosamente.!";
		return "No se borro ningun dato.";

	}

	public String[] buscarTareas() throws SQLException {
		String sql = "SELECT DISTINCT MATERIA FROM tarea";
		List<String> lstResultado = new ArrayList<String>();
		Statement statement;
		statement = conn.getConnection().createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			lstResultado.add(result.getString(1));
		}
		return lstResultado.toArray(new String[0]);
	}

	public String[] tareasMateria(String materia) {
		String sql = "SELECT codigo, tarea, fecha, fecha_entrega,materia, profesor,nota FROM tarea where materia='"
				+ materia + "' order by fecha_entrega ASC";
		Statement statement;
		try {
			statement = conn.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			int tamanio = 0;
			while (result.next()) {
				tamanio++;
			}
			String resultado[] = new String[tamanio + 1];
			result.beforeFirst();
			tamanio = 1;
			resultado[0] = "CÓDIGO,   TAREA,   FECHA,   FECHA_ENTREGA,   MATERIA,   PROFESOR, NOTA";
			while (result.next()) {
				String res = result.getString(1) + ",     " + result.getString(2) + ",     " + result.getString(3)
						+ ",     " + result.getString(4) + ",     " + result.getString(5) + ",     "
						+ result.getString(6) + ",     " + result.getString(7);
				resultado[tamanio] = res;
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
