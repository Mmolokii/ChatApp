public class User {
    private String firstName;
    private String surname;
    public String username;
    public String password;
    public String phoneNumber;

    public User(String firstName, String surname, String username, String password, String phoneNumber){
        this.firstName = firstName;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.phoneNumber = password;
    }

    public String getFirstName(){
        return firstName;
    }


    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
