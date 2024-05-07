package com.usco.parcial.parcialpw.modelo;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "materias")
public class Materias {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String materia; 

	private String descripcion; 

	private LocalTime inicioAsignatura;

	private LocalTime finAsignatura;

	private String docenteEncargado;
	
	 public Materias() {
	        super();
	    }

	    public Materias(String user, String desc, LocalTime inicioAsignatura, LocalTime finAsignatura, String docenteEncargado) {
	        super();
	        this.materia = user;
	        this.descripcion = desc;
	        this.inicioAsignatura = inicioAsignatura;
	        this.finAsignatura = finAsignatura;
	        this.docenteEncargado = docenteEncargado;
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getUserName() {
	        return materia;
	    }

	    public void setUserName(String materia) {
	        this.materia = materia;
	    }

	    public String getDescription() {
	        return descripcion;
	    }

	    public void setDescription(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public LocalTime getInicioAsignatura() {
	        return inicioAsignatura;
	    }

	    public void setInicioAsignatura(LocalTime inicioAsignatura) {
	        this.inicioAsignatura = inicioAsignatura;
	    }

	    public LocalTime getFinAsignatura() {
	        return finAsignatura;
	    }

	    public void setFinAsignatura(LocalTime finAsignatura) {
	        this.finAsignatura = finAsignatura;
	    }

	    public String getDocenteEncargado() {
	        return docenteEncargado;
	    }

	    public void setDocenteEncargado(String docenteEncargado) {
	        this.docenteEncargado = docenteEncargado;
	    }
	}


