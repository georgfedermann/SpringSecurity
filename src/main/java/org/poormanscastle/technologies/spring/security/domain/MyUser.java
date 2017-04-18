package org.poormanscastle.technologies.spring.security.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Created by georg on 13/04/2017.
 */
public class MyUser extends User {

    private String lastname;

    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String lastname) {
        super(username, password, authorities);
        this.lastname = lastname;
    }

    public MyUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
                  boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String lastname) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }
    
}
