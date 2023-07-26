package ism.Gestionappro.api.dto;


import ism.Gestionappro.entities.RP;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RPDto {

    private Long id;
    private String nomComplet;
    private String username;
    private String password;



    public RPDto(RP rp){
        id= rp.getId();
        nomComplet= rp.getNomComplet();
        username= rp.getUsername();
        password= rp.getPassword();

    }
}
