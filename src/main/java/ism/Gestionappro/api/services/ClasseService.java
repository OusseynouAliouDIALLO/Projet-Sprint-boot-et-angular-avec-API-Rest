package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.ClasseDto;
import ism.Gestionappro.entities.Classe;

import java.util.List;

public interface ClasseService {
    List<ClasseDto> getAllClasse();

    Classe addClasse(Classe classe);
}
