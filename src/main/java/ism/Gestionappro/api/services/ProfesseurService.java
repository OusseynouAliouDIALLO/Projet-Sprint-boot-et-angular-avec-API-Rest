package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.ProfesseurDto;
import ism.Gestionappro.api.dto.SalleDto;
import ism.Gestionappro.entities.Professeur;

import java.util.List;

public interface ProfesseurService {
    List<ProfesseurDto> getAllProfesseur();

    Professeur addProfesseur(Professeur professeur);
}
