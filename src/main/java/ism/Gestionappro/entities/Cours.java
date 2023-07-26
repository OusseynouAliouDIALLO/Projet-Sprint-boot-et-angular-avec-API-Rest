package ism.Gestionappro.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cours")
@DiscriminatorValue(value = "Cours")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nbreHeure;
    private String semestre;
    private String libelle;





    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @Override
    public String toString() {
        return libelle;
    }
}
