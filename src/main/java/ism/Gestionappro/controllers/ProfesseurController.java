package ism.Gestionappro.controllers;

import ism.Gestionappro.entities.Professeur;
import ism.Gestionappro.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfesseurController {

    @Autowired
    private ProfesseurRepository professeurRepository;

    @GetMapping("/rp/liste-professeur")
    public String listerProfesseur(Model model) {
        List<Professeur> professeurs= professeurRepository.findAll();
        model.addAttribute("listProfesseurs", professeurs);
        return "professeur";
    }

    @GetMapping("/rp/form-professeur")
    public String loadForProfesseur(Model model){
        Professeur professeur=new Professeur();
        model.addAttribute("professeur",professeur);
        return "/form.professeur";
    }

    @PostMapping("/rp/save-professeur")
    public String saveProfesseur(Professeur professeur){
        professeurRepository.save(professeur);
        return "redirect:/rp/form-professeur";
    }
}
