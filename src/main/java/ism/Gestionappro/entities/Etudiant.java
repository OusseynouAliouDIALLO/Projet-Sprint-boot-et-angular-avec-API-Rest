package ism.Gestionappro.entities;


import ism.Gestionappro.security.entities.AppUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "etudiants")
@DiscriminatorValue(value = "Etudiant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Etudiant extends AppUser {
    @Column(nullable = false)
    private  String telephone;
    private int nbreAb;

    @OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
    private List<Absence> absences;

    @OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
    private List<Cours> cours;

    @Override
    public String toString() {
        return nomComplet ;
    }
}
