package ism.Gestionappro.controllers;

import ism.Gestionappro.entities.Professeur;
import ism.Gestionappro.entities.Salle;
import ism.Gestionappro.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SalleController {
    @Autowired
    private SalleRepository salleRepository;

    @GetMapping("/rp/liste-salle")
    public String listerClasse(Model model) {
        List<Salle> salles = salleRepository.findAll();
        model.addAttribute("listSalles", salles);
        return "salle";
    }

    @GetMapping("/rp/form-salle")
    public String loadForSalle(Model model){
        Salle salle=new Salle();
        model.addAttribute("salle",salle);
        return "/form.salle";
    }

    @PostMapping("/rp/save-salle")
    public String saveSalle(Salle salle){
        salleRepository.save(salle);
        return "redirect:/rp/form-salle";
    }
}
