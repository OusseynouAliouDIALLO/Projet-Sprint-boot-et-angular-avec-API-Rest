package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.PlanifiersessioncoursDto;
import ism.Gestionappro.entities.Planifiersessioncours;

import java.util.List;

public interface PlanifiersessioncoursService {
    List<PlanifiersessioncoursDto> getAllPlanifiersessioncours();

    Planifiersessioncours addPlanifiersessioncours(Planifiersessioncours planifiersessioncours);
}
