package tools_qa.models;

public class TableRow {

    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;

    public TableRow(String firstName, String lastName, String email, String age, String salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

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

    public static final class TableRowBuilder {

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
            return new TableRow(firstName, lastName, email, age, salary, department);
        }
    }
}
