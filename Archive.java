import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Archive {
    private ArrayList<Person> archive;
    private int size;
    
    public Archive() {
        archive = new ArrayList<>();
    }
    public void createArchive(String filename) throws Exception {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        String line = "";
        line = sc.nextLine();
        while(sc.hasNextLine()) {
            String info[] = line.split(",");
            Person P = new Person(info[0], info[1]);
            archive.add(P);
            line = sc.nextLine();
        }
        this.size = archive.size();        
    }

    public void active() {
        //Method that prints out all the people who are in the world.
    }    
     
    
    public void menu() {
        Scanner sc = new Scanner(System.in);
        String choice = "0";
        String asker;
        
        while(!(choice.equals("4"))) {
            System.out.println("\n \n \nWhat is it you wish to know?");
            System.out.println(" 1: How many people are there in the world?");
            System.out.println(" 2: Who are they?");
            System.out.println(" 3: What do you know about specific people?");
            System.out.println(" 4: My curiosity has been sated.\n \n \n");
            
            choice = sc.nextLine();
            if(choice.equals("1")) {
                System.out.println("There are " + this.size + " inhabitants currently in World's End.");
            }else if(choice.equals("2")) {
                System.out.println("They are:");
                for(Person p: archive) {
                    System.out.println(p.getName());
                }
            }else if(choice.equals("3")) {
                System.out.println("Tell me the name of who you wish to know more about.");
                search(sc.nextLine());   
            }else if(choice.equals("4")) {
                System.out.println("Until next time, questioner.");
            }else {
                System.out.println("Ask sensibly or begone, I'm a busy ancient artifact.");
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
            System.out.println("\n" + s + " is registered. Would you like more information? \n 1: Yes. \n 2: No.");
            String choice = sc.nextLine();
            while(!(choice.equals("2"))) {
                Scanner scan = new Scanner(System.in);
                if(choice.equals("1")) {
                    System.out.println(" 1: Which fandom does " + s + " belong to? \n 2: Are they in the world right now?");
                  /*  if(scan.nextLine.equals("1")) {
                        System.out.println(matches.get(0).getFandom());
                    }*/
                } else if(choice.equals("2")) {
                    System.out.println("Very well.");
                } else {
                    System.out.println("Ask sensibly or begone, I'm a busy ancient artifact.");
                }
            }
        }
    }
}
