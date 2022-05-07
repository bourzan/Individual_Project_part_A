package individual_project_part_a;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


/**
 *
 * @author Andreas
 */
public class PrivSchool {

    protected ArrayList<Student> pSStudents;
    protected ArrayList<Trainer> pSTrainers;
    protected ArrayList<Course> pSCourses;
    protected ArrayList<Assignment> pSAssignments;
    protected ArrayList<ActiveCourse> runningCourses;
    
    protected Scanner sc;
    protected final DateTimeFormatter dformat;

    
    public PrivSchool() {
        pSStudents = new ArrayList();
        pSTrainers = new ArrayList();
        pSCourses = new ArrayList();
        pSAssignments = new ArrayList();
        runningCourses = new ArrayList();
        
        sc = new Scanner(System.in);
        dformat = DateTimeFormatter.ofPattern("d/M/uuuu");
    }
    
    public void addAssignments() {
        String readLine;
        
        System.out.println("Assignment List:");
        System.out.println(pSAssignments);
        System.out.println("\nEnter new assignments, one per line, data in each line separated by space");
        System.out.println("Leave a blank line to stop. If list is empty, premade data will be used");
        System.out.println("Format: [Title] [Description]");
        Assignment tmpAss;
        do {
            readLine = sc.nextLine().trim().replaceAll("  +", " ");
            if (!readLine.equals("")) {
                tmpAss = string2Assignment(readLine);
                if (tmpAss == null) {
                    System.out.println("Please use the exact format for each entry");
                } else {
                    pSAssignments.add(tmpAss);
                }
            } else {
                break;
            }
        } while (true);
        if (pSAssignments.isEmpty()) {
            pSAssignments.add(string2Assignment("java1 Basics"));
            pSAssignments.add(string2Assignment("java2 Fundamentals"));
            pSAssignments.add(string2Assignment("java3 Advanced"));
            pSAssignments.add(string2Assignment("java4 Project1"));
            pSAssignments.add(string2Assignment("java5 Project2"));
            pSAssignments.add(string2Assignment("c#1 Basics"));
            pSAssignments.add(string2Assignment("c#2 Fundamentals"));
            pSAssignments.add(string2Assignment("c#3 Advanced"));
            pSAssignments.add(string2Assignment("c#4 Project1"));
            pSAssignments.add(string2Assignment("c#5 Project2"));
            pSAssignments.add(string2Assignment("python1 Basics"));
            pSAssignments.add(string2Assignment("python2 Fundamentals"));
            pSAssignments.add(string2Assignment("python3 Advanced"));
            pSAssignments.add(string2Assignment("python4 Project1"));
            pSAssignments.add(string2Assignment("python5 Project2"));
        }
    }
    
