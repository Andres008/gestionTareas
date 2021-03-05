package com.tablas;

import java.util.Date;

public class Tarea {

	private int codigo;
	
	private String tarea;
	
	private String fecha;
	
	private String fechaEntrega;
	
	private String materia;
	
	private String profesor;
	
	private Double nota;
	
	public Tarea() {
		// TODO Auto-generated constructor stub
	}

	public Tarea(int codigo, String tarea, String fecha, String fechaEntrega, String materia, String profesor,
			double nota) {
		super();
		this.codigo = codigo;
		this.tarea = tarea;
		this.fecha = fecha;
		this.fechaEntrega = fechaEntrega;
		this.materia = materia;
		this.profesor = profesor;
		this.nota = nota;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	
	
	
}
