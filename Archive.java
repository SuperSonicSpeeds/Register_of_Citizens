import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Archive {
    private ArrayList<Person> archive;
    private ArrayList<Person> active;
    private ArrayList<Person> inactive;
    private int size;
    private int inhabitants;
    
    public Archive() {
        archive = new ArrayList<>();
        active = new ArrayList<>();
        inactive = new ArrayList<>();
    }
    public void createArchive(String filename) throws Exception {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        String line = "";
        line = sc.nextLine();
        while(sc.hasNextLine()) {
            String info[] = line.split(", ");
            Person P = new Person(info[0], info[1], info[2]);
            if(info[3].equalsIgnoreCase("active")) {
                P.setStatus();
                active.add(P);
            }else {
                inactive.add(P);
            }
            archive.add(P);
            line = sc.nextLine();
        }
        this.size = archive.size();  
        this.inhabitants = active.size();      
    }     
    
    public void menu() {
        Scanner sc = new Scanner(System.in);
        String choice = "0";
        
        while(!(choice.equals("4"))) {
            System.out.println("\n \n \nWhat is it you wish to know?");
            System.out.println(" 1: How many people are there in the world?");
            System.out.println(" 2: Who are they?");
            System.out.println(" 3: What do you know about specific people?");
            System.out.println(" 4: My curiosity has been sated.\n \n \n");
            
            choice = sc.nextLine();
            if(choice.equals("1")) {
                System.out.println("\nThere are " + this.inhabitants + " inhabitants currently in World's End.");
            }else if(choice.equals("2")) {
                System.out.println("\nThey are:");
                for(Person p: active) {
                    System.out.println(p.getName());
                }
            }else if(choice.equals("3")) {
                System.out.println("Tell me the full name of who you wish to know more about.\n");
                search(sc.nextLine());   
            }else if(choice.equals("4")) {
                System.out.println("Until next time, questioner.");
            }else if(choice.equalsIgnoreCase("What is the meaning of life?") || choice.equalsIgnoreCase("What's the meaning of life?")) {
                System.out.println("The answer to the Great Question of Life, the Universe, and Everything is... forty-two.");
            }else {
                System.out.println("\nAsk sensibly or begone, I'm a busy ancient artifact.");
            }
        }       
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
                    System.out.println(matches.get(0).getInformation());
                    break;
                } else if(choice.equals("2")) {
                    System.out.println("Very well.");
                } else {
                    System.out.println("\nAsk sensibly or begone, I'm a busy ancient artifact.");
                    break;
                }
            }
        }
    }
}
