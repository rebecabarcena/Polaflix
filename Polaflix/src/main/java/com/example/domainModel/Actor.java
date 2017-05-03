package com.example.domainModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Clase que implementa un actor
 */
@Entity
public class Actor extends Persona implements Serializable
{
	@Id 
    @GeneratedValue 
    private Long id;
	
	/**
	 * Constructor vac�o
	 */
	public Actor() {
		super();
	}

	/**
	 * Constructor con par�metros
	 * @param nombre
	 * @param apellido
	 */
	public Actor(String nombre, String apellido) {
		super(nombre, apellido);
	}	
}
