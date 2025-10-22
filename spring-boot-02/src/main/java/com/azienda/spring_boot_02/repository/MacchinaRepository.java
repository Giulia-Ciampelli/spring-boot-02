package com.azienda.spring_boot_02.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.azienda.spring_boot_02.model.Macchina;

@Component
public class MacchinaRepository implements MacchinaRepositoryInterface<Macchina> {
	private List<Macchina> macchine = new ArrayList<Macchina>();
	
	@Override
	public void create(Macchina macchina) throws SQLException {
		macchine.add(macchina);
		System.out.println("Aggiunta macchina: " + macchina);
	}

	@Override
	public List<Macchina> read() throws SQLException {
		return macchine;
	}

	@Override
	public void update(Macchina macchina) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Macchina macchina) throws SQLException {
		macchine.removeIf(m -> m.getId().equals(macchina.getId()));
		System.out.println("Eliminata macchina: " + macchina);
	}
}
