package ism.Gestionappro.controllers;

import ism.Gestionappro.entities.Classe;
import ism.Gestionappro.repositories.ClasseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClasseController {
    @Autowired
    private ClasseRepository classeRepository;

    @GetMapping("/rp/liste-classe")
    public String listerClasse(Model model,
                               @RequestParam(name = "keyword", defaultValue = "") String keyword){

        List<Classe> classes=classeRepository.findByLibelleContains(keyword);
        model.addAttribute("listClasses",classes);
        model.addAttribute("keyword",keyword);
        return "classe";
    }

    @GetMapping("/accueil")
    public String accueilPage(){
        return "accueil";
    }

    @GetMapping("/rp/form-classe")
    public String loadForClient(Model model){
        Classe classe=new Classe();
        model.addAttribute("classe",classe);
        return "/form.classe";
    }

    @PostMapping("/rp/save-classe")
    public String saveClasse(@Valid Classe classe,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("mode", "error");
            redirectAttributes.addFlashAttribute("message", "Erreur de Saisie");
        } else {
            redirectAttributes.addFlashAttribute("mode", "succes");
            redirectAttributes.addFlashAttribute("message", "Classe Enregistrée avec Succès");
            classeRepository.save(classe);

        }
        return "redirect:/rp/form-classe";
    }



}
