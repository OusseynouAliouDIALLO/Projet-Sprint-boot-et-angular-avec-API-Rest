package ism.Gestionappro.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "planifiersessioncours")
@DiscriminatorValue(value = "Planifiersessioncours")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Planifiersessioncours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String heureDebut;
    private String heureFin;
    private String nbreHeure;

    @Enumerated(value = EnumType.STRING)
    private EtatPlanifiersessioncours etat;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;

    @Override
    public String toString() {
        return "Planifiersessioncours{" +
                "date=" + date +
                ", heureDebut='" + heureDebut + '\'' +
                ", heureFin='" + heureFin + '\'' +
                ", nbreHeure='" + nbreHeure + '\'' +
                ", classe=" + classe +
                ", cours=" + cours +
                '}';
    }

}
