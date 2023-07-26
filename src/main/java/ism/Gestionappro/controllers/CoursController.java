package ism.Gestionappro.controllers;

import ism.Gestionappro.entities.Cours;
import ism.Gestionappro.entities.Professeur;
import ism.Gestionappro.entities.Salle;
import ism.Gestionappro.repositories.CoursRepository;
import ism.Gestionappro.repositories.EtudiantRepository;
import ism.Gestionappro.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class CoursController {

    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ProfesseurRepository professeurRepository;

    @GetMapping("/rp/liste-cours")
    public String listerCours(Model model,
                              @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<Cours> cours= coursRepository.findByLibelleContains(keyword);
        model.addAttribute("listCours", cours);
        model.addAttribute("keyword",keyword);
        return "cours";
    }

    @GetMapping("/etudiant/liste-cours-etudiant")
    public String listerCoursEtudiant(Model model,
                              @RequestParam(name = "id", defaultValue = "")Long idEtudiant){
        List<Cours> coursList=etudiantRepository.findById(idEtudiant).get().getCours();
        model.addAttribute("listCours",coursList);
        return "coursetudiant";
    }

    @GetMapping("/professeur/liste-cours-professeur")
    public String listerCoursProf(Model model,
                              @RequestParam(name = "id", defaultValue = "")Long idProfesseur){
        List<Cours> coursList=professeurRepository.findById(idProfesseur).get().getCours();
        model.addAttribute("listCoursPorf",coursList);
        return "coursprof";
    }


    @GetMapping("/rp/form-cours")
    public String loadForCours(Model model){
        Cours cours=new Cours();
        model.addAttribute("cours",cours);
        return "/form.cours";
    }

    @PostMapping("/rp/save-cours")
    public String saveCours(Cours cours){
        coursRepository.save(cours);
        return "redirect:/rp/form-cours";
    }
}
