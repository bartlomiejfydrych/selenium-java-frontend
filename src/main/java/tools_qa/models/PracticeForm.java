package tools_qa.models;

import java.util.List;

public class PracticeForm {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String gender;
    private final String mobileNumber;
    private final String dateOfBirth;
    private final List<String> subjectList;
    private final List<String> hobbyList;
    private final String currentAddress;
    private final String state;
    private final String city;

    // -----------
    // CONSTRUCTOR
    // -----------

    private PracticeForm(PracticeFormBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.gender = builder.gender;
        this.mobileNumber = builder.mobileNumber;
        this.dateOfBirth = builder.dateOfBirth;
        this.subjectList = builder.subjectList;
        this.hobbyList = builder.hobbyList;
        this.currentAddress = builder.currentAddress;
        this.state = builder.state;
        this.city = builder.city;
    }

    private PracticeForm(PracticeFormOnlyRequiredDataBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = null;
        this.gender = builder.gender;
        this.mobileNumber = builder.mobileNumber;
        this.dateOfBirth = null;
        this.subjectList = null;
        this.hobbyList = null;
        this.currentAddress = null;
        this.state = null;
        this.city = null;
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

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public List<String> getSubjectList() {
        return subjectList;
    }

    public List<String> getHobbyList() {
        return hobbyList;
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

    public static class PracticeFormBuilder {

        private String firstName;
        private String lastName;
        private String email;
        private String gender;
        private String mobileNumber;
        private String dateOfBirth;
        private List<String> subjectList;
        private List<String> hobbyList;
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

        public PracticeFormBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public PracticeFormBuilder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public PracticeFormBuilder dateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PracticeFormBuilder subjectList(List<String> subjectList) {
            this.subjectList = subjectList;
            return this;
        }

        public PracticeFormBuilder hobbyList(List<String> hobbyList) {
            this.hobbyList = hobbyList;
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
            return new PracticeForm(this);
        }
    }

    public static class PracticeFormOnlyRequiredDataBuilder {

        private String firstName;
        private String lastName;
        private String gender;
        private String mobileNumber;

        public PracticeFormOnlyRequiredDataBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PracticeFormOnlyRequiredDataBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PracticeFormOnlyRequiredDataBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public PracticeFormOnlyRequiredDataBuilder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public PracticeForm build() {
            return new PracticeForm(this);
        }
    }
}
