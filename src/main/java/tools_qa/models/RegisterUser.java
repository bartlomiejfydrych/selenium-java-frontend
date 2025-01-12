package tools_qa.models;

public class RegisterUser {

    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String password;

    // -----------
    // CONSTRUCTOR
    // -----------

    private RegisterUser(RegisterUserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.userName = builder.userName;
        this.password = builder.password;
    }

    // -------
    // GETTERS
    // -------

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

    public static class RegisterUserBuilder {

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
            return new RegisterUser(this);
        }
    }
}
