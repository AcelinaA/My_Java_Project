import java.util.Scanner;

public class LabActivity2EmployeeInformationSystemPart2 {
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

        // Subtract the user_age by 65 (Common retirement age)
        int retirementAge = Math.abs(65 - user_age);

        // multiply the daily salary by 5 to get weekly salary
        double weeklySalary = dailySalary * 5;

        // multiply the weeklySalary by 4 to get monthly salary
        double monthlySalary =  weeklySalary * 4;

        // multiply the month salary by 12 to get gross yearly wage
        double grossYearlyWage =  monthlySalary * 12;

        // Subtract gross with tax and benefits to get net yearly.
        double taxRate = 0.32;
        double netYearlyWage = grossYearlyWage - (grossYearlyWage * taxRate) - 1500;



        // Output
        System.out.println("\n            Employee Information");
        System.out.println("--------------------------------------------");
        System.out.println("Full Name             : " + firstName + " " + lastName);
        System.out.println("Age                   : " + user_age + " years old");
        System.out.println("Years to Retirement   : " + retirementAge + " years old");
        System.out.printf("Daily Salary          : PHP %.2f\n", dailySalary);
        System.out.printf("Weekly Salary         : PHP %.2f\n", weeklySalary);
        System.out.printf("Monthly Salary        : PHP %.2f\n", monthlySalary);
        System.out.printf("Gross Yearly Wage     : PHP %.2f\n", grossYearlyWage);
        System.out.printf("Net Yearly Wage       : PHP %.2f\n", netYearlyWage);

        scanner.close();
    }
}
