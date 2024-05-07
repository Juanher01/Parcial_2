package com.usco.parcial.parcialpw.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usco.parcial.parcialpw.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Long>{
	
	public Usuario findByUsername(String username); 
	

}
