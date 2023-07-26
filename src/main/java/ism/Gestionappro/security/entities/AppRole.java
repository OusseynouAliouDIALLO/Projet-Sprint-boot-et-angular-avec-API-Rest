package ism.Gestionappro.security.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(nullable = false,unique = true)
    protected String roleName;
    @ManyToMany(mappedBy = "roles")
    List<AppUser> users;

    public AppRole(String roleName) {
        this.roleName = roleName;
    }
}
