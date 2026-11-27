
class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {

    Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    void display() {
        System.out.println("\nManager Details");
        super.display();
        System.out.println("Designation: Manager");
    }
}

class Developer extends Employee {

    Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    void display() {
        System.out.println("\nDeveloper Details");
        super.display();
        System.out.println("Designation: Developer");
    }
}

public class Q3_EmployeeInheritance {
    public static void main(String[] args) {

        Manager m = new Manager("Amit", 50000);
        Developer d = new Developer("Rahul", 40000);

        m.display();
        d.display();
    }
}
