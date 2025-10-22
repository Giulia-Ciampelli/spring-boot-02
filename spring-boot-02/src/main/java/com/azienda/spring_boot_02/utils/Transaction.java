package com.azienda.spring_boot_02.utils;

import org.springframework.stereotype.Component;

@Component
public class Transaction {
	
	public void commit() {
		System.out.println("Transazione riuscita, commit");
	}
	
	public void rollback() {
		System.out.println("Transazione fallita, rollback");
	}
}
