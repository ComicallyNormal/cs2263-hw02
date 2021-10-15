package edu.isu.cs.cs2263;



import java.util.ArrayList;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;

    private ArrayList<Course> courseList;

    Student(){
        firstName = "FOO";
        lastName = "BAR";
        courseList = new ArrayList<Course>();
    }
    Student(String first, String last, ArrayList<Course> courses){
        firstName = first;
        lastName = last;
        courseList = courses;

    }

    //getters
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public ArrayList getList(){
        return courseList;
    }


    //setters
    public void setFirstName(String first){
        firstName = first;
    }
    public void setLastName(String last){
        lastName = last;
    }
    public void addCourse(Course ct){
        courseList.add(ct);
    }

//toString
   public String toString(){
        String retString = firstName + " " + lastName;
        return retString;
   }

   public ArrayList<Course> getCourseList(){
        return courseList;
   }


}
