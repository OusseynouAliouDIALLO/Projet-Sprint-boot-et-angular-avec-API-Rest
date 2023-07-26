package ism.Gestionappro.services;

import ism.Gestionappro.entities.EtatPlanifiersessioncours;
import ism.Gestionappro.entities.Planifiersessioncours;
import ism.Gestionappro.repositories.PlanifiersessioncoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ism.Gestionappro.entities.EtatPlanifiersessioncours.Terminer;

@Service
public class PlanifiersessioncoursService {

    @Autowired
    PlanifiersessioncoursRepository planifiersessioncoursRepository;

    public void updateEtatPlanifiersessioncours(Long idPlanifiersessioncours,int etat){
        Optional<Planifiersessioncours> OptPlanifiersessioncours=planifiersessioncoursRepository.findById(idPlanifiersessioncours);
        if(OptPlanifiersessioncours.isPresent()){
            Planifiersessioncours psc= OptPlanifiersessioncours.get();
            psc.setEtat(EtatPlanifiersessioncours.toEnum(etat));
            planifiersessioncoursRepository.save(psc);
        }
    }
}
