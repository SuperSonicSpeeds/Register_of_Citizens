import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        Archive archive = new Archive();
        try {
            archive.createArchive("register.txt");
        } catch(Exception e) {
            e.printStackTrace();
        }
        archive.menu();
        
    }
    

}
