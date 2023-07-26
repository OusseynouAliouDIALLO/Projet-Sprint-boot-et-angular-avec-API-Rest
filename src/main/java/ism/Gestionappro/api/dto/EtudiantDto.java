package ism.Gestionappro.api.dto;

import ism.Gestionappro.entities.Etudiant;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EtudiantDto {
    private Long id;
    private String nomComplet;
    private int nbreAb;
    private String telephone;

    private String username;
    private String password;

    public EtudiantDto (Etudiant etudiant){
        id= etudiant.getId();
        nomComplet= etudiant.getNomComplet();
        nbreAb= etudiant.getNbreAb();
        telephone= etudiant.getTelephone();
        username= etudiant.getUsername();
        password= etudiant.getPassword();
    }
}
