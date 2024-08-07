package tools_qa.models;

public class PracticeForm {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String currentAddress;
    private String state;
    private String city;

    public PracticeForm(String firstName, String lastName, String email, String mobileNumber, String currentAddress, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.currentAddress = currentAddress;
        this.state = state;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    // -------
    // BUILDER
    // -------

    public static final class PracticeFormBuilder {

        private String firstName;
        private String lastName;
        private String email;
        private String mobileNumber;
        private String currentAddress;
        private String state;
        private String city;

        public PracticeFormBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PracticeFormBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PracticeFormBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PracticeFormBuilder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public PracticeFormBuilder currentAddress(String currentAddress) {
            this.currentAddress = currentAddress;
            return this;
        }

        public PracticeFormBuilder state(String state) {
            this.state = state;
            return this;
        }

        public PracticeFormBuilder city(String city) {
            this.city = city;
            return this;
        }

        public PracticeForm build() {
            return new PracticeForm(firstName, lastName, email, mobileNumber, currentAddress, state, city);
        }
    }
}
