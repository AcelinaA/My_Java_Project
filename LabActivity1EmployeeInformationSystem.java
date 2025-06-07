import java.util.Scanner;

public class LabActivity1EmployeeInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inputs to ask user
        System.out.print("Enter your first name: "); // Ask for First Name
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: "); // Ask for Last Name
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: "); // Ask for Age
        int user_age = scanner.nextInt();

        System.out.print("Enter hours worked: "); // Ask for Hours Worked
        double hoursWorked = scanner.nextDouble();

        System.out.print("Enter hourly wage: "); // Ask for Hourly Wage
        double hourlyWage = scanner.nextDouble();

        // Calculate daily salary
        double dailySalary = hoursWorked * hourlyWage;

        // Output
        System.out.println("\nEmployee Information");
        System.out.println("--------------------");
        System.out.println("Full Name   : " + firstName + " " + lastName);
        System.out.println("Age         : " + user_age + " years old");
        System.out.printf("Daily Salary: PHP %.2f\n", dailySalary);

    }
}
