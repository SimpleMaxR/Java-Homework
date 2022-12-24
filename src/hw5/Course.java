package hw5;

public class Course {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                students[i] = students[numberOfStudents - 1];
                numberOfStudents--;
                break;
            }
        }
    }
    public String[] clone(){
        // deep copy
        String[] result = new String[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            result[i] = students[i];
        }
        return result;
    }
}
