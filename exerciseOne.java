import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class exerciseOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in0 = new Scanner(System.in);
        //building to hashmap
        HashMap<String, String> usernamePassword = new HashMap<String, String>();
        HashMap<String, String> usernameFullName = new HashMap<String, String>();

        //read in the file
        File file = new File("users.txt");
        Scanner in = new Scanner(file);

        //store the info to those two hashmaps
        while(in.hasNext()){
            String fullName = in.next() + " " + in.next();
            String username = in.next();
            String password = in.next();

            usernamePassword.put(username, password);
            usernameFullName.put(username, fullName);
        }

        //three times are allowed to try to login
        for(int i = 0; i < 3; i++){
            System.out.print("Login: ");
            String username = in0.nextLine();
            System.out.print("Password: ");
            String password = in0.nextLine();

            //see whether the password is matched
            if(usernamePassword.get(username) != null && usernamePassword.get(username).equals(password)){
                System.out.println("Login successful");
                System.out.println("Welcome " + usernameFullName.get(username));
                break;
            }else{
                int attempt = 2 - i;
                if(attempt == 0){
                    System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
                }else {
                    System.out.println("Either the username or password is incorrect. You have " + attempt + " more attempts.");
                }
            }
        }
    }
}
