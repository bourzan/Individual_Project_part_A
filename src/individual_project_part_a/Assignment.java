package individual_project_part_a;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Andreas
 */
public class Assignment {
    private String title;
    private String description;
    private LocalDate subDateTime;
    private int oralMark;
    private int totalMark;

    public Assignment(String title, String description) {
        this.title = title;
        this.description = description;
        this.subDateTime = LocalDate.now();
    }

    public Assignment(Assignment a) {
        this.title =  a.getTitle();
        this.description = a.getDescription();
        this.subDateTime = LocalDate.now();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append("").append(title);
        sb.append(", ").append(description);
        sb.append(", ").append(subDateTime.format(DateTimeFormatter.ofPattern("d/M/uuuu")));
        sb.append(", ").append(oralMark);
        sb.append(", ").append(totalMark);
        sb.append(']');
        return sb.toString();
    }

    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }
    
    
    
    
    
}
