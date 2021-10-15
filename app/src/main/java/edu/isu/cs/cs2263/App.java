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

    public static void main(String[] args) throws IOException {
        //https://howtodoinjava.com/gson/gson-gsonbuilder-configuration/

           // studentsArray = IOManager.studentListSample();
            String fileName = "Students.json";
           // IOManager.writeData(studentsArray,fileName);
            studentsArray = IOManager.readData(fileName);
            System.out.println(IOManager.objToJSON(studentsArray));
            launch(args);
    }

    @Override
    public void start(Stage stage) {
        boolean dataHasBeenLoaded = false;
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");



        Label l = new Label("Is Taking");

        Font font = Font.font(" Microsoft PhagsPa Bold", FontWeight.BOLD, FontPosture.REGULAR, 20);
       // System.out.print(Font.getFontNames());
        Font titleF = Font.font(40);
        l.setFont(font);
        l.setTranslateX(220);
        l.setTranslateY(200);
        l.setPadding(new Insets(10,10,10,10));

        //VBox box = new VBox();

        Label sLabel = new Label("Students");
        Label cLabel = new Label("Courses");
        sLabel.setFont(titleF);
        cLabel.setFont(titleF);
        sLabel.setTranslateX(50);
        sLabel.setTranslateY(10);
        cLabel.setTranslateX(350);
        cLabel.setTranslateY(10);


        ListView<String> list = new ListView<String>();

//        ObservableList<String> items = FXCollections.observableArrayList (
//                "Student1","Student2","Student3");
        ObservableList<String> studentNames = FXCollections.observableArrayList();


        Button button = new Button();
        button.setText("Load Data");

        button.setOnAction((event) -> {
        if(studentNames.size()==0){
            for (Student x : studentsArray) {

                studentNames.add(x.getFirstName() + " " + x.getLastName());
            }
            button.setDisable(true);
            }


        });
        button.setTranslateX(550);
        button.setTranslateY(420); //hehe


        ObservableList<String> studentCourses = FXCollections.observableArrayList();
       // https://www.tutorialspoint.com/how-to-create-a-listview-using-javafx Was very helpful here.
        ListView<String> listView = new ListView<String>(studentNames);
        listView.setTranslateY(100);
        listView.setTranslateX(50);
        listView.setMaxSize(150,400);

        ListView<String> coursesListView = new ListView<String>(studentCourses);
        coursesListView.setTranslateX(350);
        coursesListView.setTranslateY(100);
        coursesListView.setMaxSize(150,400);
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
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
                coursesListView.setItems(studentCourses);
               // coursesListView.refresh();

            }
        });


        VBox layout = new VBox(10);
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

