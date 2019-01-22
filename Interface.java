import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        Archive archive = new Archive();
        Scanner scan = new Scanner(System.in);
        try {
            archive.createArchive("register.txt");
            archive.owners("lost.txt");
            archive.reservation("res.txt");
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        String choice = "0"; 
        while(!(choice.equals("3"))) {
            System.out.println("\n\n\nOptions menu:");
            System.out.println(" 1. The Original Mage Book. Contains information on all characters.");
            System.out.println(" 2. The Reservation list. Contains information on characters that have been reserved.");
            System.out.println(" 3. Press 3 to end the program.\n\n\n");
            //System.out.println("3. Characters not here.");
            
            choice = scan.nextLine();
            if(choice.equals("1")) {
                archive.menu();
            }else if(choice.equals("2")) {
                archive.menu1();
            }else if(choice.equals("3")){
                System.out.println("\nThank you for using the Mage Book program! Created by Seedsiz.");
            }else {
                System.out.println("I think you pressed the wrong key. Try again.\n");
            }
        }
        
        
        
        
    }
    

}
