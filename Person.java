import java.util.Scanner;

public class Person {
    String name;
    String fandom;
    private boolean active = false;
    private int arrival;


    public Person(String n, String f) {
        this.name = n;
        this.fandom = f;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getFandom() {
        return this.fandom;
    }
}
