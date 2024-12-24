package tools_qa.models;

public class TextBoxForm {

    private final String fullName;
    private final String email;
    private final String currentAddress;
    private final String permanentAddress;

    // -----------
    // CONSTRUCTOR
    // -----------

    public TextBoxForm(String fullName, String email, String currentAddress, String permanentAddress) {
        this.fullName = fullName;
        this.email = email;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }

    // -------
    // GETTERS
    // -------

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    // -------
    // BUILDER
    // -------

    public static final class TextBoxFormBuilder {

        private String fullName;
        private String email;
        private String currentAddress;
        private String permanentAddress;

        public TextBoxFormBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public TextBoxFormBuilder email(String email) {
            this.email = email;
            return this;
        }

        public TextBoxFormBuilder currentAddress(String currentAddress) {
            this.currentAddress = currentAddress;
            return this;
        }

        public TextBoxFormBuilder permanentAddress(String permanentAddress) {
            this.permanentAddress = permanentAddress;
            return this;
        }

        public TextBoxForm build() {
            return new TextBoxForm(fullName, email, currentAddress, permanentAddress);
        }
    }
}
