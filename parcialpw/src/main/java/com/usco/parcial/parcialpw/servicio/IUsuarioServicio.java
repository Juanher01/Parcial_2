package com.usco.parcial.parcialpw.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.usco.parcial.parcialpw.modelo.Usuario;




public interface IUsuarioServicio extends UserDetailsService {
	
	public List<Usuario> BuscarTodos();

}
