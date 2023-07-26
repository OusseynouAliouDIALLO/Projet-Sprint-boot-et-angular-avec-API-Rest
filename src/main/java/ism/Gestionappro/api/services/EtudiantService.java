package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.EtudiantDto;
import ism.Gestionappro.api.dto.SalleDto;
import ism.Gestionappro.entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<EtudiantDto> getAllEtudiant();

    Etudiant addEtudiant(Etudiant etudiant);
}
