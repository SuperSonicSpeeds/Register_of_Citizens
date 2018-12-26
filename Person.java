import java.util.Scanner;
import java.time.Period;
import java.time.LocalDate;

public class Person {
    private String name;
    private String fandom;
    private boolean active = false;
    private int arrival;
    private String type;
    private int period;
    
    LocalDate today = LocalDate.now();
    LocalDate start;
    Period p;
    
    public Person(String n, String f, String t) {
        this.name = n;
        
        if(f.equals("MCU")) {
            this.fandom = "the Marvel Cinematic Universe";
        }else if(f.equals("Merlin")) {
            this.fandom = "Merlin";
        }else if(f.equals("TMI")) {
            this.fandom = "The Mortal Instruments";
        }else if(f.equals("SH")) {
            this.fandom = "Shadowhunters";
        }else if(f.equals("PJO")) {
            this.fandom = "Percy Jackson and the Olympians";
        }else if(f.equals("HoO")) {
            this.fandom = "Heroes of Olympus";
        }else if(f.equals("HP")) {
            this.fandom = "Harry Potter";
        }else if(f.equals("THG")) {
            this.fandom = "The Hunger Games";
        }
        
        if(t.equals("Canon")) {
            this.type = "canon";
        }else if(t.equals("MC")) {
            this.type = "minor";
        }else if(t.equals("OC")) {
            this.type = "original";
        }else if(t.equals("CMC")) {
            this.type = "custom minor";
        }
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
        if(this.active == false) {
            return this.name + " is a " + this.type + " character from " + this.fandom + " and is not currently in the world.";
        }else {
            return this.name + " is a " + this.type + " character from " + this.fandom +  " and is currently in the world. Do you want to know more?";
        }
    }
        
    public void setPeriod(int y, int m, int d) {
        start = LocalDate.of(y, m, d);
        p = Period.between(today, start);
    }
    
    public void getPeriod() {
        System.out.println(this.name + " has been in Worlds' End " + p.getYears() + " years, " + p.getMonths() + " months and " + p.getDays() + " days.");
        //if(p.getYears())
    }
    
}
