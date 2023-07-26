package ism.Gestionappro.controllers;

import ism.Gestionappro.entities.Absence;
import ism.Gestionappro.entities.Classe;
import ism.Gestionappro.entities.Cours;
import ism.Gestionappro.repositories.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AbsenceController {
    @Autowired
    AbsenceRepository  absenceRepository;

    @GetMapping("/rp/liste-absence")
    public String listerAbsence(Model model){
        List<Absence> absences=absenceRepository.findAll();
        model.addAttribute("listAbsence",absences);
        return "absence";
    }

    @GetMapping("/rp/form-absence")
    public String loadForAbsence(Model model){
        Absence absence=new Absence();
        model.addAttribute("absence",absence);
        return "/form.absence";
    }

    @PostMapping("/rp/save-absence")
    public String saveAbsence(Absence absence){
        absenceRepository.save(absence);
        return "redirect:/rp/form-absence";
    }
}
