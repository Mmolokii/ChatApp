public class Login {
    private User[] users;
    private int maxUsers = 10;
    private int userCount;

    public Login(){
        users = new User[maxUsers];
        userCount = 0;
    }

    public boolean checkUserName(String username){
        if(username.length() > 5){
            return false;
        } else if(!username.contains("_")){
            return false;
        }
        return true;
    }

    public boolean checkPasswordComplexity(String password){
        if(password.length() < 8){
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Special Characters to check for
        String specialCharacters = "!@#$%^&*()_+";

        // Loop through each character in the password
        for(char ch: password.toCharArray()){
            if(Character.isUpperCase(ch)){
                hasUpperCase = true;
            } else if(Character.isDigit(ch)){
                hasDigit = true;
            } else if(specialCharacters.contains(String.valueOf(ch))){
                hasSpecialChar = true;
            }
        }
        return hasUpperCase && hasDigit && hasSpecialChar;
    }

    public boolean checkCellPhoneNumber(String phoneNumber){
        // Check for country code
        if(!phoneNumber.startsWith("+27")){
            return false;
        }

        // Check the total length
        if(phoneNumber.length() != 12){
            return false;
        }

        // Check for digits
        String digitsOnly = phoneNumber.substring(3);
        if(!digitsOnly.matches("\\d{9}")){ // Ensure 9 digits
            return false;
        }
        return true;
    }

    public String registerUser(String name, String surname, String username, String password, String phoneNumber){
        if(!checkUserName(username)){
            return "Username is not correctly formatted. Ensure it contains an underscore and is no more than 5 characters.";
        }

        if(!checkPasswordComplexity(password)){
            return "Password is not correctly formatted. Ensure it contains at least 8 characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell phone number is incorrectly formatted or does not contain international code.";
        }

        if (userCount < users.length) {
            users[userCount] = new User(name, surname, username, password, phoneNumber);
            userCount++;
            return "User registered successfully!";
        } else {
            return "User storage is full. Cannot register more users.";
        }
    }

    public boolean loginUser(String username, String password){
        for(int i = 0; i < userCount; i++){
            if(users[i].getUsername().equals(username) && users[i].getPassword().equals(password)){
                return true; // Login successful
            }
        }
        return false; // Login failed
    }

    public String loginStatus(boolean status, User user){
        if(status && user != null){

            return "Welcome " + user.getFirstName() + ", " + user.getSurname() + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Get the user by their username
    public User getUserByUsername(String username){
        for(int i = 0; i < userCount; i++){
            if(users[i].getUsername().equals(username)){
                return users[i];
            }
        }
        return null; // user was not found
    }
}
