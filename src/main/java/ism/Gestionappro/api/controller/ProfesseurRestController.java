package ism.Gestionappro.api.controller;

import ism.Gestionappro.api.dto.ProfesseurDto;
import ism.Gestionappro.api.services.ProfesseurService;
import ism.Gestionappro.entities.Professeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
//@CrossOrigin("http://localhost:4200")
//Request http/:localhost:8080/api/classes
public class ProfesseurRestController {
    @Autowired
    private ProfesseurService professeurService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<ProfesseurDto>> getAllProfesseurs(){
        List<ProfesseurDto> body=professeurService.getAllProfesseur();
        if (body.isEmpty())
            throw new RuntimeException("Pas de professeur disponible");
        return  new ResponseEntity<>(body, HttpStatus.OK);//200
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Professeur> addProfesseur(@RequestBody Professeur professeur){
        Professeur createdProfesseur=professeurService.addProfesseur(professeur);
        return  new ResponseEntity<>(createdProfesseur, HttpStatus.CREATED);//201
    }
}
