package ism.Gestionappro.controllers;

import ism.Gestionappro.dto.PlanifierClasseCoursDto;
import ism.Gestionappro.entities.Classe;
import ism.Gestionappro.entities.Cours;
import ism.Gestionappro.entities.Planifiersessioncours;
import ism.Gestionappro.repositories.ClasseRepository;
import ism.Gestionappro.repositories.CoursRepository;
import ism.Gestionappro.repositories.PlanifiersessioncoursRepository;
import ism.Gestionappro.services.PlanifiersessioncoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PlanifiersessioncoursController {
    @Autowired
    private PlanifiersessioncoursRepository planifiersessioncoursRepository;
    private PlanifiersessioncoursService service;
    @Autowired
    private ClasseRepository classeRepository;
    @Autowired
    private CoursRepository coursRepository;
    @GetMapping("/rp/liste-coursplanifier")
    public String listerCoursplanifier(Model model,
                                       @RequestParam(name = "keyword", defaultValue = "")String keyword) {
        List<Planifiersessioncours> planifiersessioncoursrcours = planifiersessioncoursRepository.findByNbreHeureContains(keyword) ;
        model.addAttribute("listPlanifiers", planifiersessioncoursrcours);
        model.addAttribute("keyword", keyword);
        return "planifiersessioncours";
    }

    @GetMapping("/rp/annuler-coursplanifier")
    private String annulerCoursplanifier(Long id){
        planifiersessioncoursRepository.deleteById(id);
        return "redirect:/rp/liste-coursplanifier";

    }

    @GetMapping("/rp/etat-planifiersessioncours")
    public String EtatPlanifiersessioncours(Model model,
                                            @RequestParam(name = "etat",defaultValue = "") int etat,
                                            @RequestParam(name = "idPlanifiersessioncours",defaultValue = "") Long idPlanifiersessioncours){
        service.updateEtatPlanifiersessioncours(idPlanifiersessioncours,etat);
        return "redirect:/form-planifiersessioncours";

    }

    @GetMapping("/rp/form-valide-sessioncours")
    public String loadFormValider(Model model,
                                   @RequestParam(name = "id",defaultValue = "") Long idPlanifiersessioncours){
        Optional<Planifiersessioncours> OptPlanifiersessioncours=planifiersessioncoursRepository.findById(idPlanifiersessioncours);
        if(!OptPlanifiersessioncours.isPresent()){
            return "redirect:/rp/liste-coursplanifier";
        }
        model.addAttribute("planifiersessioncours",OptPlanifiersessioncours.get());
        return "form.etat.planifiersessioncours";
    }


    @GetMapping("/rp/form-planifiersessioncours")
    public String loadForPlanifiersessioncours(Model model){
        Planifiersessioncours planifiersessioncours=new Planifiersessioncours();
        model.addAttribute("planifiersessioncours",planifiersessioncours);
        return "form.planifier.session.cours";
    }

    @PostMapping("/rp/save-planifiersessioncours")
    public String savePlanifiersessioncours(Model model,
                                            Planifiersessioncours planifiersessioncours){
        planifiersessioncoursRepository.save(planifiersessioncours);
        return "redirect:/rp/form-planifiersessioncours";
    }

    @PostMapping("/ajout-classe-session")
    public String afficheClasse(Model model,
                                PlanifierClasseCoursDto planifierClasseCours){
        Classe classe=classeRepository.findById(planifierClasseCours.getIdClasse()).get();
        Cours cours=coursRepository.findById(planifierClasseCours.getIdCours()).get();
        planifierClasseCours.setLibelle(classe.getLibelle());
        planifierClasseCours.setLibelle(cours.getLibelle());
        return "redirect:/form-planifier.session.cours";

    }
}
