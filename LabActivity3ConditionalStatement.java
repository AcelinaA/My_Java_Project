import java.util.Scanner;

public class LabActivity3ConditionalStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inputs to ask user
        System.out.print("Enter your first name: "); // Ask for First Name
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: "); // Ask for Last Name
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: "); // Ask for Age
        int user_age = scanner.nextInt();

        if (user_age < 18 ) // Determine if the user is above the age of 18
        {
            System.out.println("\nMinors are not allowed"); // Output process if the age of the user is below 17
            return; // Terminare the program
        }
        else if (user_age >= 65) // Determine if the user is above or equal to the age of 65
        {
            System.out.println("\nSenior Citizens are not allowed"); // Output if the user is above or equal to the age of 65
            return; // Terminate the program
        }

        System.out.print("Enter hours worked: "); // Ask for Hours Worked
        double hoursWorked = scanner.nextDouble();

        if (hoursWorked > 24) // Determine that time cannot exceed 24 hours
        {
            System.out.println("\nNumber of hours worked cannot exceed 24 hours"); // Output if time is more than 24 hours
            return; // Terminate the program
        }
        else if (hoursWorked <= 0) // Determine if the number or any value is incorrect
        {
            System.out.println("\nWrong input on daily work hours"); // Output if the user input 0 and incorrect values
            return; // Terminate the program
        }

        System.out.print("Enter hourly wage: "); // Ask for Hourly Wage
        double hourlyWage = scanner.nextDouble();

        System.out.print("Enter role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): ");
        int job_role = scanner.nextInt();

        // using string role to make the print in // Output
        String role = switch (job_role) // Determine what job role the user choose
        {
            case 1 -> "Manager";
            case 2 -> "Supervisor";
            case 3 -> "Staff";
            case 4 -> "Intern";
            default -> "Undefined";
        };


        // Calculate daily salary
        double dailySalary = hoursWorked * hourlyWage;

        // Subtract the user_age by 65 (Common retirement age)
        int retirementAge = Math.abs(user_age - 65);

        // multiply the daily salary by 5 to get weekly salary
        double weeklySalary = dailySalary * 5;

        // multiply the weeklySalary by 4 to get monthly salary
        double monthlySalary =  weeklySalary * 4;

        // multiply the month salary by 12 to get gross yearly wage
        double grossYearlyWage =  monthlySalary * 12;

        double taxRate = 0.32;
        double governmentMandatedBenefits = 1500;
        double netYearlyWage;

        if (grossYearlyWage > 250000) // if the user yearly salary is above the amount do it with tax rate
        {
            netYearlyWage = grossYearlyWage - (grossYearlyWage * taxRate) - governmentMandatedBenefits;
        }
        else // if the user yearly salary is below the amount, only government mandated benefits
        {
            netYearlyWage = grossYearlyWage - governmentMandatedBenefits;
        }


        // Output
        System.out.println("\n            Employee Information");
        System.out.println("--------------------------------------------");
        System.out.println("Full Name             : " + firstName + " " + lastName);
        System.out.println("Age                   : " + user_age + " years old");
        System.out.println("Position              : " + role);
        System.out.println("Years to Retirement   : " + retirementAge + " years old");
        System.out.printf("Daily Salary          : PHP %.2f\n", dailySalary);
        System.out.printf("Weekly Salary         : PHP %.2f\n", weeklySalary);
        System.out.printf("Monthly Salary        : PHP %.2f\n", monthlySalary);
        System.out.printf("Gross Yearly Wage     : PHP %.2f\n", grossYearlyWage);
        System.out.printf("Net Yearly Wage       : PHP %.2f\n", netYearlyWage);

        scanner.close();

    }
}