package ism.Gestionappro.controllers;

import ism.Gestionappro.security.entities.AppUser;
import ism.Gestionappro.security.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @Autowired
    SecurityService service;
    @GetMapping("/")
    public String index(@AuthenticationPrincipal UserDetails userDetails){
        String path="redirect:/login";
        if(userDetails.getAuthorities()
                .stream()
                .filter(role->role.getAuthority().compareTo("RP")==0)
                .findFirst()
                .isPresent()){
            return "redirect:/accueil";
        }

        if(userDetails.getAuthorities()
                .stream()
                .filter(role->role.getAuthority().compareTo("Etudiant")==0)
                .findFirst()
                .isPresent()){
            AppUser user= service.getUserByUsername(userDetails.getUsername());
            return "redirect:/etudiant/liste-cours-etudiant?id="+user.getId();
        }

        if(userDetails.getAuthorities()
                .stream()
                .filter(role->role.getAuthority().compareTo("Professeur")==0)
                .findFirst()
                .isPresent()){
            AppUser user= service.getUserByUsername(userDetails.getUsername());
            return "redirect:/professeur/liste-cours-professeur?id="+user.getId();
        }

        return path;
    }
    @GetMapping("/403")
    public String error403(){
        return "errors/403";
    }
    @GetMapping("/404")
    public String error404(){
        return "errors/403";
    }
}
