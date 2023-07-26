package ism.Gestionappro.api.dto;

import ism.Gestionappro.entities.Planifiersessioncours;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PlanifiersessioncoursDto {
    private Long id;
    private Date date;
    private String heureDebut;
    private String heureFin;
    private String nbreHeure;
    private String cours;
    private String classe;
    private String etat;

    public PlanifiersessioncoursDto (Planifiersessioncours planifiersessioncours){
        id= planifiersessioncours.getId();
        heureDebut= planifiersessioncours.getHeureDebut();
        heureFin= planifiersessioncours.getHeureFin();
        nbreHeure= planifiersessioncours.getNbreHeure();
        date= planifiersessioncours.getDate();
        etat= planifiersessioncours.getEtat().toString();
        cours= planifiersessioncours.getCours().getLibelle();
        classe= planifiersessioncours.getClasse().getLibelle();
    }
}
