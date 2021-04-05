package com.example.demo.Security.UserDetailsService;

import com.example.demo.Repository.AllUser.UserRepo;
import com.example.demo.entity.AllUser.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        System.out.println("----------------------User d ser----------------");

        User user = userRepo.findByPhone(phone);
        if (user != null) {
            return new MyUserDetails(user);
        } else {
            throw new BadCredentialsException("phone or password incorrect");
        }
    }
}
