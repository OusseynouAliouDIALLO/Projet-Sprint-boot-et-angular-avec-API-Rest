package ism.Gestionappro.api.controller;

import ism.Gestionappro.api.dto.CoursDto;
import ism.Gestionappro.api.services.CoursService;
import ism.Gestionappro.entities.Cours;
import ism.Gestionappro.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
//@CrossOrigin("http://localhost:4200")
//Request http/:localhost:8080/api/classes
public class CoursRestController {

    @Autowired
    private CoursService coursService;

    @Autowired
    private ProfesseurRepository professeurRepository;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<CoursDto>> getAllCours(){
        List<CoursDto> body=coursService.getAllCours();
        if (body.isEmpty())
            throw new RuntimeException("Pas de cours disponible");
        return  new ResponseEntity<>(body, HttpStatus.OK);//200
    }

    @GetMapping("/professeur/liste-cours-professeur")
    public String listerCoursProf(
            Model model,
            @RequestParam(name = "id", defaultValue = "")Long idProfesseur){
        List<Cours> coursList=professeurRepository.findById(idProfesseur).get().getCours();
        model.addAttribute("listCoursPorf",coursList);
        return "coursprof";
    }

    @PostMapping("/professeur/{id}")
    @ResponseBody
    public ResponseEntity<List<CoursDto>> getCoursByProfesseur(@PathVariable("id") Long id){
        List<CoursDto> cours = coursService.getCoursByProfesseur(id);
        return new ResponseEntity<>(cours, HttpStatus.OK);//201
    }


    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Cours> addCours(@RequestBody Cours cours){
        Cours createdCours=coursService.addCours(cours);
        return  new ResponseEntity<>(createdCours, HttpStatus.CREATED);//201
    }
}
