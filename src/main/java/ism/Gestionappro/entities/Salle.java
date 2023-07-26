package ism.Gestionappro.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "salles")
@DiscriminatorValue(value = "Salle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String numero;
    private String nbrePlace;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @Override
    public String toString() {
        return "Salle{" +
                "nom='" + nom + '\'' +
                ", numero='" + numero + '\'' +
                ", nbrePlace='" + nbrePlace + '\'' +
                ", classe=" + classe +
                '}';
    }
}
