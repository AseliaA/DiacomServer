package com.diacom.diacom.SecurityService;

import com.diacom.diacom.entity.User;
import com.diacom.diacom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(userLogin)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found with username: " + userLogin));
        return UserDetailsImpl.build(user);
    }
}
