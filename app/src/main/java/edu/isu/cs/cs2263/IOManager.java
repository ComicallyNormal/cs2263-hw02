//IOManager.java
package edu.isu.cs.cs2263;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;


/** IOManager Class. Allows the app to store data and read data from files
 *
 * @author Alex Diviney
 * @version 2.0.0
 */
public class IOManager {

    public IOManager() {
    }

    //https://howtodoinjava.com/gson/gson-gsonbuilder-configuration/
    /**
    testing method that turns an an arraylist into a string json
     * @param list ArrayList
     * @return Returns JSON String representation.
     */
    public static String objToJSON(ArrayList<Student> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String listToGSON = gson.toJson(list);

        return listToGSON;
    }

    /**
     *
     * @return Returns a test Data set of students.
     */
    public static ArrayList<Student> studentListSample() {
        ArrayList<Course> genericCourseList = new ArrayList<>();
        ArrayList<Student> genericStudentList = new ArrayList<>();
        ArrayList<Course> artStudentList = new ArrayList<>();
        ArrayList<Course> eeStudentList = new ArrayList<>();

        Course calc2 = new Course(1175,"Math", "Calc 2");
        Course techWriting = new Course(3307,"English", "Technical Writing");
        Course preCalc = new Course(1170, "Math","Pre-Calc");
        Course artHistory = new Course(1105, "Art","Art History");
        Course acdc = new Course(2229, "Electrical Engineering", "AC/DC Currents");
        genericCourseList.add(calc2);
        genericCourseList.add(techWriting);
        artStudentList.add(preCalc);
        artStudentList.add(artHistory);
        eeStudentList.add(calc2);
        eeStudentList.add(acdc);

        Student student1 = new Student("Alex", "Diviney",genericCourseList);
        Student student2 = new Student("Baylor", "McElroy",eeStudentList);
        Student student3 = new Student("Lexus", "Texas",artStudentList);
        Student student4 = new Student();
        genericStudentList.add(student1);
        genericStudentList.add(student2);
        genericStudentList.add(student3);
        genericStudentList.add(student4);

        return genericStudentList;
    }

    /**
     *
     * @param studentList Needs a List of Students
     * @param fileName Needs the file name of the json file to write to
     */
    public static void writeData(ArrayList<Student>studentList,String fileName){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            FileWriter fileWriter = new FileWriter(fileName);


            // String jsonStr = IOManager.objToJSON(studentsArray);
            // System.out.print(jsonStr);
            gson.toJson(studentList, fileWriter);
            fileWriter.close();
        } catch (IOException | JsonIOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param fileName file name of file to read from.
     * @return Returns an ArrayList of Students.
     * @throws IOException
     */
    public static ArrayList<Student> readData(String fileName)throws IOException{
        try {
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            //Can someone get fired for my having to write this line of code? Class cast exceptions smh
            //https://stackoverflow.com/questions/27253555/com-google-gson-internal-linkedtreemap-cannot-be-cast-to-my-class
           TypeToken<ArrayList<Student>> typeToken = new TypeToken<ArrayList<Student>>(){};
           ArrayList<Student> studentArr = gson.fromJson(reader,typeToken.getType());
           reader.close();
            return studentArr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FILE NOT FOUND");
        }
        return null;
    }

}