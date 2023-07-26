package ism.Gestionappro.repositories;

import ism.Gestionappro.entities.Classe;
import ism.Gestionappro.entities.Etudiant;
import ism.Gestionappro.entities.Planifiersessioncours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PlanifiersessioncoursRepository extends JpaRepository<Planifiersessioncours,Long> {

    List<Planifiersessioncours> findByNbreHeureContains(String nbreHeure);
    List<Planifiersessioncours> findByDateContains(Date date);
   /* Planifiersessioncours findByDate(String date);*/
}
