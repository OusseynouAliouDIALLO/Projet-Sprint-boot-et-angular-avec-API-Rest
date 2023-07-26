package ism.Gestionappro.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "absences")
@DiscriminatorValue(value = "Absence")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String motif;

    @Enumerated(value = EnumType.STRING)
    private EtatAbsence etat;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @Override
    public String toString() {
        return "Absence{" +
                "date=" + date +
                ", motif='" + motif + '\'' +
                ", etudiant=" + etudiant +
                '}';
    }


}
