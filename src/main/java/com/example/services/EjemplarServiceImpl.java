package com.example.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.Ejemplar;


/**
 * Servicio que implementa todos los metodos
 */
@Service
public class EjemplarServiceImpl implements EjemplarService{
    @Autowired
	RestTemplate template;

	private String url = "http://localhost:8880/";

	@Override
	public List<Ejemplar> mostrarTodos() {
		return Arrays.asList(template.getForObject(url+"libros", Ejemplar[].class));
	}

	@Override
	public Optional<Ejemplar> mostrarUno(int isbn) {
		ResponseEntity<Optional<Ejemplar>> response = template.exchange(
                url + "libro/{isbn}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Optional<Ejemplar>>() {},
                isbn
        );
		return response.getBody();
	}

	@Override
	public List<Ejemplar> guardar(Ejemplar ejemplar) {
		template.postForLocation(url + "libro", ejemplar);
		return Arrays.asList(template.getForObject(url + "libros", Ejemplar[].class));

	}

	@Override
	public void actualizar(Ejemplar ejemplar) {
		template.postForLocation(url + "libro", ejemplar);
	}

	@Override
	public List<Ejemplar> eliminar(int isbn) {
		template.delete(url + "libro/" + isbn, Ejemplar[].class);
		return Arrays.asList(template.getForObject(url+"libros", Ejemplar[].class));
	}
}
