
import java.sql.*;
import java.util.Scanner;

public class Q10_JDBCCrud {

    static final String URL =
        "jdbc:mysql://localhost:3306/college_db";

    static final String USER = "root";
    static final String PASS = "your_password";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                URL, USER, PASS
            );

            int choice;

            do {
                System.out.println("\n--- Student CRUD Menu ---");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        int marks = sc.nextInt();

                        String insert =
                            "INSERT INTO Student(name, marks) VALUES (?, ?)";

                        PreparedStatement ps1 =
                            con.prepareStatement(insert);

                        ps1.setString(1, name);
                        ps1.setInt(2, marks);

                        int r1 = ps1.executeUpdate();
                        System.out.println(r1 + " row inserted.");

                        ps1.close();
                        break;

                    case 2:
                        String select = "SELECT * FROM Student";

                        PreparedStatement ps2 =
                            con.prepareStatement(select);

                        ResultSet rs = ps2.executeQuery();

                        System.out.println("\nStudent Records:");

                        while (rs.next()) {
                            System.out.println(
                                "ID: " + rs.getInt("id")
                            );
                            System.out.println(
                                "Name: " + rs.getString("name")
                            );
                            System.out.println(
                                "Marks: " + rs.getInt("marks")
                            );
                            System.out.println("----------------");
                        }

                        rs.close();
                        ps2.close();
                        break;

                    case 3:
                        System.out.print("Enter Student ID: ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Marks: ");
                        int newMarks = sc.nextInt();

                        String update =
                            "UPDATE Student SET marks=? WHERE id=?";

                        PreparedStatement ps3 =
                            con.prepareStatement(update);

                        ps3.setInt(1, newMarks);
                        ps3.setInt(2, updateId);

                        int r3 = ps3.executeUpdate();
                        System.out.println(r3 + " row updated.");

                        ps3.close();
                        break;

                    case 4:
                        System.out.print("Enter Student ID: ");
                        int deleteId = sc.nextInt();

                        String delete =
                            "DELETE FROM Student WHERE id=?";

                        PreparedStatement ps4 =
                            con.prepareStatement(delete);

                        ps4.setInt(1, deleteId);

                        int r4 = ps4.executeUpdate();
                        System.out.println(r4 + " row deleted.");

                        ps4.close();
                        break;

                    case 5:
                        System.out.println("Thank You!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 5);

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}
