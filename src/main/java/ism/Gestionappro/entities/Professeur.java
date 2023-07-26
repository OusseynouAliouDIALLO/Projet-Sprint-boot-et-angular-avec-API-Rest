package ism.Gestionappro.entities;


import ism.Gestionappro.security.entities.AppUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "professeurs")
@DiscriminatorValue(value = "Professeur")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Professeur extends AppUser {
    @Column(nullable = false)
    private String specialite;
    @Column(nullable = false)
    private String grade;

    @OneToMany(mappedBy = "professeur", fetch = FetchType.LAZY)
    private List<Cours> cours;

    @Override
    public String toString() {
        return  nomComplet + " - " +   specialite +" - " + grade;
    }
}
