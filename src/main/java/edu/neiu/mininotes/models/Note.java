package edu.neiu.mininotes.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String title;
    private String body;
    private LocalDateTime date;

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
