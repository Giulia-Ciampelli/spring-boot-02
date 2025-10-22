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
	public List<Persona> readAll() throws SQLException {
		return persone;
	}
	
	@Override
	public Persona read(Integer id) throws SQLException {

		for (Persona p : persone) {
			
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void update(Persona persona) throws SQLException {
		
		for (Persona p : persone) {
			
			if (p.getId().equals(persona.getId())) {
				p.setNome(persona.getNome());
				p.setCognome(persona.getCognome());
				System.out.println("Persona aggiornata: " + persona);
				return;
			}
		}		
	}

	@Override
	public void delete(Persona persona) throws SQLException {
		persone.removeIf(p -> p.getId().equals(persona.getId()));
		System.out.println("Eliminata persona: " + persona);
	}
}
