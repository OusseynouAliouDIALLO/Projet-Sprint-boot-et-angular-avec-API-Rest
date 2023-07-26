package ism.Gestionappro.repositories;

import ism.Gestionappro.entities.Classe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe,Long> {

    List<Classe> findByLibelleContains(String libelle);

    List<Classe> findAll();
    /*Classe findByLibelle(String libelle);*/



   /* Page<Classe> findByLibelleContains(String libelle, Pageable pageable);*/



}
