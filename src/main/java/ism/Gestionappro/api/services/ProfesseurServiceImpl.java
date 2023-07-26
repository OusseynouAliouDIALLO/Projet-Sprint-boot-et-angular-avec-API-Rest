package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.ProfesseurDto;
import ism.Gestionappro.entities.Professeur;
import ism.Gestionappro.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {
    @Autowired
    private ProfesseurRepository professeurRepository;

    @Override
    public List<ProfesseurDto> getAllProfesseur() {
        return professeurRepository.findAll()
                .stream().map(professeur -> new ProfesseurDto(professeur))
                .collect(Collectors.toList());
    }

    @Override
    public Professeur addProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }
}
