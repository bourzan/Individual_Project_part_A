package individual_project_part_a;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Andreas
 */
public class Course {
    private String title;
    private String stream;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;

    public Course(String title, String stream, String type, LocalDate start_date, LocalDate end_date) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append("").append(title);
        sb.append(", ").append(stream);
        sb.append(", ").append(type);
        sb.append(", ").append(start_date.format(DateTimeFormatter.ofPattern("d/M/uuuu")));
        sb.append(", ").append(end_date.format(DateTimeFormatter.ofPattern("d/M/uuuu")));
        sb.append(']');
        return sb.toString();
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return start_date;
    }

    public void setStartDate(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEndDate() {
        return end_date;
    }

    public void setEndDate(LocalDate end_date) {
        this.end_date = end_date;
    }
    
    
}
