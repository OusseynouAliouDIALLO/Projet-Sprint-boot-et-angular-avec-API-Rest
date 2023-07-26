package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.PlanifiersessioncoursDto;
import ism.Gestionappro.entities.Planifiersessioncours;
import ism.Gestionappro.repositories.PlanifiersessioncoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanifiersessioncoursServiceImpl implements PlanifiersessioncoursService{
    @Autowired
    private PlanifiersessioncoursRepository planifiersessioncoursRepository;


    @Override
    public List<PlanifiersessioncoursDto> getAllPlanifiersessioncours() {
        return planifiersessioncoursRepository.findAll()
                .stream().map(planifiersessioncours -> new PlanifiersessioncoursDto(planifiersessioncours))
                .collect(Collectors.toList());
    }

    @Override
    public Planifiersessioncours addPlanifiersessioncours(Planifiersessioncours planifiersessioncours) {
        return planifiersessioncoursRepository.save(planifiersessioncours);
    }
}
