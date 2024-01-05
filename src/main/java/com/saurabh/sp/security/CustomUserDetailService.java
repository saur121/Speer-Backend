package com.saurabh.sp.security;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.*;

import com.saurabh.sp.repo.UserRepository;
import com.saurabh.sp.model.*;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        UserDtls user = userRepository.findByEmailId(emailId);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + emailId);
        }

        return UserPrincipal.builder()
                .userId(user.getId())
                .email(user.getEmailId())
                .password(user.getPassword())  
                .authorities(List.of(new SimpleGrantedAuthority(user.getRole())))
                .build();
    }
}  
