package com.example.services;

import java.util.List;
import java.util.Optional;


import com.example.model.Ejemplar;

/**
 * Interfaz que indica que metodos vamos a usar en el Servicio
 */
public interface EjemplarService {
    
    List<Ejemplar> mostrarTodos();

	Optional<Ejemplar> mostrarUno(int isbn);

	List<Ejemplar> guardar(Ejemplar ejemplar);

	void actualizar(Ejemplar ejemplar);

	List<Ejemplar> eliminar(int isbn);
}
