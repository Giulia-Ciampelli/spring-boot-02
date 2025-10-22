package com.azienda.spring_boot_02.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.azienda.spring_boot_02.model.Macchina;
import com.azienda.spring_boot_02.model.Persona;
import com.azienda.spring_boot_02.service.Service;

@SpringBootApplication(scanBasePackages = {"com.azienda.spring_boot_02"})
public class SpringBoot02Application {

	public static void main(String[] args) {
		
		try (ConfigurableApplicationContext context = SpringApplication.run(SpringBoot02Application.class, args)) {
			Service servizio = context.getBean("service", Service.class);
			Persona p = new Persona(1, "Mario", "Bianchi");
			Macchina m = new Macchina(1, "Fiat Panda", 1200);
			servizio.createP(p);
			servizio.createM(m);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
