import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Archive {
    private ArrayList<Person> archive;
    private ArrayList<Person> active;
    private ArrayList<Person> inactive;
    private ArrayList<Person> reservations;
    private int size;
    private int inhabitants;
    
    public Archive() {
        archive = new ArrayList<>();
        active = new ArrayList<>();
        inactive = new ArrayList<>();
        reservations = new ArrayList<>();
    }
    public void createArchive(String filename) throws Exception {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        String line = sc.nextLine();
        while(sc.hasNextLine()) {
            String info[] = line.split(" - ");
            Person P = new Person(info[0], info[1], info[2]);
            if(info[3].equalsIgnoreCase("active")) {
                P.setStatusA();
                active.add(P);

                int y = Integer.parseInt(info[4].split(",")[0]);
                int m = Integer.parseInt(info[4].split(",")[1]);
                int d = Integer.parseInt(info[4].split(",")[2]);
                P.setPeriod(y, m, d);
            }else {
                P.setStatusI();
                inactive.add(P);
            }
            archive.add(P);
            line = sc.nextLine();
        }
        this.size = archive.size();  
        this.inhabitants = active.size();      
    }    
    
    public void owners(String filename) throws Exception {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        String line = sc.nextLine();
    } 
    
    public void reservation(String filename) throws Exception {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        String line = sc.nextLine();        
        while(sc.hasNextLine()) {
            String info[] = line.split(" - ");
            Person P = new Person(info[0], info[1], info[2], 1);
            reservations.add(P);
            line = sc.nextLine();
        }
    }
    
    public void menu() {
        Scanner sc = new Scanner(System.in);
        String choice = "0";
        
        while(!(choice.equals("4"))) {
            System.out.println("\n \n \nWhat is it you wish to know?");
            System.out.println(" 1. How many people are there in the world?");
            System.out.println(" 2. Who are they?");
            System.out.println(" 3. What do you know about specific people?");
            System.out.println(" 4. My curiosity has been sated.\n \n \n");
            
            choice = sc.nextLine();
            if(choice.equals("1")) {
                System.out.println("\nThere are " + this.inhabitants + " inhabitants currently in Worlds' End.");
                sleep(2000);
            }else if(choice.equals("2")) {
                System.out.println("\nThey are:");
                for(Person p: active) {
                    System.out.println(p.getName());
                }
                sleep(2000);
            }else if(choice.equals("3")) {
                System.out.println("Tell me the full name of who you wish to know more about.\n");
                search(sc.nextLine());   
            }else if(choice.equals("4")) {
                System.out.println("Until next time, questioner.");
                sleep(1000);
            }else if(choice.equalsIgnoreCase("What is the meaning of life?") || choice.equalsIgnoreCase("What's the meaning of life?")) {
                System.out.println("The answer to the Great Question of Life, the Universe, and Everything is... forty-two.");
                sleep(1000);
            }else {
                sassy();
                sleep(1000);
            }
        }       
    }
    
    public void menu1() {
        Scanner sc = new Scanner(System.in);
        String choice = "0";
        
        while(!(choice.equals("4"))) {
            System.out.println("\n \n \nHi! I am your guide to reservations. An underling of the true Mage Book.");
            System.out.println(" 1. Can you tell me if my favourite character has been reserved?");
            System.out.println(" 2. I want to know everyone who has been reserved!");
            System.out.println(" 3. What are my reservations?");
            System.out.println(" 4. Thank you, most wise ancient artifact underling. That'll be all.\n \n \n");

            choice = sc.nextLine();
            if(choice.equals("1")) {
                System.out.println("\nFull name please!\n");
                find(sc.nextLine());
            }else if(choice.equals("2")) {
                allReservations();
            }else if(choice.equals("3")) {
                System.out.println("Alright! What's your name?");
                personReservation(sc.nextLine());
            }else if(choice.equals("4")) {
                System.out.println("Thank you for asking me! No, wait. Ahem. Until next time, friend! Did I do that right? Oh, you're already gone...");
            }else {
                System.out.println("\nAsk sensibly or... begone(?). I'm a busy a-ancient artifact underling!");
            }
        }
        
        
    }
    
    public void sassy() {
        System.out.println("\nAsk sensibly or begone, I'm a busy ancient artifact.");
    }
    
    public void search(String s) {
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        ArrayList<Person> matches = new ArrayList<Person>();
        for(Person p: archive) {
            if(s.equalsIgnoreCase(p.getName())) {
                found = true;
                matches.add(p);
            }
        }
        if(found == false) {
            System.out.println(s + " has never been in Worlds' End.");
        } else {
            System.out.println("\n" + s + " is registered. Would you like more information? \n 1: Yes. \n 2: No. \n");
            String choice = sc.nextLine();
            while(!(choice.equals("2"))) {
                Scanner scan = new Scanner(System.in);
                if(choice.equals("1")) {
                    System.out.println("\n" + matches.get(0).getInformation());
                    String more = scan.nextLine();
                    if(more.equals("1")) {
                        matches.get(0).getPeriod();
                    }
                    break;
                } else if(choice.equals("2")) {
                    System.out.println("Very well.");
                } else {
                    sassy();
                    break;
                }
            }
        }
    }
    
    public void find(String s) {
        boolean match = false;
        for(Person p: reservations) {
            if(s.equalsIgnoreCase(p.getName())) {
                match = true;
                System.out.println("I found it! Are you ready? \n"); 
                sleep(1000);
                System.out.println("."); 
                sleep(500);
                System.out.println(". ."); 
                sleep(500);
                System.out.println(". . .\n"); 
                sleep(1000);
                System.out.println(p.name + " from " + p.fandom + " is already reserved by " + p.human + ". Sorry...");
                sleep(2000);
                break;
            }
        }
        if(!match) {
            System.out.println("\n" + s + " hasn't been reserved yet. This is your chance, hurry!");
        }        
    }
    
    public static void sleep(int t) {
        try {
            Thread.sleep(t);            
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void allReservations() {
        for(Person P: reservations) {
            System.out.println(P.name + " from " + P.fandom + " is reserved by " + P.human + ".");
        }
        
    }
    
    public void personReservation(String name) {
        boolean found = false;
        for(Person P: reservations) {
            if(P.human.equalsIgnoreCase(name)) {
                found = true;
                System.out.println("\n" + name + " has reserved:");
                break;
            }
        }if(found) {
            for(Person P: reservations) {
                if(P.human.equalsIgnoreCase(name)) {
                    System.out.println(P.name + " from " + P.fandom + ".");
                }
            }
            System.out.println("\nThat's it!");
        } else {
            System.out.println("\nThere are no reservations under " + name + ". Are you sure you wrote it right?");
        }
        
    }
}
