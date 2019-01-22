import java.util.Scanner;
import java.time.Period;
import java.time.LocalDate;
import java.util.ArrayList;

public class Person {
    private String name;
    private String fandom;
    private boolean active = false;
    private int arrival;
    private String type;
    private int period;
    private ArrayList<String> Owners = new ArrayList<>();
    
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
    
    public void setStatusA() {
        this.active = true;
    }
    
    public void setStatusI() {
        this.active = false;
    }
    
    public boolean getStatus() {
        return this.active;
    }
    
    public String getInformation() {
        if(this.active == false) {
            return this.name + " is a " + this.type + " character from " + this.fandom + " and is not currently in the world. \nPress '2' to go back.\n";
        }else {
            return this.name + " is a " + this.type + " character from " + this.fandom +  " and is currently in the world. Do you want to know more? \n 1: Yes. \n 2: No. \n";
        }
    }
        
    public void setPeriod(int y, int m, int d) {
        start = LocalDate.of(y, m, d);
        p = Period.between(start, today);
    }
    
    public void getPeriod() {        
        if(p.getYears() == 0 && p.getMonths() == 0 && p.getDays() == 0) {
            System.out.println("This is " + this.name + "'s first day in Worlds' End.");
        }else if(p.getYears() == 0 && p.getMonths() == 0) {
            System.out.println(this.name + " has been in Worlds' End " + p.getDays() + " days.");
        }else if(p.getYears() == 0) {
            System.out.println(this.name + " has been in Worlds' End " + p.getMonths() + " months and " + p.getDays() + " days.");
        }else {
            System.out.println(this.name + " has been in Worlds' End " + p.getYears() + " years, " + p.getMonths() + " months and " + p.getDays() + " days.");
        }
    }
    
    public void setOwners() {
        
    }
    
}
