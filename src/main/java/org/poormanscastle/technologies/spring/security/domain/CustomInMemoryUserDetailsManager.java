package org.poormanscastle.technologies.spring.security.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by georg on 13/04/2017.
 */
public class CustomInMemoryUserDetailsManager implements UserDetailsService {

    private Map<String, MyUser> users = new HashMap<String, MyUser>();

    public CustomInMemoryUserDetailsManager(Collection<MyUser> users){
        for (MyUser user : users){
            this.users.put(user.getUsername().toLowerCase(), user);
        }
    }
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = users.get(username.toLowerCase());
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        MyUser safeguard = new MyUser(user.getUsername(), user.getPassword(), user.getAuthorities(), user.getLastname());
        return safeguard;
    }
    
}
