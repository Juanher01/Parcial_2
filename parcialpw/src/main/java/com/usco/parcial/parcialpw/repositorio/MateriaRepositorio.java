package com.usco.parcial.parcialpw.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usco.parcial.parcialpw.modelo.Materias;



public interface MateriaRepositorio extends JpaRepository<Materias, Long>{
	List<Materias> findByUserName(String user);

}
