package com.school.api.configs;

import com.school.api.users.model.User;
import com.school.api.users.repo.UsersRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SystemUserDetails implements UserDetailsService {
    private UsersRepo userRepo;

    public SystemUserDetails(UsersRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);
        if (user==null)
            throw new UsernameNotFoundException("Ooops No User");
        return new UserDetailsImpl(user);
    }
}
