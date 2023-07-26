package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.CoursDto;
import ism.Gestionappro.entities.Cours;
import ism.Gestionappro.entities.Professeur;
import ism.Gestionappro.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursServiceImpl implements CoursService {
    @Autowired
    CoursRepository coursRepository;

    @Override
    public List<CoursDto> getAllCours() {
        return coursRepository.findAll()
                .stream().map(cours -> new CoursDto(cours))
                .collect(Collectors.toList());
    }

    @Override
    public List<CoursDto> getCoursByProfesseur(Long id) {
        Professeur professeur =new Professeur();
        List<Cours> cours=coursRepository.getByProfesseur(professeur);
        return  cours
                .stream()
                .map(cours1 -> new CoursDto(cours1))
                .collect(Collectors.toList());
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public List<Cours> findByLibelle(String libelle) {
        return null;
    }
}
