package ray.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ray.models.User;
import ray.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * Created by zr on 2016/11/16.
 */
@Service
public class UserService implements UserDetailsService{
    @Bean
    private PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
    @Resource
    private UserRepository userRepository;

    public User findByUsername(String username){
        User user = userRepository.findByUsername(username);
        return  user;
    }
    public void save(User user){
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }
    public User getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || auth instanceof AnonymousAuthenticationToken){
            return null;
        }
        String username = ((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername();
        return userRepository.findByUsername(username);
    }
    public void changePassword(User user,String password, String newPassword){

        if (passwordEncoder().matches(password,user.getPassword())) {
            user.setPassword(passwordEncoder().encode(newPassword));
            userRepository.save(user);
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByEmail(username);
        if (user == null)
            throw new UsernameNotFoundException("User Not Found");

        return createSpringUser(user);
    }
    private org.springframework.security.core.userdetails.User createSpringUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(createAuthority(user)));
    }

    private GrantedAuthority createAuthority(User user) {
        return new SimpleGrantedAuthority(user.getRole());
    }
}
