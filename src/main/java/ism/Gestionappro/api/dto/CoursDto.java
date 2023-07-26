package ism.Gestionappro.api.dto;

import ism.Gestionappro.entities.Classe;
import ism.Gestionappro.entities.Cours;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CoursDto {
    private Long id;
    private String libelle;
    private String nbreHeure;
    private String semestre;
    private String classe;

    public CoursDto (Cours cours){
        id= cours.getId();
        libelle= cours.getLibelle();
        nbreHeure= cours.getNbreHeure();
        semestre= cours.getSemestre();

    }
}
