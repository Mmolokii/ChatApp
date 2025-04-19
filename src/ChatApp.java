import java.util.Scanner;

public class ChatApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Login loginSystem = new Login();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    registerUser(); // Now validates immediately
                    break;
                case 2:
                    User loggedInUser = loginUser();
                    if (loggedInUser != null) {
                        loggedInMenu(loggedInUser);
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }

        exitApp();
    }

    private static void displayMenu() {
        System.out.println("\n__Welcome to the Chat App__");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void loggedInMenu(User user) {
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\nWelcome, " + user.getFirstName() + "!");
            System.out.println("1. Send Message");
            System.out.println("2. View Messages");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.println("Send Message: Coming soon...");
                    break;
                case 2:
                    System.out.println("View Messages: Coming soon...");
                    break;
                case 3:
                    System.out.println("Logging out...");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    private static void registerUser() {
        String username;
        do {
            System.out.print("Enter Username (must contain '_' and be ≤ 5 chars): ");
            username = scanner.nextLine();
            if (!loginSystem.checkUserName(username)) {
                System.out.println("❌ Invalid username format.");
            }
        } while (!loginSystem.checkUserName(username));

        String firstName;
        do {
            System.out.print("Enter First Name: ");
            firstName = scanner.nextLine();
            if(firstName == null || firstName.trim().isEmpty()){
                System.out.println("❌ First name cannot be empty.");
            }
        } while(firstName == null || firstName.trim().isEmpty());

        String surname;
        do {
            System.out.print("Enter Surname: ");
            surname = scanner.nextLine();
            if(surname == null || surname.trim().isEmpty()){
                System.out.println("❌ Surname cannot be empty.");
            }
        } while(surname == null || surname.trim().isEmpty());

        String password;
        do {
            System.out.print("Enter Password (min 8 chars, capital, number, special char): ");
            password = scanner.nextLine();
            if (!loginSystem.checkPasswordComplexity(password)) {
                System.out.println("❌ Password is not complex enough.");
            }
        } while (!loginSystem.checkPasswordComplexity(password));

        String phoneNumber;
        do {
            System.out.print("Enter Phone Number (+27XXXXXXXXX): ");
            phoneNumber = scanner.nextLine();
            if (!loginSystem.checkCellPhoneNumber(phoneNumber)) {
                System.out.println("❌ Invalid phone number format.");
            }
        } while (!loginSystem.checkCellPhoneNumber(phoneNumber));

        // Call registration
        String result = loginSystem.registerUser(firstName, surname, username, password, phoneNumber);
        System.out.println(result);
    }

    private static User loginUser() {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        boolean isLoggedIn = loginSystem.loginUser(username, password);
        User loggedInUser = loginSystem.getUserByUsername(username);

        System.out.println(loginSystem.loginStatus(isLoggedIn, loggedInUser));

        return isLoggedIn ? loggedInUser : null;
    }

    private static void exitApp() {
        System.out.println("👋 Exiting... Thank you!");
        scanner.close();
    }
}
