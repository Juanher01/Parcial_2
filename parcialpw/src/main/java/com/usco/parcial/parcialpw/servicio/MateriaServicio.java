package com.usco.parcial.parcialpw.servicio;

import java.time.LocalTime;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.parcial.parcialpw.modelo.Materias;
import com.usco.parcial.parcialpw.repositorio.MateriaRepositorio;


@Service
public class MateriaServicio implements IMateriaServicio {

	@Autowired
	private MateriaRepositorio todoRepository;
	
	

	@Override
	public List<Materias> getTodosByUser(String user) {
		return todoRepository.findByUserName(user);
	}

	@Override
	public Optional<Materias> getTodoById(long id) {
		return todoRepository.findById(id);
	}

	@Override
	public void updateTodo(Materias todo) {
		todoRepository.save(todo);
	}

	@Override
	public void addTodo(String user, String desc, LocalTime inicioAsignatura, LocalTime finAsignatura, String docenteEncargado) {
		todoRepository.save(new Materias(user, desc, inicioAsignatura, finAsignatura, docenteEncargado));
	}

	@Override
	public void deleteTodo(long id) {
		Optional<Materias> todo = todoRepository.findById(id);
		if (todo.isPresent()) {
			todoRepository.delete(todo.get());
		}
	}

	@Override
	public void saveTodo(Materias todo) {
		todoRepository.save(todo);
	}

}