    private Assignment string2Assignment(String tmp) {
        String[] tmpArray = tmp.split(" ");
        if (tmpArray.length < 2)
            return null;
        for (int i=0; i < tmpArray.length; i++) {
            tmpArray[i] = tmpArray[i].substring(0, 1).toUpperCase() + tmpArray[i].substring(1).toLowerCase();
        }
        //if (!tmpArray[0].matches("[a-zA-Z0-9\\#]*")) {
        if (!tmpArray[0].matches("(Java\\d|C#\\d|Python\\d)")) {
            System.out.println("JavaX/C#X/PythonX title only (X is number)");
            return null;
        }
        if (tmpArray[1].isBlank()) {
            System.out.println("Description missing");
            return null;
        }
        return new Assignment(tmpArray[0],tmpArray[1]);
    }
    
    
    public void addCourses() {
        String readLine;
        
        System.out.println("Course List:");
        System.out.println(pSCourses);
        System.out.println("\nEnter new courses, one per line, data in each line separated by space");
        System.out.println("Leave a blank line to stop. If list is empty, premade data will be used");
        System.out.println("Format: [Title] [Stream] [Type] [Start Date] [End Date]");
        Course tmpCour;
        do {
            readLine = sc.nextLine().trim().replaceAll("  +", " ");
            if (!readLine.equals("")) {
                tmpCour = string2Course(readLine);
                if (tmpCour == null) {
                    System.out.println("Please use the exact format for each entry");
                } else {
                    pSCourses.add(tmpCour);
                }
            } else {
                break;
            }
        } while (true);
        if (pSCourses.isEmpty()) {
            pSCourses.add(string2Course("CB6 Java Full-time 01/01/2020 30/03/2020"));
            pSCourses.add(string2Course("CB6 Java Part-time 01/01/2020 30/06/2020"));
            pSCourses.add(string2Course("CB6 C# Full-time 01/01/2020 30/03/2020"));
            pSCourses.add(string2Course("CB6 C# Part-time 01/01/2020 30/06/2020"));
            pSCourses.add(string2Course("CB6 Python Full-time 01/01/2020 30/03/2020"));
            pSCourses.add(string2Course("CB6 Python Part-time 01/01/2020 30/06/2020"));
            pSCourses.add(string2Course("CB7 Java Full-time 01/07/2020 30/10/2020"));
            pSCourses.add(string2Course("CB7 Java Part-time 01/07/2020 30/12/2020"));
            pSCourses.add(string2Course("CB7 C# Full-time 01/07/2020 30/10/2020"));
            pSCourses.add(string2Course("CB7 C# Part-time 01/07/2020 30/12/2020"));
            pSCourses.add(string2Course("CB7 Python Full-time 01/07/2020 30/10/2020"));
            pSCourses.add(string2Course("CB7 Python Part-time 01/07/2020 30/12/2020"));
        }
    }

    private Course string2Course(String tmp) {
        String[] tmpArray = tmp.split(" ");
        if (tmpArray.length < 5)
            return null;
        for (int i=1; i < tmpArray.length; i++) {
            tmpArray[i] = tmpArray[i].substring(0, 1).toUpperCase() + tmpArray[i].substring(1).toLowerCase();
        }
        if (!tmpArray[0].matches("[a-zA-Z0-9]*")) {
            System.out.println("Alphanumerical title only");
            return null;
        }
        if (!tmpArray[1].matches("(Java|C#|Python)")) {
            System.out.println("Java/C#/Python stream only");
            return null;
        }
        if (!tmpArray[2].matches("(Part-time|Full-time)")) {
            System.out.println("Part-time or Full-time type only");
            return null;
        }
        try {
            LocalDate.parse(tmpArray[3],dformat);
        } catch (DateTimeParseException e) {
            System.out.println("Improper starting date");
            return null;
        }
        try {
            LocalDate.parse(tmpArray[4],dformat);
        } catch (DateTimeParseException e) {
            System.out.println("Improper ending date");
            return null;
        }
        return new Course(tmpArray[0],tmpArray[1],tmpArray[2],LocalDate.parse(tmpArray[3],dformat),LocalDate.parse(tmpArray[4],dformat));
    }
    
    public void addTrainers() {
        String readLine;
        
        System.out.println("Trainer List:");
        System.out.println(pSTrainers);
        System.out.println("\nEnter new trainers, one per line, data in each line separated by space");
        System.out.println("Leave a blank line to stop. If list is empty, premade data will be used");
        System.out.println("Format: [Name] [Surname] [Subject]");
        Trainer tmpTra;
        do {
            readLine = sc.nextLine().trim().replaceAll("  +", " ");
            if (!readLine.equals("")) {
                tmpTra = string2Trainer(readLine);
                if (tmpTra == null) {
                    System.out.println("Please use the exact format for each entry");
                } else {
                    pSTrainers.add(tmpTra);
                }
            } else {
                break;
            }
        } while (true);
        if (pSTrainers.isEmpty()) {
            pSTrainers.add(string2Trainer("Xaris Voultepsis Java"));
            pSTrainers.add(string2Trainer("Dimitra Rotonda Java"));
            pSTrainers.add(string2Trainer("Xarilaos Trikoupis C#"));
            pSTrainers.add(string2Trainer("Dimitris Glibaris Java"));
            pSTrainers.add(string2Trainer("Alexandros Filopoulos C#"));
            pSTrainers.add(string2Trainer("Roula Pispirikou C#"));
            pSTrainers.add(string2Trainer("Zaxarias Podemos Java"));
            pSTrainers.add(string2Trainer("Manolis Douris C#"));
        }
    }
    
