package com.azienda.spring_boot_02.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azienda.spring_boot_02.model.Macchina;
import com.azienda.spring_boot_02.model.Persona;
import com.azienda.spring_boot_02.repository.MacchinaRepository;
import com.azienda.spring_boot_02.repository.PersonaRepository;
import com.azienda.spring_boot_02.utils.Transaction;

@Component
public class Service {
	
	@Autowired
	private MacchinaRepository macchinaRepo;
	
	@Autowired
	private PersonaRepository personaRepo;
	
	@Autowired
	private Transaction transaction;

	public Service(MacchinaRepository macchinaRepo, PersonaRepository personaRepo) {
		this.macchinaRepo = macchinaRepo;
		this.personaRepo = personaRepo;
	}
	
	// show
	public void findAllM() throws Exception {
		
		try {
			List<Macchina> macchine = macchinaRepo.read();
			System.out.println("Lista macchine:");
			macchine.forEach(System.out::println);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}
	
	public void findAllP() throws Exception {
		
		try {
			List<Persona> persone = personaRepo.read();
			System.out.println("Lista persone:");
			persone.forEach(System.out::println);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}
	
	public void findAll() throws Exception {
		
		try {
			List<Macchina> macchine = macchinaRepo.read();
			List<Persona> persone = personaRepo.read();
			System.out.println("Lista macchine:");
			macchine.forEach(System.out::println);
			System.out.println("Lista persone:");
			persone.forEach(System.out::println);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}
	
	// create
	public void createM(Macchina macchina) throws Exception {
		
		try {
			macchinaRepo.create(macchina);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}
	
	public void createP(Persona persona) throws Exception {
		
		try {
			personaRepo.create(persona);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}
	
	// update
	
	// delete
	public void deleteM(Macchina macchina) throws SQLException {
		
		try {
			macchinaRepo.delete(macchina);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}
	
	public void deleteP(Persona persona) throws SQLException {
		
		try {
			personaRepo.delete(persona);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}
}
