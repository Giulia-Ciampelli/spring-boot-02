package com.azienda.spring_boot_02.model;

public class Macchina {
	private Integer id;
	private String modello;
	private Integer cilindrata;
	
	public Macchina(Integer id, String modello, Integer cilindrata) {
		this.id = id;
		this.modello = modello;
		this.cilindrata = cilindrata;
	}

	public Integer getId() {
		return id;
	}

	public String getModello() {
		return modello;
	}

	public Integer getCilindrata() {
		return cilindrata;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setModello(String modello) {
		this.modello = modello;
	}

	public void setCilindrata(Integer cilindrata) {
		this.cilindrata = cilindrata;
	}

	@Override
	public String toString() {
		return "Macchina [id=" + id + ", modello=" + modello + ", cilindrata=" + cilindrata + "]";
	}
}
