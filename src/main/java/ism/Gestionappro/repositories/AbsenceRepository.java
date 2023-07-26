package ism.Gestionappro.repositories;

import ism.Gestionappro.entities.Absence;
import ism.Gestionappro.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence,Long> {
    List<Absence> findByDateContains(String date);
    List<Absence> findAll();
}
