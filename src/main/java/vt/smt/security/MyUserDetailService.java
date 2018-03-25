package vt.smt.security;

/**
 * Created by semitro on 24.03.18.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vt.smt.db.repositories.UsersRepository;
import vt.smt.ent.net.Users;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    private UsersRepository userRepository;

    @Autowired
    public void setUserRepository(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        Users user = userRepository.findByLogin(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        System.out.println(user);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (String role : user.getRole().split(" ")) {
            // Если хочется много ролей, перечисляй через пробел
            authorityList.add(new SimpleGrantedAuthority(role));
        }
        // Здесь мы кладём GameCharacter в сессию JSF

//        user.getAllUserRoles().forEach(role -> authorityList.add(new SimpleGrantedAuthority(role.getName())));
        return new User(user.getLogin(),user.getPassword(),authorityList);
    }
}