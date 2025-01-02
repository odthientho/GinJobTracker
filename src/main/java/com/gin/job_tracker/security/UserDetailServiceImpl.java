package com.gin.job_tracker.security;

import com.gin.job_tracker.database.dao.UserDAO;
import com.gin.job_tracker.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByEmailIgnoreCase(username);
        if (user == null) {
            // this is not good practice to printout username
            throw new UsernameNotFoundException("Email not found: " + username);
        }
        log.debug("UserDetailsService loadUserByUsername: " + user.toString());

        // other configuration for spring security
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

//        List<UserRole> userRoles = userRoleDAO.findByUserId(user.getId());
//        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                new ArrayList<>()
                //springRoles
                );
    }

//    public Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (UserRole userRole : userRoles) {
//            authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
//        }
//        return authorities;
//    }
}
