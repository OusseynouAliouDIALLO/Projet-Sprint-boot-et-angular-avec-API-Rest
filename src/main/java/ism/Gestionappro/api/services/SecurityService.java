package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.ProfesseurDto;
import ism.Gestionappro.api.dto.RPDto;
import ism.Gestionappro.entities.Professeur;
import ism.Gestionappro.entities.RP;

public interface SecurityService {

    Professeur getProfesseurByUsername(String username);
    RP getRPByUsername(String username);

    void addProfesseur(ProfesseurDto professeur);

}
