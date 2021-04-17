package com.diacom.diacom.SecurityService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    UserDetails loadUserByUserLogin(String userLogin)
            throws UsernameNotFoundException;

}
