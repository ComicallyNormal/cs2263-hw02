package edu.isu.cs.cs2263;

public class Course {

    private int number;
    private String subject;
    private String title;

    public Course(){
        number = 0;
        subject = "FOO";
        title = "BAR";
    }

    public Course(int num, String subj, String tt){
        number = num;
        subject = subj;
        title = tt;

    }

    //getters
    int getNumber(){
        return number;
    }
    String getSubject(){
        return subject;
    }
    String getTitle(){return title;}

    //setters
    public void setNumber(int num){
        number = num;
    }
    public void setSubject(String subj){
        subject = subj;
    }
    public void setTitle(String tt){
        title = tt;
    }



}
