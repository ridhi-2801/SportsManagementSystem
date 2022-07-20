package com.example.demo.service;

import com.example.demo.Model.MyUserDetails;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUserName(username);
       if(u==null) {
           throw new UsernameNotFoundException("User not found with " + username);
       }

        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(u.getUserName(),u.getPassword(),new ArrayList<>());

        return new MyUserDetails(u);

    }
}