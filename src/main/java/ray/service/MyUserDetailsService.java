package ray.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ray.models.User;
import ray.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zr on 2016/11/16.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return buildUserForAuthentication(user,authorities);
    }

    private org.springframework.security.core.userdetails.User
    buildUserForAuthentication(User user, List<GrantedAuthority> grantedAuthorities){
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,
                true,true,true,grantedAuthorities);
    }
}
