package com.usco.parcial.parcialpw.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import co.edu.usco.pw.springboot_crud01.service.IUsuarioService;

@Configuration
@EnableWebSecurity
public class Seguridad {
	
	@Autowired
	private IUsuarioService Iusuarioservice;

	@Bean
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

	//AUTENTICACION
	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(Iusuarioservice);
		// setPasswordEncoder -->
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Override
	protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());

	}

	@Override
	protected void configure(HttpSecurity http) throws  Exception{

		http.csrf().disable().authorizeRequests()
				//LAS RUTAS CON SUS PERMIOS
		
				//.antMatchers("/").permitAll() comentado por seguridad
		        .antMatchers("/list-todos","/h2-console/**","/*todo*/**").hasAnyRole("ADMIN","USER")
		        .antMatchers("/add-todo").hasRole("ADMIN")
		        .antMatchers("/delete-todo").hasRole("ADMIN")
		        .antMatchers("/update-todo").hasRole("ADMIN")
		        .antMatchers("/").hasAnyRole("ADMIN","USER")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				//DESPUES DEL INICIO DE SESION MANDAME A ESTA RUTA
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
				.logout()
				.logoutSuccessUrl("/login")
				.permitAll();
		        http.headers().frameOptions().disable();  
	}

}
