import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;
    String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public void display() {
        System.out.println("Employee ID : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Salary      : " + salary);
        System.out.println("Department  : " + department);
        System.out.println("---------------------------");
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee[] emp = new Employee[100];
        int count = 0;

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    emp[count] = new Employee(id, name, salary, dept);
                    count++;

                    System.out.println("Employee Added Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;

                    for (int i = 0; i < count; i++) {
                        if (emp[i] != null && emp[i].id == uid) {

                            System.out.print("Enter New Name: ");
                            emp[i].name = sc.nextLine();

                            System.out.print("Enter New Salary: ");
                            emp[i].salary = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Enter New Department: ");
                            emp[i].department = sc.nextLine();

                            updated = true;
                            System.out.println("Employee Updated Successfully.");
                            break;
                        }
                    }

                    if (!updated)
                        System.out.println("Employee Not Found.");

                    break;

                case 3:
                    System.out.print("Enter Employee ID to Delete: ");
                    int did = sc.nextInt();

                    boolean deleted = false;

                    for (int i = 0; i < count; i++) {
                        if (emp[i] != null && emp[i].id == did) {

                            for (int j = i; j < count - 1; j++) {
                                emp[j] = emp[j + 1];
                            }

                            emp[count - 1] = null;
                            count--;

                            deleted = true;
                            System.out.println("Employee Deleted Successfully.");
                            break;
                        }
                    }

                    if (!deleted)
                        System.out.println("Employee Not Found.");

                    break;

                case 4:
                    System.out.print("Enter Employee ID to Search: ");
                    int sid = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (emp[i] != null && emp[i].id == sid) {
                            emp[i].display();
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Employee Not Found.");

                    break;

                case 5:
                    if (count == 0) {
                        System.out.println("No Employees Available.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            emp[i].display();
                        }
                    }
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
