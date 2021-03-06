package edu.neiu.mininotes.security;


import edu.neiu.mininotes.data.UserRepository;
import edu.neiu.mininotes.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepo;

    @Autowired
    public UsersDetailsServiceImpl(UserRepository userRepo){
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("Username "+username+ " not found");
        return user;

    }
}
