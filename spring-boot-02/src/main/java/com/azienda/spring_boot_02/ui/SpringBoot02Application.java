package com.azienda.spring_boot_02.ui;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.azienda.spring_boot_02.model.Macchina;
import com.azienda.spring_boot_02.model.Persona;
import com.azienda.spring_boot_02.service.Service;

@SpringBootApplication(scanBasePackages = {"com.azienda.spring_boot_02"})
public class SpringBoot02Application {

	public static void main(String[] args) {

		try (ConfigurableApplicationContext context = SpringApplication.run(SpringBoot02Application.class, args); Scanner scan = new Scanner(System.in)) {
			Service servizio = context.getBean("service", Service.class);
			//			Persona p = new Persona(1, "Mario", "Bianchi");
			//			Macchina m = new Macchina(1, "Fiat Panda", 1200);
			//			servizio.createP(p);
			//			servizio.createM(m);
			boolean running = true;

			while (running) {
				System.out.println("Benvenuto nella gestione macchine e persone. \nMenu:");
				System.out.println("1) Mostra tutte le macchine");
				System.out.println("2) Mostra tutte le persone");
				System.out.println("3) Mostra tutte le macchine e le persone");
				System.out.println("4) Aggiungi una macchina");
				System.out.println("5) Aggiungi una persona");
				System.out.println("6) Aggiorna una macchina");
				System.out.println("7) Aggiorna una persona");
				System.out.println("8) Cancella una macchina");
				System.out.println("9) Cancella una persona");
				System.out.println("0) Esci");
				int scelta = scan.nextInt();
				scan.nextLine();

				switch (scelta) {
				case 1: {
					servizio.findAllM();
					break;
				}
				case 2: {
					servizio.findAllP();
					break;
				}
				case 3: {
					servizio.findAll();
					break;
				}
				case 4: {
					System.out.println("Id macchina:");
					int id = scan.nextInt();
					scan.nextLine();
					System.out.println("Modello macchina:");
					String modello = scan.nextLine();
					System.out.println("Cilindrata macchina:");
					int cilindrata = scan.nextInt();
					scan.nextLine();
					Macchina m = new Macchina(id, modello, cilindrata);
					servizio.createM(m);
					break;
				}
				case 5: {
					System.out.println("Id persona:");
					int id = scan.nextInt();
					scan.nextLine();
					System.out.println("Nome persona:");
					String nome = scan.nextLine();
					System.out.println("Cognome persona:");
					String cognome = scan.nextLine();
					Persona p = new Persona(id, nome, cognome);
					servizio.createP(p);
					break;
				}
				case 6: {
					System.out.println("Id macchina da aggiornare:");
					int id = scan.nextInt();
					scan.nextLine();
					Macchina mAgg = servizio.findByIdM(id);
					System.out.println("Nuovo modello macchina:");
					String modello = scan.nextLine();
					System.out.println("Nuova cilindrata macchina:");
					int cilindrata = scan.nextInt();
					scan.nextLine();
					mAgg.setModello(modello);
					mAgg.setCilindrata(cilindrata);
					servizio.updateM(mAgg);
					break;
				}
				case 7: {
					System.out.println("Id persona da aggiornare:");
					int id = scan.nextInt();
					scan.nextLine();
					Persona pAgg = servizio.findByIdP(id);
					System.out.println("Nuovo nome persona:");
					String nome = scan.nextLine();
					System.out.println("Nuovo cognome persona:");
					String cognome = scan.nextLine();
					pAgg.setNome(nome);
					pAgg.setCognome(cognome);
					servizio.updateP(pAgg);
					break;
				}
				case 8: {
					System.out.println("Id macchina da cancellare:");
					int id = scan.nextInt();
					scan.nextLine();
					Macchina mCanc = servizio.findByIdM(id);
					servizio.deleteM(mCanc);
				}
				case 9: {
					System.out.println("Id persona da cancellare:");
					int id = scan.nextInt();
					scan.nextLine();
					Persona pCanc = servizio.findByIdP(id);
					servizio.deleteP(pCanc);
				}
				case 0: {
					running = false;
					System.out.println("Programma terminato");
				}
				default:
					System.err.println("Inserire un valore numerico compreso fra 0 e 9");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
