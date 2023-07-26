package ism.Gestionappro.api.controller;

import ism.Gestionappro.api.dto.SalleDto;
import ism.Gestionappro.api.services.SalleService;
import ism.Gestionappro.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
//@CrossOrigin("http://localhost:4200")
//Request http/:localhost:8080/api/classes
public class SalleRestController {
    @Autowired
    private SalleService salleService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<SalleDto>> getAllSalles(){
        List<SalleDto> body=salleService.getAllSalle();
        if (body.isEmpty())
            throw new RuntimeException("Pas de salle disponible");
        return  new ResponseEntity<>(body, HttpStatus.OK);//200
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Salle> addSalle(@RequestBody Salle salle){
        Salle createdSalle=salleService.addSalle(salle);
        return  new ResponseEntity<>(createdSalle, HttpStatus.CREATED);//201
    }
}
