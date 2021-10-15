//App.java

/**
 * Copyright 2021 Alex Diviney
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


/**
 * Main app class for the program
 *
 * @author Alex Diviney
 * @version 2.1.0
 */
package edu.isu.cs.cs2263;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.io.*;
import com.google.gson.*;
public class App extends Application {

    static ArrayList<Student> studentsArray;


    /**
     * Main method which runs the program
     */
    public static void main(String[] args) throws IOException {


           // studentsArray = IOManager.studentListSample();
            String fileName = "Students.json";
           // IOManager.writeData(studentsArray,fileName);
            studentsArray = IOManager.readData(fileName);
            System.out.println(IOManager.objToJSON(studentsArray));
            launch(args);
    }

    @Override
    /**
     *Initializes App GUI
     * @param stage. Passes in a stage to be used to show the GUI.
     */
    public void start(Stage stage) {

        //Label in between our two lists.
        Label l = new Label("Is Taking");
        Font font = Font.font(" Microsoft PhagsPa Bold", FontWeight.BOLD, FontPosture.REGULAR, 20);
       // System.out.print(Font.getFontNames());
        Font titleF = Font.font(40);
        l.setFont(font);
        l.setTranslateX(220);
        l.setTranslateY(200);
        l.setPadding(new Insets(10,10,10,10));

        //labels to mark Students and courses.
        Label sLabel = new Label("Students");
        Label cLabel = new Label("Courses");
        sLabel.setFont(titleF);
        cLabel.setFont(titleF);
        sLabel.setTranslateX(50);
        sLabel.setTranslateY(10);
        cLabel.setTranslateX(350);
        cLabel.setTranslateY(10);

        ObservableList<String> studentNames = FXCollections.observableArrayList(); //Student Names. Contains Data and Logic.

       //Load data button
        Button button = new Button();
        button.setText("Load Data");

        button.setOnAction((event) -> {
            //populates Student Names List. (left)
        if(studentNames.size()==0){
            for (Student x : studentsArray) {
                studentNames.add(x.toString());
            }
            button.setDisable(true);
            }
        });
        button.setTranslateX(550);
        button.setTranslateY(420); //hehe


       // https://www.tutorialspoint.com/how-to-create-a-listview-using-javafx Was very helpful here.
        //https://docs.oracle.com/javafx/2/ui_controls/list-view.htm so was this

        ListView<String> listView = new ListView<String>(studentNames); //Wrapped Student Names. GUI Portion of Student Names list.
        listView.setTranslateY(100);
        listView.setTranslateX(50);
        listView.setMaxSize(150,400);


        ObservableList<String> studentCourses = FXCollections.observableArrayList(); //Student Courses. This contains the data and logic.
        ListView<String> coursesListView = new ListView<String>(studentCourses); //Wrapped Student Courses. This is the GUI Portion of the Student Course List
        coursesListView.setTranslateX(350);
        coursesListView.setTranslateY(100);
        coursesListView.setMaxSize(150,400);

        //Student List to Course List Action.
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            /**
            Handles a Student List Click. Essentially grabs the list item that the user clicked on and grabs its corresponding course data.
            Then it populates the Course List. Refreshes on every click.
             */
            public void handle(MouseEvent event) {
                //makes sure studentCourses is empty
                 studentCourses.clear();
                int currentPos = listView.getSelectionModel().getSelectedIndex(); //Gets current selected student (as a number)
                //Associates the selected list column with a real student, returns their course list.
                ArrayList<Course> currentStudentCourse = new ArrayList<>();
                //makes sure index is in bounds.
                if (currentPos>=0 && currentPos<studentsArray.size()) {
                    currentStudentCourse = studentsArray.get(currentPos).getCourseList();
                }
                //We add the selected students courses to a list so that we can populate a listView
                for (Course x: currentStudentCourse){
                   studentCourses.add(x.getTitle());
                }

                System.out.println(studentCourses.toString());
                coursesListView.setItems(studentCourses); //populate Student course list GUI
               // coursesListView.refresh();
            }
        });

        VBox layout = new VBox(10); //box inside a box inside another box inside a SMASH IT WITH A HAMMER KRONK (11pm).
        layout.setPadding(new Insets(100, 500, 5, 5));
        //organizes our vbox so that it is under our group
        Group root = new Group(layout);
        //listviews are children of the group.
        root.getChildren().addAll(l,cLabel,sLabel,listView,coursesListView,button);

        //Setting the stage
        Scene scene = new Scene(root, 640, 480, Color.ALICEBLUE);
        stage.setTitle("CS2263 HW2 Assignment Alex Diviney");
        stage.setScene(scene);
        stage.show();
    }
}

