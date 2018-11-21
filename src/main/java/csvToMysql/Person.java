package csvToMysql;

public class Person {

    private String rowNumber;
    private String lastName;
    private String firstName;

    public Person() {
    }

    public Person(String rowNumber, String firstName, String lastName) {
        this.rowNumber = rowNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getRowNumber() {
        return rowNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }

}
