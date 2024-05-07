package com.usco.parcial.parcialpw.servicio;

import java.time.LocalTime;

import java.util.List;
import java.util.Optional;

import com.usco.parcial.parcialpw.modelo.Materias;



public interface IMateriaServicio {
	
	List<Materias> getTodosByUser(String user);

	Optional<Materias> getTodoById(long id);

	void updateTodo(Materias todo);

	void addTodo(String user, String desc, LocalTime inicioAsignatura, LocalTime finAsignatura, String docenteEncargado);

	void deleteTodo(long id);
	
	void saveTodo(Materias todo);

}