    private Trainer string2Trainer(String tmp) {
        String[] tmpArray = tmp.split(" ");
        if (tmpArray.length < 3)
            return null;
        for (int i=0; i < tmpArray.length; i++) {
            tmpArray[i] = tmpArray[i].substring(0, 1).toUpperCase() + tmpArray[i].substring(1).toLowerCase();
        }
        if (!tmpArray[0].matches("[a-zA-Z]*")) {
            System.out.println("Alphabetical name only");
            return null;
        }
        if (!tmpArray[1].matches("[a-zA-Z]*")) {
            System.out.println("Alphabetical surname only");
            return null;
        }
        if (!tmpArray[2].matches("(Java|C#|Python)")) {
            System.out.println("Java/C#/python subject only");
            return null;
        }
        return new Trainer(tmpArray[0],tmpArray[1],tmpArray[2]);
    }
    
    
    public void addStudents() {
        String readLine;
        
        System.out.println("Student List:");
        System.out.println(pSStudents);
        System.out.println("\nEnter new students, one per line, data in each line separated by space");
        System.out.println("Leave a blank line to stop. If list is empty, premade data will be used");
        System.out.println("Format: [Name] [Surname] [Date of Birth(dd/mm/yyyy)] [Tuition Fees]");
        Student tmpStud;
        do {
            readLine = sc.nextLine().trim().replaceAll("  +", " ");
            if (!readLine.equals("")) {
                tmpStud = string2Student(readLine);
                if (tmpStud == null) {
                    System.out.println("Please use the exact format for each entry");
                } else {
                    pSStudents.add(tmpStud);
                }
            } else {
                break;
            }
        } while (true);
        if (pSStudents.isEmpty()) {
            pSStudents.add(string2Student("Giannis Matzarakis 12/3/1997 500"));
            pSStudents.add(string2Student("Mihalis Gogos 7/8/1986 700"));
            pSStudents.add(string2Student("Ieroklis Kontovithoulkas 23/1/2001 2100"));
            pSStudents.add(string2Student("Andreas Filkakis 30/6/1996 800"));
            pSStudents.add(string2Student("Fillipos Gonipetis 18/4/2007 900"));
            pSStudents.add(string2Student("Manolis Mixalos 11/3/1999 700"));
            pSStudents.add(string2Student("Nikos Batarakis 25/11/1998 600"));
            pSStudents.add(string2Student("Lampros Lampiris 14/4/1977 300"));
            pSStudents.add(string2Student("Kostas Maxlapakis 9/12/2002 1700"));
            pSStudents.add(string2Student("Giorgos Vavas 1/2/2000 100"));
            pSStudents.add(string2Student("Vaggelis Vixas 29/2/1995 700"));
            pSStudents.add(string2Student("Maria Pentagiotisa 17/8/2006 800"));
            pSStudents.add(string2Student("Pantelis Mokos 23/4/1992 600"));
            pSStudents.add(string2Student("Vrasidas Gopas 1/1/1990 1000"));
            pSStudents.add(string2Student("Xristina Goulia 19/12/1980 400"));
            pSStudents.add(string2Student("Fillipos Roxamis 20/11/2005 1200"));
            pSStudents.add(string2Student("Despoina Robota 3/3/1940 1800"));
            pSStudents.add(string2Student("Spiros Vithoulas 19/5/1996 300"));
            pSStudents.add(string2Student("Eleni Glitsa 29/8/1981 200"));
            pSStudents.add(string2Student("Giolanda Makri 18/7/2003 600"));
        }
    }
    
