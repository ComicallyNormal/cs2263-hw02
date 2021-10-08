package edu.isu.cs.cs2263;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App extends Application {

    static ArrayList<Student> studentsArray;

    public static void main(String[] args) {
       // Gson gson = new Gson();
        studentsArray = new ArrayList<Student>();
        Student studentTest = new Student();
        studentsArray.add(studentTest);
       String jsonStr =  IOManager.objToJSON(studentsArray);
       System.out.print(jsonStr);

        launch(args);


    }

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}

