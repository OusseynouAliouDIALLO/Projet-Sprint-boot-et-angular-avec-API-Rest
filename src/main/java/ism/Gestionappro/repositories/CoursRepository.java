package ism.Gestionappro.repositories;

import ism.Gestionappro.entities.Classe;
import ism.Gestionappro.entities.Cours;
import ism.Gestionappro.entities.Etudiant;
import ism.Gestionappro.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    List<Cours> findAll();

    List<Cours> findByLibelleContains(String libelle);

    List<Cours> getByProfesseur(Professeur professeur);
}
