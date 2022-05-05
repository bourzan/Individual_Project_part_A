package individual_project_part_a;

/**
 *
 * @author Andreas
 */
public class Trainer implements Person {
    private String firstName;
    private String lastName;
    private String subject;

    public Trainer() {
        this.firstName = "testName";
        this.lastName = "testSurname";
        this.subject = "testSubject";
    }

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append("").append(firstName);
        sb.append(", ").append(lastName);
        sb.append(", ").append(subject);
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
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
