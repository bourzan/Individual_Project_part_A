package individual_project_part_a;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Andreas
 */
public class Student implements Person {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append("").append(firstName);
        sb.append(", ").append(lastName);
        sb.append(", ").append(dateOfBirth.format(DateTimeFormatter.ofPattern("d/M/uuuu")));
        sb.append(", ").append(tuitionFees);
        sb.append(']');
        return sb.toString();
    }
    
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;        
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getFees() {
        return tuitionFees;
    }

    public void setFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }
    
}
