import java.awt.*;
import java.awt.event.*;

public class LabActivity4EmpInfoSystemGUI extends Frame {
    TextField firstNameField, lastNameField, ageField, hoursWorkedInDAYField, dailyWageField;
    TextArea resultArea;

    public LabActivity4EmpInfoSystemGUI() {
        setTitle("Laboratory Activity 4");
        setSize(500, 500);
        setLayout(new BorderLayout(10, 10));

        // Panel for layout
        Panel Panel = new Panel(new GridLayout(5, 2, 5, 5));

        Panel.add(new Label("First Name:"));
        firstNameField = new TextField();
        Panel.add(firstNameField);

        Panel.add(new Label("Last Name:"));
        lastNameField = new TextField();
        Panel.add(lastNameField);

        Panel.add(new Label("Age:"));
        ageField = new TextField();
        Panel.add(ageField);

        Panel.add(new Label("Hours Worked:"));
        hoursWorkedInDAYField = new TextField();
        Panel.add(hoursWorkedInDAYField);

        Panel.add(new Label("Hourly Rate:"));
        dailyWageField = new TextField();
        Panel.add(dailyWageField);

        // Add form to frame
        add(Panel, BorderLayout.NORTH);

        // Panel for button and output
        Panel centerPanel = new Panel(new BorderLayout());

        // Submit button (smaller)
        Button submitButton = new Button("Submit");
        Panel buttonPanel = new Panel();

        buttonPanel.add(submitButton); // small button in center
        centerPanel.add(buttonPanel, BorderLayout.NORTH);

        // Output area
        resultArea = new TextArea("Output:", 3, 20  , TextArea.SCROLLBARS_VERTICAL_ONLY);
        resultArea.setEditable(false);
        centerPanel.add(resultArea, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // Button action
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get values from text fields
                    String firstName = firstNameField.getText().trim();
                    String lastName = lastNameField.getText().trim();
                    String ageText = ageField.getText().trim();
                    String hoursWorkedInDAYText = hoursWorkedInDAYField.getText().trim();
                    String dailyWageText = dailyWageField.getText().trim();

                    // Check if any required field is empty
                    if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || hoursWorkedInDAYText.isEmpty() || dailyWageText.isEmpty()) {
                        resultArea.setText("Error: All fields must be filled out.");
                        return;
                    }

                    // Specific number validations
                    if (!ageText.matches("\\d+")) {
                        resultArea.setText("Error: Age must be a valid integer.");
                        return;
                    }
                    if (!hoursWorkedInDAYText.matches("\\d+(\\.\\d+)?") || !dailyWageText.matches("\\d+(\\.\\d+)?")) {
                        resultArea.setText("Error: Hourly worked and hourly rate must be valid numbers.");
                        return;
                    }

                    // Parse numbers after validation
                    int age = Integer.parseInt(ageText);
                    double hoursWorkedInDay = Double.parseDouble(hoursWorkedInDAYText);
                    double hourlyWage = Double.parseDouble(dailyWageText);

                    // Calculate and show result
                    double dailySalary = hoursWorkedInDay * hourlyWage;
                    String fullName = firstName + " " + lastName;

                    resultArea.setText("Full Name: " + fullName +
                            "\nAge: " + age + " years old" +
                            "\nDaily Salary: PHP " + String.format("%.2f", dailySalary));
                }
                catch (Exception ex) {
                    resultArea.setText("Unexpected error occurred.");
                }


            }
        });

        // Close window handlerx
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        // Center the window on screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LabActivity4EmpInfoSystemGUI();
    }
}

