package ism.Gestionappro.security.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
@DiscriminatorValue(value = "RP")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column (nullable = false)
    protected  String nomComplet;

    @Column(nullable = false,unique = true)
    protected String username;
    @Column(nullable = false)
    protected String password;

    public AppUser(Long id) {
        this.id = id;
    }

    public AppUser(Long id, String nomComplet) {
        this.id = id;
        this.nomComplet = nomComplet;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    List<AppRole> roles=new ArrayList<>();
}
