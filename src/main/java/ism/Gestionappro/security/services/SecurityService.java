package ism.Gestionappro.security.services;

import ism.Gestionappro.security.entities.AppRole;
import ism.Gestionappro.security.entities.AppUser;

public interface SecurityService {
    AppUser getUserByUsername(String username);
    AppUser saveUser(String nomComplet,String username,String password);
    AppRole saveRole(String  roleName);
    void addRoleToUser(String username,String  roleName);
    void removeRoleToUser(String username,String  roleName);
}
