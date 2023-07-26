package ism.Gestionappro.api.dto;

import ism.Gestionappro.entities.Classe;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClasseDto {

    private Long id;
    private String filiere;
    private String niveau;
    private String libelle;

    public ClasseDto(Classe classe){
        id= classe.getId();
        filiere= classe.getFiliere();
        niveau= classe.getNiveau();
        libelle= classe.getLibelle();
    }
}
