package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.CoursDto;
import ism.Gestionappro.api.dto.EtudiantDto;
import ism.Gestionappro.entities.Cours;

import java.util.List;

public interface CoursService {

    List<CoursDto> getAllCours();

    List<CoursDto> getCoursByProfesseur(Long id);

    Cours addCours(Cours cours);

    List<Cours> findByLibelle(String libelle);
}
