package ism.Gestionappro.api.dto;

import ism.Gestionappro.entities.Professeur;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProfesseurDto {
    private Long id;
    private String nomComplet;
    private String specialite;
    private String grade;
    private String username;
    private String password;

    private List<String > roles;
    public ProfesseurDto (Professeur professeur){
        id= professeur.getId();
        nomComplet= professeur.getNomComplet();
        specialite= professeur.getSpecialite();
        grade= professeur.getGrade();
        username= professeur.getUsername();
        password= professeur.getPassword();
        roles=professeur.getRoles()
                .stream()
                .map(role->role.getRoleName())
                .collect(Collectors.toList());
    }
}
