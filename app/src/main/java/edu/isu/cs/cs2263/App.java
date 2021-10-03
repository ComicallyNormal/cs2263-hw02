/**
 * App.java
 * This class doesn't do much at the moment.
 * @Author Alex Diviney
 * @Version v1.0.0
 */

package edu.isu.cs.cs2263;
import com.google.gson.Gson;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
      HelloFX.main(args);

      Gson gson = new Gson();

    }
}
