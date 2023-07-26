package ism.Gestionappro.dto;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanifierClasseCoursDto {
    private Long idClasse;
    private Long idCours;
    private String libelle;
    private String filiere;
    private String niveau;
    private Date date;
    private String heureDebut;
    private String heureFin;
    private String nbreHeure;



}
