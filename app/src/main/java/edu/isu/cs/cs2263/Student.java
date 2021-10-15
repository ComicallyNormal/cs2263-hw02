//Student.java

package edu.isu.cs.cs2263;


import java.util.ArrayList;
import java.util.List;

 /** Student Class. holds all student data and methods
        *
        * @author Alex Diviney
        * @version 2.0.0
        */
public class Student {

    private String firstName;
    private String lastName;

    private ArrayList<Course> courseList;

    Student(){
        firstName = "FOO";
        lastName = "BAR";
        courseList = new ArrayList<Course>();
    }

     /**
      *
      * @param first First Name of Student
      * @param last Last Name of Student
      * @param courses ArrayList of Courses student is taking
      */
    Student(String first, String last, ArrayList<Course> courses){
        firstName = first;
        lastName = last;
        courseList = courses;

    }

    //getters

     /**
      *
      * @return first Name
      */
    public String getFirstName(){
        return firstName;
    }

     /**
      *
      * @return last name
      */
    public String getLastName(){
        return lastName;
    }

     /**
      *
      * @return Courses as ArrayList
      */
    public ArrayList<Course> getCourseList(){return courseList;}

    //setters

     /**
      *
      * @param first First name
      */
    public void setFirstName(String first){
        firstName = first;
    }

     /**
      *
      * @param last last name
      */
    public void setLastName(String last){
        lastName = last;
    }

     /**
      *
      * @param ct Course to add
      */
    public void addCourse(Course ct){
        courseList.add(ct);
    }

//toString

     /**
      *
      * @return Returns String representation of a student (first and last names)
      */
   public String toString(){
        String retString = firstName + " " + lastName;
        return retString;
   }


}
