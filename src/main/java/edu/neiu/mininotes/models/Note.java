package edu.neiu.mininotes.models;


import java.time.LocalDateTime;

public class Note {

    private String title;
    private String body;
    private LocalDateTime date;

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
    public void setBody(String body){this.body =body;}
    public void setTitle(String title){this.title =title;}
    public void setDate(LocalDateTime date){this.date =date;}

}