    private Student string2Student(String tmp) {
        String[] tmpArray = tmp.split(" ");
        if (tmpArray.length < 4)
            return null;
        for (int i=0; i < tmpArray.length; i++) {
            tmpArray[i] = tmpArray[i].substring(0, 1).toUpperCase() + tmpArray[i].substring(1).toLowerCase();
        }
        if (!tmpArray[0].matches("[a-zA-Z]*")) {
            System.out.println("Alphabetical name only");
            return null;
        }
        if (!tmpArray[1].matches("[a-zA-Z]*")) {
            System.out.println("Alphabetical surname only");
            return null;
        }
        try {
            LocalDate.parse(tmpArray[2],dformat);
        } catch (DateTimeParseException e) {
            System.out.println("Improper date");
            return null;
        }
        if (!tmpArray[3].matches("[0-9]*")) {
            System.out.println("Numeric tuition only");
            return null;
        }
        return new Student(tmpArray[0],tmpArray[1],LocalDate.parse(tmpArray[2],dformat),Integer.parseInt(tmpArray[3]));
    }

    public void activateCourse() {
        String readLine;
        int c;

        int max = pSCourses.size();
        System.out.println("Select a course to populate: [1-" + max + "]");
        for (int i = 0; i < max; i++) {
            System.out.println(i+1 + ") " + pSCourses.get(i));
        }
        readLine = sc.nextLine().trim();
        try {
            c = Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            return;
        }
        c--;
        if (c >=max || c < 0) {
            System.out.println("Out of bounds number");
            return;
        }
        max = pSStudents.size();
        System.out.println("Select students to assign, each number separated by space: [1-" + max + "]");
        for (int i = 0; i < max; i++) {
            System.out.println(i+1 + ") " + pSStudents.get(i));
        }
        readLine = sc.nextLine().trim().replaceAll("  +", " ");
        if (!readLine.matches("[0-9\\s]*")) {
            System.out.println("Numbers only");
            return;
        }
        String[] tmp = readLine.split(" ");
        int[] s = new int[tmp.length];
        for (int i=0; i < tmp.length; i++) {
            try {
                s[i] = Integer.parseInt(tmp[i])-1;
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
                return;
            }
        }
        ArrayList<Student> tempstu = new ArrayList();
        for (int i=0; i < s.length; i++) {
            if (s[i] >= pSStudents.size())
                continue;
            tempstu.add(pSStudents.get(s[i]));
        }
        ArrayList<Trainer> temptra = new ArrayList();
        for (Trainer t: pSTrainers) {
            if (t.getSubject().equals(pSCourses.get(c).getStream())) {
                temptra.add(t);
            }
        }
        ArrayList<Assignment> tempass = new ArrayList();
        for (Assignment a : pSAssignments) {
            if (a.getTitle().contains(pSCourses.get(c).getStream())) {
                tempass.add(new Assignment(a));
            }
        }
        long days = pSCourses.get(c).getStartDate().datesUntil(pSCourses.get(c).getEndDate()).count();
        LocalDate subdate = pSCourses.get(c).getStartDate();
        days = days/5;
        for (Assignment a : tempass) {
            subdate = subdate.plusDays(days);
            if (subdate.getDayOfWeek().getValue() == 6) {
                subdate = subdate.minusDays(1);
            }
            if (subdate.getDayOfWeek().getValue() == 7) {
                subdate = subdate.minusDays(2);
            }
            a.setSubDateTime(subdate);
        }
        runningCourses.add(new ActiveCourse(pSCourses.get(c), temptra, tempstu, tempass));
    }
    
