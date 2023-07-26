package ism.Gestionappro.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "classes")
@DiscriminatorValue(value = "Classe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Le libelle est obligatoire")
    @Column(nullable = false,unique = true)
    private String libelle;

    @NotEmpty(message = "La filière est obligatoire")
    @Column(nullable = false)
    private String filiere;

    @NotEmpty(message = "Le niveau est obligatoire")
    @Column(nullable = false)
    private String niveau;

    @OneToMany(mappedBy = "classe",fetch = FetchType.EAGER)
    private List<Salle> salles;

    @Override
    public String toString() {
        return  libelle ;
    }
}
