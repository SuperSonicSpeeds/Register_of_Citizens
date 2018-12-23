import java.util.Scanner;

public class Person {
    private String name;
    private String fandom;
    private boolean active = false;
    private int arrival;
    private String type;


    public Person(String n, String f, String t) {
        this.name = n;
        this.fandom = f;
        this.type = t;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getFandom() {
        return this.fandom;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setStatus() {
        this.active = true;
    }
    
    public boolean getStatus() {
        return this.active;
    }
    
    public String getInformation() {
        return this.name + " is a " + this.type + " character from " + this.fandom + ".";
    }
    
}
