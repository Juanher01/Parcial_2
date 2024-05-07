package com.usco.parcial.parcialpw.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.usco.pw.springboot_crud01.service.UsuarioService;

@Controller
public class ControladorIndex {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}
	//Enviar en el formulario de Login
	@PostMapping("/login")
	
	//RequestParam es el equivalente a getParameter
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        try {
            UserDetails userDetails = usuarioService.loadUserByUsername(username);
            System.out.println(userDetails);
            if (passwordEncoder.matches(password, userDetails.getPassword())) {
                // Autenticación exitosa, redirigir al usuario a la página de inicio
                return "redirect:/user";
            } else {
                // La contraseña es incorrecta, mostrar un mensaje de error
                model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
                return "login";
            }
        } catch (UsernameNotFoundException e) {
            // El nombre de usuario no existe, mostrar un mensaje de error
            model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
            return "login";
        }
    }
	

}
