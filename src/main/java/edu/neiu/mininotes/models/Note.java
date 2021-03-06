package edu.neiu.mininotes.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return  this.user;
    }



    private String username;

    public void setUsername(String username){
        this.username = username;
    }
    public String setUsername(){
        return this.username;
    }



    @NotBlank(message = "Title required")
    @Size(max=15,message = "Title need to be 15 or less characters")
    private String title;

    @NotBlank(message = "Body required")
    @Size(min=1,message = "Body need to be 1 or more characters")
    @Size(max=250,message = "Cannot exceed 250 characters")
    private String body;


    private LocalDateTime date;
    //TODO: Change this to be a string for user to type in a due date
    // add a class field, for users to input for which class the note is for// maybe allow for sorting this way

    private LocalDateTime created;
    private LocalDateTime modified;

    public Note(){
        this.title="Untitled";
        this.body = "";
        this.date = LocalDateTime.now();

    }
    public Note(String title, String body){
        this.title = title;
        this.body = body;
        this.date = LocalDateTime.now();

    }
    public Note(String username){
        this.title="Untitled";
        this.body = "";
        this.date = LocalDateTime.now();
        this.username = username;
    }

    public long getId() {return this.id;}

    public String getTitle() {return title;}
    public String getBody()  {return body;}
    public LocalDateTime getDate()  {return date;}

    public LocalDateTime getCreated()  {return created;}
    public void setCreated(LocalDateTime date){this.created =date;}

    public LocalDateTime getModified()  {return modified;}
    public void setModified(LocalDateTime date){this.modified = date;}

    @PrePersist
    public void onCreate(){
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate(){
        this.setModified(LocalDateTime.now());
    }


    public void setBody(String body){this.body =body;}
    public void setTitle(String title){this.title =title;}
    public void setDate(LocalDateTime date){this.date =date;}

}