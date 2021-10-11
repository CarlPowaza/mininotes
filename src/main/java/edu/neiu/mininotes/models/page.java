package edu.neiu.mininotes.models;


import java.util.ArrayList;

//TODO : FINISH THIS CLASS
public class page {

    private String pageName;
    private ArrayList<note> notes;

    public page(){
        this.pageName = "Untitled";
        this.notes = new ArrayList<note>();//random number for now,Will pick the right amount after I see how notes end up looking
        this.notes.add(new note());
    }
    public page(String pageName,note note){
        this.pageName = pageName;
        this.notes = new ArrayList<note>();
        this.notes.add(new note());
    }
    public String getPageName(){return this.pageName;}
    public ArrayList<note> getNotes(){return this.notes;}
    public void setPageName(String pageName){this.pageName=pageName;}
    public void setNotes(ArrayList<note> notes){this.notes=notes;}

    public void addNote(String title,String body){
        this.notes.add(new note(title,body));

    }
    public void addNote(note note){
        this.notes.add(note);

    }



}
