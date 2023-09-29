package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Ejemplar;
import com.example.services.EjemplarService;

@RestController
public class EjemplarController {
    @Autowired
	EjemplarService service;
	
    @GetMapping(value = "ejemplares")
	public List<Ejemplar> mostrar(){
		return service.mostrarTodos();
	}
    
    @GetMapping(value = "ejemplar/{isbn}")
	public Optional<Ejemplar> mostrarUno(@PathVariable("isbn") int isbn){
		return service.mostrarUno(isbn);
	}

	@PostMapping(value = "ejemplar/{isbn}/{titulo}/{autor}")
	public List<Ejemplar> guardar(
			@PathVariable("isbn") int isbn, 
			@PathVariable("titulo") String titulo, 
			@PathVariable("autor") String autor){
		
		Ejemplar ejemplar = new Ejemplar(isbn,titulo,autor);
		
		return service.guardar(ejemplar);
	}

    @PutMapping(value = "ejemplar/{isbn}/{titulo}/{autor}")
	public void actualizar(
			@PathVariable("isbn") int isbn, 
			@PathVariable("titulo") String titulo, 
			@PathVariable("autor") String autor){
		
		Ejemplar ejemplar = new Ejemplar(isbn,titulo,autor);
		
		service.actualizar(ejemplar);
	}

	@DeleteMapping(value = "ejemplar/{isbn}")
	public List<Ejemplar> actualizar( @PathVariable("isbn") int isbn){
		return service.eliminar(isbn);
	}
}
