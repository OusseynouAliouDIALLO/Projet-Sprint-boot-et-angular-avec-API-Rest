package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.EtudiantDto;
import ism.Gestionappro.entities.Etudiant;
import ism.Gestionappro.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantServiceImpl implements EtudiantService{

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public List<EtudiantDto> getAllEtudiant() {
        return etudiantRepository.findAll()
                .stream().map(etudiant -> new EtudiantDto(etudiant))
                .collect(Collectors.toList());
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
}
