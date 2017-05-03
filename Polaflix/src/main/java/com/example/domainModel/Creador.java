package com.example.domainModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Clase que implementa un creador de series 
 */
@Entity
public class Creador extends Persona implements Serializable
{
	@Id
	@GeneratedValue 
    private Long id;
	
	/**
	 * Constructor sin par�metros
	 */
	public Creador() {
		super();
	}

	/**
	 * Constructor con par�metros
	 * @param nombre
	 * @param apellido
	 */
	public Creador(String nombre, String apellido) {
		super(nombre, apellido);
	}
}
