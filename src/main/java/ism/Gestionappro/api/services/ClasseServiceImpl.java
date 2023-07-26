package ism.Gestionappro.api.services;

import ism.Gestionappro.api.dto.ClasseDto;
import ism.Gestionappro.entities.Classe;
import ism.Gestionappro.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClasseServiceImpl implements ClasseService{
    @Autowired
    private ClasseRepository classeRepository;

    @Override
    public List<ClasseDto> getAllClasse(){
        return classeRepository.findAll()
                .stream().map(classe -> new ClasseDto(classe))
                .collect(Collectors.toList());
    }

    @Override
    public Classe addClasse(Classe classe){
        return classeRepository.save(classe);
    }
}
