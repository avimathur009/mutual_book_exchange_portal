package com.example.helloworld.service;

import com.example.helloworld.model.CustomUserDetails;
import com.example.helloworld.model.User;
import com.example.helloworld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public void delete(User user) { userRepository.delete(user); }
    public void delete(Long id) { userRepository.deleteById(id); }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomUserDetails(user);
    }
}
