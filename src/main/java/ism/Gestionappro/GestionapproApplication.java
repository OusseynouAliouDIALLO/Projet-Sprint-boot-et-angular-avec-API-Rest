package ism.Gestionappro;

import ism.Gestionappro.entities.*;
import ism.Gestionappro.repositories.*;
import ism.Gestionappro.security.entities.AppRole;
import ism.Gestionappro.security.entities.AppUser;
import ism.Gestionappro.security.services.SecurityService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GestionapproApplication implements CommandLineRunner {

	@Autowired
	private ClasseRepository classeRepository;

	@Autowired
	private SalleRepository salleRepository;

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private ProfesseurRepository professeurRepository;

	@Autowired
	private PlanifiersessioncoursRepository planifiersessioncoursRepository;

	@Autowired
	private CoursRepository coursRepository;

	@Autowired
	SecurityService service;

	@DateTimeFormat(pattern = "dd/mm/yyyy")


	public static void main(String[] args) {
		SpringApplication.run(GestionapproApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

		return new CorsFilter(urlBasedCorsConfigurationSource);
	}


	@Override
	public void run(String... args) throws Exception {

		/*for (int i = 1; i < 5; i++) {
			Classe cl=new Classe();
			cl.setFiliere("GLRS-"+i);
			cl.setNiveau("L"+i);
			cl.setLibelle(cl.getNiveau() + cl.getFiliere());

			classeRepository.save(cl);

		}

		for (int i = 1; i < 5; i++) {
			Salle salle=new Salle();
			salle.setNom("salle"+i);
			salle.setNumero("Num00"+i);
			salle.setNbrePlace("2"+i);

			salleRepository.save(salle);

		}

		for (int i = 1; i < 5; i++) {
			Etudiant etu=new Etudiant();
			etu.setTelephone("77579244"+i);
			etu.setNomComplet("etudiant"+i);

			etudiantRepository.save(etu);

		}

		for (int i = 1; i < 5; i++) {
			Professeur prof=new Professeur();
			prof.setSpecialite("Developpeur"+i);
			prof.setGrade("Professeur");
			prof.setNomComplet("Mr Diallo"+i);

			professeurRepository.save(prof);

		}

		for (int i = 1; i < 5; i++) {
			Planifiersessioncours planifier=new Planifiersessioncours();
			planifier.setHeureDebut("8 H");
			planifier.setHeureFin("12 H");
			planifier.setNbreHeure("30 H");
			planifier.setEtat(EtatCours.Terminer);


			planifiersessioncoursRepository.save(planifier);

		}

		for (int i = 1; i < 5; i++) {
			Cours co=new Cours();
			co.setNbreHeure("2"+i+"H");
			co.setSemestre("semestre"+i);
			co.setLibelle("L"+i +"GLRS"+i);
			coursRepository.save(co);

		}*/

		/*System.out.println("liste classe");
		classeRepository.findAll().forEach(System.out::println);
		System.out.println("liste classe");
		Classe classe=classeRepository.findByLibelle("L 1GLRS -1");
		System.out.println(classe);*/
	}

	/*@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			AppRole role1 = service.saveRole("RP");
			AppRole role2 = service.saveRole("AC");
			AppRole role3 = service.saveRole("Etudiant");
			AppRole role4 = service.saveRole("Professeur");
			AppUser rp= service.saveUser("Ousseynou Diallo", "ousin", "passer");
			service.addRoleToUser("ousin", "RP");
			service.addRoleToUser("ousin", "AC");
			service.addRoleToUser("ousin", "Etudiant");
			service.addRoleToUser("ousin", "Professeur");

			for (int i = 1; i < 3; i++) {
				Etudiant etu=new Etudiant();
				etu.setTelephone("77579244"+i);
				etu.setNomComplet("etudiant"+i);

				etu.setUsername("etudiant"+i);
				etu.setPassword(passwordEncoder().encode("passer"));
				etu.getRoles().add(role3);
				etudiantRepository.save(etu);

			}
			for (int i = 1; i < 3; i++) {
				Professeur prof=new Professeur();
				prof.setSpecialite("Developpeur"+i);
				prof.setGrade("Professeur");
				prof.setNomComplet("Mr Diallo"+i);

				prof.setUsername("professeur"+i);
				prof.setPassword(passwordEncoder().encode("passer"));
				prof.getRoles().add(role4);

				professeurRepository.save(prof);

			}
			for (int i = 1; i < 3; i++) {
				Classe cl=new Classe();
				cl.setFiliere("GLRS"+i);
				cl.setNiveau("L"+i);
				cl.setLibelle(cl.getNiveau() + cl.getFiliere());

				classeRepository.save(cl);

			}

			for (int i = 1; i < 3; i++) {
				Salle salle=new Salle();
				salle.setNom("salle"+i);
				salle.setNumero("Num00"+i);
				salle.setNbrePlace("2"+i);

				salleRepository.save(salle);

			}

			for (int i = 1; i < 3; i++) {
				Planifiersessioncours planifier = new Planifiersessioncours();
				planifier.setHeureDebut("8 H");
				planifier.setHeureFin("12 H");
				planifier.setNbreHeure("30 H");
				planifier.setEtat(EtatPlanifiersessioncours.Terminer);


				planifiersessioncoursRepository.save(planifier);
			}
			for (int i = 1; i < 3; i++) {
				Cours co = new Cours();
				co.setNbreHeure("2" + i + "H");
				co.setSemestre("semestre" + i);
				co.setLibelle("PHP" + i);
				coursRepository.save(co);
			}


		};
	}*/
}

