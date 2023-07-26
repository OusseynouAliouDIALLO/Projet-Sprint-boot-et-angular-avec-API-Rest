package ism.Gestionappro.api.controller;

import ism.Gestionappro.api.dto.ProfesseurDto;
import ism.Gestionappro.api.dto.RPDto;
import ism.Gestionappro.api.exceptions.ResourceNotFoundException;
import ism.Gestionappro.api.services.SecurityService;
import ism.Gestionappro.entities.Professeur;
import ism.Gestionappro.entities.RP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/security")
public class SecurityRestController {

    @Autowired
    SecurityService service;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<RPDto> connection(@RequestBody UserConnectDto userConnect){
        RP rp=service.getRPByUsername(userConnect.username);
        if(rp==null) throw new ResourceNotFoundException(
                "Login ou Mot de Passe Incorrect");
        return  new ResponseEntity<>(new RPDto(rp), HttpStatus.OK);
    }



}
class UserConnectDto{
    public String   username;
    public String   password;
}


