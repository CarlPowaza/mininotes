package edu.neiu.mininotes.security;

import edu.neiu.mininotes.data.UserRepository;
import edu.neiu.mininotes.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserDataLoader implements CommandLineRunner {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDataLoader(UserRepository userRepo,PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;

    }


    @Override
    public void run(String... args) throws Exception {

        /*
        User user = new User("foo@foo.com","foo", passwordEncoder.encode("password"),"fooer","fooish" );
        user.setRoles(Set.of(User.Role.ROLE_ADMIN));
        user.setEnabled(true);
        userRepo.save(user);

        User user1 = new User("foo1@foo.com","foo1", passwordEncoder.encode("password"),"dude","fooish" );
        user1.setRoles(Set.of(User.Role.ROLE_USER));
        user1.setEnabled(true);
        userRepo.save(user1);

         */


    }
}
