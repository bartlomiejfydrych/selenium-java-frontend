package tools_qa.models;

public class TextBoxForm {

    private final String fullName;
    private final String email;
    private final String currentAddress;
    private final String permanentAddress;

    // -----------
    // CONSTRUCTOR
    // -----------

    private TextBoxForm(TextBoxFormBuilder builder) {
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.currentAddress = builder.currentAddress;
        this.permanentAddress = builder.permanentAddress;
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

    public static class TextBoxFormBuilder {

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
            return new TextBoxForm(this);
        }
    }
}
