package ism.Gestionappro.repositories;

import ism.Gestionappro.entities.Classe;
import ism.Gestionappro.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository <Salle,Long>{
    Salle findByNom(String nom);

}
