import java.util.ArrayList;
import java.util.Scanner;

class User {
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

public class RegistrationSystem {
    private static ArrayList<User> users = new ArrayList<>();

    // Validate email format (simple check)
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    // Check if username already exists
    public static boolean usernameExists(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public static void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (usernameExists(username)) {
            System.out.println("Username already taken! Try a different one.");
            return;
        }

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (!isValidEmail(email)) {
            System.out.println("Invalid email format!");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // For simplicity, no password strength validation here

        users.add(new User(username, email, password));
        System.out.println("Registration successful!");
    }

    public static void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No registered users.");
            return;
        }

        System.out.println("Registered Users:");
        for (User user : users) {
            System.out.println("Username: " + user.getUsername() + ", Email: " + user.getEmail());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- User Registration System ---");
            System.out.println("1. Register User");
            System.out.println("2. List Registered Users");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    listUsers();
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}

