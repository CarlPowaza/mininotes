package edu.neiu.mininotes.security;


import edu.neiu.mininotes.models.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm {


    @NotEmpty(message ="Username cannot be empty")
    @NotNull(message ="Username cannot be empty")
    @Size(min=3,message="Must be at least 3 characters")
    private String username;


    @NotEmpty(message ="password cannot be empty")
    @NotNull(message ="password cannot be empty")
    @Size(min=5,message="Must be at least 5 characters")
    private String password;


    @NotEmpty(message ="Email cannot be empty")
    @NotNull(message ="Email cannot be empty")
    @Size(min=5,message="Must be at least 5 characters")
    private String email;

    @NotEmpty(message ="First Name cannot be empty")
    @NotNull(message ="First Name cannot be empty")
    @Size(min=3,message="Must be at least 3 characters")
    private String firstName;

    @NotEmpty(message ="Last Name cannot be empty")
    @NotNull(message ="Last Name cannot be empty")
    @Size(min=3,message="Must be at least 3 characters")
    private String lastName;


    public User toUser(PasswordEncoder passEnc){
        User newUser = new User();
        newUser.setPassword(passEnc.encode(this.password));
        newUser.setUsername(this.username);
        newUser.setEmail(this.email);
        newUser.setFirstname(firstName);
        newUser.setLastname(lastName);
        newUser.setAccountNonExpired(true);
        newUser.setAccountNonLocked(true);
        newUser.setCredentialsNonExpired(true);
        newUser.setEnabled(true);


        return newUser;
    }


}
