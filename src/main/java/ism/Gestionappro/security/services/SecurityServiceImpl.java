package ism.Gestionappro.security.services;

import ism.Gestionappro.security.entities.AppRole;
import ism.Gestionappro.security.entities.AppUser;
import ism.Gestionappro.security.repositories.AppRoleRepository;
import ism.Gestionappro.security.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SecurityServiceImpl implements SecurityService, UserDetailsService {

    @Autowired
    AppRoleRepository appRoleRepository;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public SecurityServiceImpl(AppRoleRepository appRoleRepository,
                               AppUserRepository appUserRepository,
                               PasswordEncoder passwordEncoder) {
        this.appRoleRepository = appRoleRepository;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public AppUser getUserByUsername(String username)
    {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public AppUser saveUser(String nomComplet, String username, String password) {
        AppUser user=appUserRepository.findByUsername(username);
        if(user!=null) throw  new RuntimeException("Cet utilisateur existe deja ");
        user=new AppUser();
        user.setNomComplet(nomComplet);
        user.setPassword(passwordEncoder.encode(password));
        user.setUsername(username);
        return appUserRepository.save(user);

    }

    @Override
    public AppRole saveRole(String roleName) {
        AppRole role=new AppRole(null,roleName,null);
        return appRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user=appUserRepository.findByUsername(username);
        if(user==null) throw  new RuntimeException("Cet utilisateur n'existe pas ");
        AppRole role =appRoleRepository.findByRoleName(roleName);
        if(role==null) throw  new RuntimeException("Ce Role n'existe pas ");
        user.getRoles().add(role);
        appUserRepository.save(user);

    }

    @Override
    public void removeRoleToUser(String username, String roleName) {
        AppUser user=appUserRepository.findByUsername(username);
        if(user==null) throw  new RuntimeException("Cet utilisateur n'existe pas ");
        AppRole role =appRoleRepository.findByRoleName(roleName);
        if(role==null) throw  new RuntimeException("Ce Role n'existe pas ");
        user.getRoles().remove(role);
        appUserRepository.save(user);

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=getUserByUsername(username);
        return new User(
                appUser.getUsername(),
                appUser.getPassword(),
                appUser.getRoles()
                        .stream()
                        .map(role->new SimpleGrantedAuthority(role.getRoleName()))
                        .collect(Collectors.toList())
                );
        }

}
