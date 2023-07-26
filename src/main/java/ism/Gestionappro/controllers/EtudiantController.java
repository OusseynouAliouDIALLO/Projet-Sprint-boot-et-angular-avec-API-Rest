package ism.Gestionappro.controllers;

import ism.Gestionappro.entities.Etudiant;
import ism.Gestionappro.entities.Inscription;
import ism.Gestionappro.repositories.EtudiantRepository;
import ism.Gestionappro.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    InscriptionRepository inscriptionRepository;

    @GetMapping("/rp/liste-etudiant")
    public String listerEtudiant(Model model) {
        List<Etudiant> etudiants= etudiantRepository.findAll();
        model.addAttribute("listEtudiants", etudiants);
        return "etudiant";
    }

    @GetMapping("/rp/form-etudiant")
    public String loadForEtudiant(Model model){
        Etudiant etudiant=new Etudiant();
        model.addAttribute("etudiant",etudiant);
        return "/form.etudiant";
    }

    @PostMapping("/rp/save-etudiant")
    public String saveEtudiant(Etudiant etudiant){
        etudiantRepository.save(etudiant);
        return "redirect:/rp/form-etudiant";
    }
}
