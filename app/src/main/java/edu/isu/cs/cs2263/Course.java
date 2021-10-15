//Course.java

package edu.isu.cs.cs2263;


/** Course Class. holds all Course data and methods
 *
 * @author Alex Diviney
 * @version 2.0.0
 */
public class Course {

    private int number;
    private String subject;
    private String title;

    public Course(){
        number = 0;
        subject = "FOO";
        title = "BAR";
    }

    /**
     *
     * @param num Course Number
     * @param subj Subject
     * @param tt Full Title of Course
     */
    public Course(int num, String subj, String tt){
        number = num;
        subject = subj;
        title = tt;

    }

    //getters

    /**
     *
     * @return Course Number
     */
    int getNumber(){
        return number;
    }

    /**
     *
     * @return Subject Name
     */
    String getSubject(){
        return subject;
    }

    /**
     *
     * @return Title of subject
     */
    String getTitle(){return title;}

    //setters

    /**
     *
     * @param num Course Number
     */
    public void setNumber(int num){
        number = num;
    }
    /**
     *
     * @param subj Subject Name
     */
    public void setSubject(String subj){
        subject = subj;
    }

    /**
     *
     * @param tt Title Name
     */
    public void setTitle(String tt){
        title = tt;
    }



}
