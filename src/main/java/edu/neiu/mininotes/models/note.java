package edu.neiu.mininotes.models;


public class note {

    private String title;
    private String body;

     public note(){
        this.title="Untitled";
        this.body = "";
    }
    public note(String title,String body){
         this.title = title;
         this.body = body;
    }
    public String getTitle() {return title;}
    public String getBody()  {return body;}
    public void setBody(String body){this.body =body;}
    public void setTitle(String title){this.title =title;}

}
