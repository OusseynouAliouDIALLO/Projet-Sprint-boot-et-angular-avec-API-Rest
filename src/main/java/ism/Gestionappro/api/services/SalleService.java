package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.SalleDto;
import ism.Gestionappro.entities.Salle;

import java.util.List;

public interface SalleService {
    List<SalleDto> getAllSalle();

    Salle addSalle(Salle salle);
}
