package com.novellius.pojo;

import java.sql.Timestamp;

public class Admin {

	private int idAd;
	private int carnet;
	private String estudiante;
	private String carrera;
	private int promedio;
	private Timestamp fechaCreacion;

	public Admin() {

	}

	public Admin(int idAd, int carnet, String estudiante, String carrera, int promedio, Timestamp fechaCreacion) {
		this.idAd = idAd;
		this.carnet = carnet;
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.promedio = promedio;
		this.fechaCreacion = fechaCreacion;
	}

	public Admin(int carnet, String estudiante, String carrera, int promedio, Timestamp fechaCreacion) {
		this.carnet = carnet;
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.promedio = promedio;
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdAd() {
		return idAd;
	}

	public int getCarnet() {
		return carnet;
	}

	public void setCarnet(int carnet) {
		this.carnet = carnet;
	}

	public String getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getPromedio() {
		return promedio;
	}

	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Admin [idAd=" + idAd + ", carnet=" + carnet + ", estudiante=" + estudiante + ", carrera=" + carrera
				+ ", promedio=" + promedio + ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	

}
