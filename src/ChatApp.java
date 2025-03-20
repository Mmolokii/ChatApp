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
                    User loggedInUser = loginUser();
                    if(loggedInUser != null){
                        loggedInMenu(loggedInUser);
                    } else {
                        loginUser();
                    }
                    break;
                case 3:
                    exitApp();
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

    private static void loggedInMenu(User user){
        while(true){
            System.out.println("\nWelcome, " + user.getFirstName() + " !");
            System.out.println("1. Send message");
            System.out.println("2. View Messages");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            int choice = getUserChoice();

            switch(choice){
                case 1:
                    System.out.println("Send Message: Coming soon...");
                    break;
                case 2:
                    System.out.println("View Messages: Coming soon...");
                    break;
                case 3:
                    System.out.println("logging out...");
                    exitApp(); // fix this function to log out as well
                    break; // should we use a return key instead?
                default:
                    System.out.println("Invalid choice. Please select 1, 2 or 3.");
            }
        }
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

        String result = loginSystem.registerUser(firstName, surname, username, password, phoneNumber);
        System.out.println(result);
    }

    private static User loginUser(){
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Validate user
        boolean isLoggedIn = loginSystem.loginUser(username, password);
        User loggedInuser = loginSystem.getUserByUsername(username);
        System.out.println(loginSystem.loginStatus(isLoggedIn, loggedInuser));

        return isLoggedIn ? loggedInuser : null;
    }

    private static void exitApp(){
        System.out.println("Exiting... Thank you!");
        scanner.close();
        System.exit(0);
    }
}
