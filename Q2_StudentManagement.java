
class Student {
    int rollNo;
    String name;
    int[] marks;
    static String college = "MAW University";

    Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    int calculateTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    double calculatePercentage() {
        return calculateTotal() / (double) marks.length;
    }

    // Method Overloading
    void display() {
        display("Student Result");
    }

    void display(String title) {
        System.out.println("\n" + title);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("College: " + college);
        System.out.println("Total: " + calculateTotal());
        System.out.println("Percentage: " + calculatePercentage() + "%");
    }
}

public class Q2_StudentManagement {
    public static void main(String[] args) {

        int[] marks = {80, 75, 90, 85, 70};

        Student s1 = new Student(101, "Rahul", marks);

        s1.display();
    }
}
