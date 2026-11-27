
package college;

public class Student {
    public String name;
    private int rollNo;
    protected String course;
    String collegeName;

    public Student(String name, int rollNo,
                   String course, String collegeName) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
        this.collegeName = collegeName;
    }

    public void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Course: " + course);
        System.out.println("College: " + collegeName);
    }
}
