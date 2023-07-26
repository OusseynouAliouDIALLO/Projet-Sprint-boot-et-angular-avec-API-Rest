package ism.Gestionappro.api.dto;

import ism.Gestionappro.entities.Classe;
import ism.Gestionappro.entities.Salle;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SalleDto {
    private Long id;
    private String nom;
    private String numero;
    private String nbrePlace;
    private String classe;

    public SalleDto(Salle salle){
        id= salle.getId();
        nom= salle.getNom();
        numero= salle.getNumero();
        nbrePlace= salle.getNbrePlace();
        classe= salle.getClasse().getLibelle();
    }

}
