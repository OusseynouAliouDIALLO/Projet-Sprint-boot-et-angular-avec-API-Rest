package ism.Gestionappro.repositories;

import ism.Gestionappro.entities.Classe;
import ism.Gestionappro.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findByTelephone(String tel);

}
