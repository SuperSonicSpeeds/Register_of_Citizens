import java.util.Scanner;

public class Person {
    String name;
    String fandom;
    private boolean active = true;
    private int arrival;


    public Person(String n, String f) {
        this.name = n;
        this.fandom = f;
    }
    
    public String getName() {
        return this.name;
    }
}
