package tools_qa.models;

public class TableRow {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String age;
    private final String salary;
    private final String department;

    // -----------
    // CONSTRUCTOR
    // -----------

    private TableRow(TableRowBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.age = builder.age;
        this.salary = builder.salary;
        this.department = builder.department;
    }

    // -------
    // GETTERS
    // -------

    public String getAge() {
        return age;
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

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    // -------
    // BUILDER
    // -------

    public static class TableRowBuilder {

        private String firstName;
        private String lastName;
        private String email;
        private String age;
        private String salary;
        private String department;

        public TableRowBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TableRowBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TableRowBuilder email(String email) {
            this.email = email;
            return this;
        }

        public TableRowBuilder age(String age) {
            this.age = age;
            return this;
        }

        public TableRowBuilder salary(String salary) {
            this.salary = salary;
            return this;
        }

        public TableRowBuilder department(String department) {
            this.department = department;
            return this;
        }

        public TableRow build() {
            return new TableRow(this);
        }
    }
}