    public void activeCourses() {
        String readLine;
        
        if (pSCourses.isEmpty()) {
            System.out.println("Courses not set");
            return;
        }
        if (pSTrainers.isEmpty()) {
            System.out.println("Trainers not set");
            return;
        }
        if (pSStudents.isEmpty()) {
            System.out.println("Students not set");
            return;
        }
        if (pSAssignments.isEmpty()) {
            System.out.println("Assignments not set");
            return;
        }
        do {
            System.out.println("Active Courses:");
            System.out.println(runningCourses);
            System.out.println("\nEnter 'a' to add running courses or anything else to go back");
            readLine = sc.nextLine().trim();
            if (readLine.toLowerCase().equals("a")) {
                activateCourse();
            } else {
                break;
            }
        } while (true);
    }
    
    public void studentsPerCourse() {
        String readLine;
        
        for (int i=0; i < runningCourses.size(); i++) {
            System.out.println(i+1 + ") " + runningCourses.get(i).getCourse().getTitle()
                    + " " + runningCourses.get(i).getCourse().getStream());
        }
        readLine = sc.nextLine().trim();
        int i;
        try {
            i = Integer.parseInt(readLine)-1;
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            return;
        }
        if (i < runningCourses.size()) {
            System.out.println(runningCourses.get(i).getStudents());
        }
    }
    
    public void trainersPerCourse() {
        String readLine;
        
        for (int i=0; i < runningCourses.size(); i++) {
            System.out.println(i+1 + ") " + runningCourses.get(i).getCourse().getTitle()
                    + " " + runningCourses.get(i).getCourse().getStream());
        }
        readLine = sc.nextLine().trim();
        int i;
        try {
            i = Integer.parseInt(readLine)-1;
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            return;
        }
        if (i < runningCourses.size()) {
            System.out.println(runningCourses.get(i).getTrainers());
        }
    }
    
    public void assignmentsPerCourse() {
        String readLine;
        
        for (int i=0; i < runningCourses.size(); i++) {
            System.out.println(i+1 + ") " + runningCourses.get(i).getCourse().getTitle()
                    + " " + runningCourses.get(i).getCourse().getStream());
        }
        readLine = sc.nextLine().trim();
        int i;
        try {
            i = Integer.parseInt(readLine)-1;
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            return;
        }
        if (i < runningCourses.size() && i <= 0) {
            System.out.println(runningCourses.get(i).getAssignments());
        }
    }
    
    public void assignmentsPerStudent() {
        String readLine;
        
        for (int i = 0; i < pSStudents.size(); i++) {
            System.out.println(i+1 + ") " + pSStudents.get(i));
        }
        readLine = sc.nextLine().trim();
        int n;
        try {
            n = Integer.parseInt(readLine)-1;
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            return;
        }
        ArrayList<Assignment> tmpass = new ArrayList();
        for (int i=0; i < runningCourses.size(); i++) {
            for (int y=0; y < runningCourses.get(i).getStudents().size(); y++) {
                if (runningCourses.get(i).getStudents().get(y) == pSStudents.get(n)) {
                    for (int z=0; z < runningCourses.get(i).getAssignments().size(); z++){
                        tmpass.add(runningCourses.get(i).getAssignments().get(z));
                    }
                }
                        
            }
        }
        if (!tmpass.isEmpty()) {
            System.out.println("Student " + pSStudents.get(n).getFirstName() +
                    " " + pSStudents.get(n).getLastName() + "has the following assignments:");
            System.out.println(tmpass);
        } else {
            System.out.println("Student does not have any assignments");
        }
    }
    
