package ism.Gestionappro.repositories;


import ism.Gestionappro.entities.Professeur;
import ism.Gestionappro.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    Professeur findByGrade(String grade);
    AppUser findByUsername(String username);
}
