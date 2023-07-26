package ism.Gestionappro.api.controller;

import ism.Gestionappro.api.dto.PlanifiersessioncoursDto;
import ism.Gestionappro.api.services.PlanifiersessioncoursService;
import ism.Gestionappro.entities.Planifiersessioncours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planifiersessioncours")
public class PlanifiersessioncoursRestController {

    @Autowired
    private PlanifiersessioncoursService planifiersessioncoursService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<PlanifiersessioncoursDto>> getAllPlanifiersessioncours(){
        List<PlanifiersessioncoursDto> body=planifiersessioncoursService.getAllPlanifiersessioncours();
        if (body.isEmpty())
            throw new RuntimeException("Pas de cours planifier disponible");
        return  new ResponseEntity<>(body, HttpStatus.OK);//200
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Planifiersessioncours> addPlanifiersessioncours(@RequestBody Planifiersessioncours planifiersessioncours){
        Planifiersessioncours createdPlanifiersessioncours=planifiersessioncoursService.addPlanifiersessioncours(planifiersessioncours);
        return  new ResponseEntity<>(createdPlanifiersessioncours, HttpStatus.CREATED);
    }
}
