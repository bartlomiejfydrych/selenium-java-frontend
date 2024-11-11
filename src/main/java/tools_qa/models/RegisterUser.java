package tools_qa.models;

public class RegisterUser {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    // CONSTRUCTOR

    public RegisterUser(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    // GETTERS

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    // -------
    // BUILDER
    // -------

    public static final class RegisterUserBuilder {

        private String firstName;
        private String lastName;
        private String userName;
        private String password;

        public RegisterUserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public RegisterUserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public RegisterUserBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public RegisterUserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public RegisterUser build() {
            return new RegisterUser(firstName, lastName, userName, password);
        }
    }
}