    public void studentsWithCourses() {
        HashSet<Student> tempstud = new HashSet();
        for (int i=0; i < runningCourses.size() - 1; i++) {
            for (int y=0; y < runningCourses.get(i).getStudents().size(); y++) {
                for (int x=i+1; x < runningCourses.size(); x++) {
                    for (int z=0; z < runningCourses.get(x).getStudents().size(); z++) {
                        if (runningCourses.get(i).getStudents().get(y) == runningCourses.get(x).getStudents().get(z)) {
                            tempstud.add(runningCourses.get(i).getStudents().get(y));
                        }
                    }
                }
            }
        }
        if (tempstud.isEmpty()) {
            System.out.println("No student with more than one course\n");
        } else {
            System.out.println("Students with more than one course:");
            System.out.println(tempstud + "\n");
        }
    }
    
    public void assignmentsDue() {
        String readLine;
        LocalDate startdate, enddate;
        
        System.out.println("Enter date [dd/mm/yyyy]:");
        readLine = sc.nextLine().trim();
        try {
            startdate=LocalDate.parse(readLine,dformat);
        } catch (DateTimeParseException e) {
            System.out.println("Improper date");
            return;
        }
        startdate=startdate.minusDays(startdate.getDayOfWeek().getValue() - 1);
        enddate=startdate.plusDays(4);
        ArrayList<Assignment> tempass = new ArrayList();
        for (int i=0; i < runningCourses.size(); i++) {
            for (int y=0; y < runningCourses.get(i).getAssignments().size(); y++) {
                if (!startdate.isAfter(runningCourses.get(i).getAssignments().get(y).getSubDateTime()) &&
                        !enddate.isBefore(runningCourses.get(i).getAssignments().get(y).getSubDateTime())) {
                    tempass.add(runningCourses.get(i).getAssignments().get(y));
                }
            }
        }
        if (tempass.isEmpty()) {
            System.out.println("No Assignments between " + startdate.format(dformat) + " and "  + enddate.format(dformat));
        } else {
            System.out.println("Assignments due between " + startdate.format(dformat) + " and "  + enddate.format(dformat));
            System.out.println(tempass);
        }
    }
    
    public void viewInfo() {
        String readLine;
        
        if (runningCourses.isEmpty()) {
            System.out.println("No running courses. Nothing to see");
            return;
        }
        do {
            System.out.println("1. Students per course");
            System.out.println("2. Trainers per course");
            System.out.println("3. Assignments per course");
            System.out.println("4. Assignments per student");
            System.out.println("5. Students with more than one course");
            System.out.println("6. Assignments due in week of specific date");
            System.out.println("Any other key to go back");
            readLine = sc.nextLine().trim();
            if (!readLine.isEmpty()) {
                switch (readLine) {
                    case "1" -> {
                        studentsPerCourse();
                    }
                    case "2" -> {
                        trainersPerCourse();
                    }
                    case "3" -> {
                        assignmentsPerCourse();
                    }
                    case "4" -> {
                        assignmentsPerStudent();
                    }
                    case "5" -> {
                        studentsWithCourses();
                    }
                    case "6" -> {
                        assignmentsDue();
                    }
                }
            } else {
                break;
            }
        } while (true);
        
    }
    
    public void ShowMenu() {
        String readLine;
        boolean enough=false;
        
        while (!enough) {
            System.out.println("1. Add/See Courses");
            System.out.println("2. Add/See Trainers");
            System.out.println("3. Add/See Students");
            System.out.println("4. Add/See Assignments");
            System.out.println("5. Add/See Active Courses");
            System.out.println("6. View info on running courses");
            System.out.println("7. Exit");
            readLine = sc.nextLine().trim();
            switch (readLine) {
                case "1" -> {
                    addCourses();
                }
                case "2" -> {
                    addTrainers();
                }
                case "3" -> {
                    addStudents();
                }
                case "4" -> {
                    addAssignments();
                }
                case "5" -> {
                    activeCourses();
                }
                case "6" -> {
                    viewInfo();
                }
                case "7" -> {
                    enough = true;
                }
                
            }
        }
    }
    
    
    public static void main(String[] args) {
        PrivSchool p1 = new PrivSchool();
        p1.ShowMenu();
    }
}

