package com.azienda.spring_boot_02.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.azienda.spring_boot_02.model.Persona;

@Component
public class PersonaRepository implements PersonaRepositoryInterface<Persona> {
	private List<Persona> persone = new ArrayList<Persona>();

	@Override
	public void create(Persona persona) throws SQLException {
		persone.add(persona);
		System.out.println("Aggiunta persona: " + persona);
	}

	@Override
	public List<Persona> read() throws SQLException {
		return persone;
	}

	@Override
	public void update(Persona persona) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Persona persona) throws SQLException {
		persone.removeIf(p -> p.getId().equals(persona.getId()));
		System.out.println("Eliminata persona: " + persona);
	}
}
