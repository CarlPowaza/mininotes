package edu.neiu.mininotes.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(unique = true,nullable=false)
    private String email;

    @Column(unique=true,nullable = false)
    private String username;

    @Column(nullable=false)
    private String password;

    private String firstname;
    private String lastname;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Note> notes = new HashSet<>();

    public void setNotes(Set<Note> notes){
        this.notes = notes;
    }
    public Set<Note> getNotes(){
        return this.notes;
    }







    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    @ElementCollection(targetClass = Role.class, fetch=FetchType.EAGER)
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Collection<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role role:roles){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.toString());
            authorities.add(grantedAuthority);
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return  this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return  this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return  this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public enum Role{ROLE_ADMIN, ROLE_USER}


    public User(){}

    public User(String email,String username,String password,String firstname,String lastname){
        this.email = email;
        this.username=username;
        this.password=password;
        this.firstname=firstname;
        this.lastname=lastname;
        this.accountNonLocked=true;
        this.accountNonExpired = true;
        this.credentialsNonExpired = true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    @Override
    public boolean equals(Object o){

        if(!(o instanceof User)) return false;

        User u = (User) o;
        return this.username.equals(u.username) && this.email.equals(u.email);
    }




}
