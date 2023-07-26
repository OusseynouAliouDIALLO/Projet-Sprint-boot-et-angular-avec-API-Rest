package ism.Gestionappro.repositories;

import ism.Gestionappro.entities.Inscription;
import ism.Gestionappro.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {


}
