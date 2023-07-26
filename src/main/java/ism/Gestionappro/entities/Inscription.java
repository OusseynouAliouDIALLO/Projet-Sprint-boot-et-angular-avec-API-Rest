package ism.Gestionappro.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "inscriptions")
@DiscriminatorValue(value = "Inscription")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
}
