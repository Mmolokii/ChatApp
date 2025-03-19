import java.util.Scanner;

public class ChatApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Login loginSystem = new Login();
    public static void main(String[] args) {
        while(true){
            displayMenu();
            int choice = getUserChoice();

            switch (choice){
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    extiApp();
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }

    private static void displayMenu(){
        System.out.println("\n__Welcome to the Chat App__");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice(){
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume nextLine
        return choice;
    }

    private static void registerUser(){
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
    }

    private static void loginUser(){
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Validate user
        boolean isLoggedIn = loginSystem.loginUser(username, password);
        User loggedInuser = loginSystem.getUserByUsername(username);
        System.out.println(loginSystem.loginStatus(isLoggedIn, loggedInuser));
    }

    private static void extiApp(){
        System.out.println("Exiting... Thank you!");
        scanner.close();
        System.exit(0);
    }
}
