package com.Financial_Management_System.Security;

import com.Financial_Management_System.Entity.UserEntity;
import com.Financial_Management_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            System.out.println("User Not Found at MyUserDetailService - loadUserByUsername");
            throw new UsernameNotFoundException("User Not Found at MyUserDetailService - loadUserByUsername");
        }
        return new UserPrincipal(user.get());
    }
}
