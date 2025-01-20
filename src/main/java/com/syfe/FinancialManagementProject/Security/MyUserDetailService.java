package com.syfe.FinancialManagementProject.Security;

import com.syfe.FinancialManagementProject.Entity.UserEntity;
import com.syfe.FinancialManagementProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).get();
        if(user==null){
            System.out.println("User Not Found at MyUserDetailService - loadUserByUsername");
            throw new UsernameNotFoundException("User Not Found at MyUserDetailService - loadUserByUsername");
        }
        return new UserPrincipal(user);
    }
}
