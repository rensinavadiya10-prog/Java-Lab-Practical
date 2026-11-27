
import college.Student;

public class TestPackage {
    public static void main(String[] args) {

        Student s = new Student(
            "Rahul", 101, "BCA", "MAW University"
        );

        s.display();

        // Public variable can be accessed outside package
        System.out.println("Name: " + s.name);

        // Private, protected and default members
        // cannot be directly accessed here.
    }
}


