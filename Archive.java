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
            Person P = new Person(line, line);
            System.out.println(P.getName());
            archive.add(P);
            line = sc.nextLine();
        }
        this.size = archive.size();        
    }
    
    
    public void menu() {
        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        String choice = "0";
        
        while(!(choice.equals("2"))) {
            System.out.println("\nWhat is it you wish to know?");
            System.out.println("1: How many people are there in the world?");
            System.out.println("2: My curiosity has been sated.\n");
            
            choice = sc.nextLine();
            if(choice.equals("1")) {
                System.out.println("There are " + this.size + " inhabitants currently in WE.");
            } else {
                System.out.println("Ask sensibly or begone, I'm a busy ancient artifact.")
            }
        System.out.println("Until next time, questioner.")
        }
    }
}
