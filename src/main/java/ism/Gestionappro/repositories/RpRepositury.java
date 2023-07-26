package ism.Gestionappro.repositories;

import ism.Gestionappro.entities.Professeur;
import ism.Gestionappro.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RpRepositury extends JpaRepository<Professeur,Long> {
    AppUser findByUsername(String username);
}
