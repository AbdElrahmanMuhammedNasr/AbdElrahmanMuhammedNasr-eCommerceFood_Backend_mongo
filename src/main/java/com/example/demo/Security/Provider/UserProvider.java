package com.example.demo.Security.Provider;

import com.example.demo.Security.UserDetailsService.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String phone = authentication.getName();
        String password = (String) authentication.getCredentials();

        UserDetails userDetails = myUserDetailsService.loadUserByUsername(phone);
        if (userDetails != null){
            if (passwordEncoder.matches(password , userDetails.getPassword())){

                UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(phone, password);
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
                return  usernamePasswordAuthentication;
            }
        }

        throw new BadCredentialsException("Not Auth");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
