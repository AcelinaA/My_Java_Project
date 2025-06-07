import java.util.Scanner;


class Ticket {
    String description;
    String urgency;
    String status;

    // Creates a new ticket with description, urgency and status is default as pending
    Ticket(String description, String urgency) {
        this.description = description;
        this.urgency = urgency;
        this.status = "Pending";
    }
}

public class MyMidtermLabExam {
    static Ticket[] tickets = new Ticket[5];  // Max is up to 5 tickets
    static int ticketCount = 0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Display the Main Menu
        do {
            System.out.println("--- IT Ticket System ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Update Ticket Status");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            // Uses switch-case to handle choices
            switch (choice) {
                case 1:
                    addTicket(scanner);
                    break;
                case 2:
                    updateTicketStatus(scanner);
                    break;
                case 3:
                    showTickets();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

            System.out.println();
        } while (choice != 5);
    }

    // Add a new ticket, up to 5 tickets
    public static void addTicket(Scanner scanner) {
        if (ticketCount >= 5) {
            System.out.println("Maximum number of tickets reached.");
            return;
        }

        System.out.print("Enter issue description: ");
        String description = scanner.nextLine();
        System.out.print("Enter urgency level (Low / Medium / High): ");
        String urgency = scanner.nextLine();

        tickets[ticketCount] = new Ticket(description, urgency);
        ticketCount++;
        System.out.println("Ticket successfully added!");
    }

    // Update the status of a ticket
    public static void updateTicketStatus(Scanner scanner) {
        if (ticketCount == 0) {
            System.out.println("No tickets to update.");
            return;
        }

        showTickets();  // Show existing tickets so user can choose one
        System.out.print("Enter ticket number to update: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        // Validate ticket number
        if (num < 1 || num > ticketCount) {
            System.out.println("Invalid ticket number.");
            return;
        }

        Ticket currentTicket = tickets[num - 1];

        // Only allow updating to "Pending" or "In Progress" tickets
        if (currentTicket.status.equals("Resolved")) {
            System.out.println("This ticket is already resolved and cannot be updated.");
            return;
        }

        System.out.print("Enter new status (In Progress / Resolved): ");
        String newStatus = scanner.nextLine();

        // Update to "In Progress" or "Resolved"
        if (newStatus.equalsIgnoreCase("in progress")) {
            currentTicket.status = "In Progress";
            System.out.println("Ticket status updated.");
        } else if (newStatus.equalsIgnoreCase("resolved")) {
            currentTicket.status = "Resolved";
            System.out.println("Ticket status updated.");
        } else {
            System.out.println("Invalid status. Please enter 'In Progress' or 'Resolved' only.");
        }
    }

    //Display all stored tickets
    public static void showTickets() {
        if (ticketCount == 0) {
            System.out.println("No tickets available.");
            return;
        }

        System.out.println("--- ALL TICKETS ---");
        for (int i = 0; i < ticketCount; i++) {
            Ticket currentTicket = tickets[i];
            System.out.println((i + 1) + ". [" + currentTicket.urgency + "] " +
                    currentTicket.description + " - Status: " + currentTicket.status);
        }
    }


    // Generate a summary report of tickets
    public static void generateReport() {
        if (ticketCount == 0) {
            System.out.println("No tickets available for report.");
            return;
        }

        int pendingCount = 0;
        int resolvedCount = 0;

        // Count pending/in-progress vs resolved
        for (int i = 0; i < ticketCount; i++) {
            Ticket t = tickets[i];
            if (t.status.equals("Pending") || t.status.equals("In Progress")) {
                pendingCount++;
            } else if (t.status.equals("Resolved")) {
                resolvedCount++;
            }
        }

        System.out.println("--- Ticket Report ---");
        System.out.println("Total Tickets: " + ticketCount);
        System.out.println("Pending/In Progress Tickets: " + pendingCount);
        System.out.println("Resolved Tickets: " + resolvedCount);
    }
}
