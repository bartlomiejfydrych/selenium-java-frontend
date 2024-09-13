package tools_qa.models;

import java.util.List;

public class PracticeForm {

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

    // -----------
    // CONSTRUCTOR
    // -----------

    public PracticeForm(String firstName, String lastName, String email, String gender, String mobileNumber,
                        String dateOfBirth, List<String> subjectList, List<String> hobbyList, String currentAddress,
                        String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        this.subjectList = subjectList;
        this.hobbyList = hobbyList;
        this.currentAddress = currentAddress;
        this.state = state;
        this.city = city;
    }

    public PracticeForm(String firstName, String lastName, String gender, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
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

    public static final class PracticeFormBuilder {

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
            return new PracticeForm(firstName, lastName, email, gender, mobileNumber, dateOfBirth, subjectList,
                    hobbyList, currentAddress, state, city);
        }
    }

    public static final class PracticeFormOnlyRequiredDataBuilder {

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
            return new PracticeForm(firstName, lastName, gender, mobileNumber);
        }
    }
}
