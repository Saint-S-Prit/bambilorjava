package sn.saint.bambilorjava.service.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sn.saint.bambilorjava.model.Appuser;
import sn.saint.bambilorjava.service.ApplicationService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ApplicationService applicationService;

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Appuser appuser = applicationService.findByUsername(username);
        if (appuser !=null){
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            System.out.println("*********************************************");
            System.out.println(appuser.getUsername()+" "+appuser.getPassword()+" "+authorities);
            System.out.println("*********************************************");
            return new User(appuser.getUsername(),appuser.getPassword(),authorities);
        }
        else {
            throw new UsernameNotFoundException(username);
        }
    }
}
