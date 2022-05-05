package individual_project_part_a;

import java.util.ArrayList;

/**
 *
 * @author Andreas
 */
public class ActiveCourse {
    private Course cour;
    private ArrayList<Trainer> tra;
    private ArrayList<Student> stu;
    private ArrayList<Assignment> ass;

    public ActiveCourse(Course cour, ArrayList<Trainer> tra, ArrayList<Student> stu, ArrayList<Assignment> ass) {
        this.cour = cour;
        this.tra = tra;
        this.stu = stu;
        this.ass = ass;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append("Course:").append(cour);
        sb.append(", Trainers:").append(tra);
        sb.append(", Students:").append(stu);
        sb.append(", Assignments:").append(ass);
        sb.append(']');
        return sb.toString();
    }

    public Course getCourse() {
        return cour;
    }

    public void setCourse(Course cour) {
        this.cour = cour;
    }

    public ArrayList<Trainer> getTrainers() {
        return tra;
    }

    public void setTrainers(ArrayList<Trainer> tra) {
        this.tra = tra;
    }

    public ArrayList<Student> getStudents() {
        return stu;
    }

    public void setStudents(ArrayList<Student> stu) {
        this.stu = stu;
    }

    public ArrayList<Assignment> getAssignments() {
        return ass;
    }

    public void setAssignments(ArrayList<Assignment> ass) {
        this.ass = ass;
    }
    
}
