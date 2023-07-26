package ism.Gestionappro.api.services;


import ism.Gestionappro.api.dto.SalleDto;
import ism.Gestionappro.entities.Salle;
import ism.Gestionappro.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalleServiceImpl implements SalleService {

    @Autowired
    private SalleRepository salleRepository;

    @Override
    public List<SalleDto> getAllSalle() {
        return salleRepository.findAll()
                .stream().map(salle -> new SalleDto(salle))
                .collect(Collectors.toList());
    }

    @Override
    public Salle addSalle(Salle salle) {
        return salleRepository.save(salle);
    }
}
