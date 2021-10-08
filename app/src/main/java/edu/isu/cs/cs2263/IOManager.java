package edu.isu.cs.cs2263;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class IOManager {

    public IOManager(){}

    public void writeData(String file, ArrayList<Student> list){


    }
    public static String objToJSON(ArrayList<Student> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String listToGSON = gson.toJson(list);

        return listToGSON;
    }

}
