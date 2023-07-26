package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.ProfesseurDto;
import ism.Gestionappro.api.dto.RPDto;
import ism.Gestionappro.entities.Professeur;
import ism.Gestionappro.entities.RP;
import ism.Gestionappro.repositories.ProfesseurRepository;
import ism.Gestionappro.repositories.RpRepositury;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceRestImpl implements SecurityService {

    @Autowired
    RpRepositury rpRepositury;
    @Autowired
    ProfesseurRepository professeurRepository;
    @Override
    public Professeur getProfesseurByUsername(String username) {
        Professeur professeur=(Professeur) professeurRepository.findByUsername(username);
            return professeur;
    }

    @Override
    public RP getRPByUsername (String username) {
        RP rp = (RP) rpRepositury.findByUsername(username);
            return rp;
    }


    @Override
    public void addProfesseur(ProfesseurDto professeur) {

    }

}
