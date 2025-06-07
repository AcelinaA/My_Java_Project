import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT extends Frame implements ActionListener {
    // Data
    String[] questions = {
            "What does CPU stand for?",
            "Which device is used to input data into a computer?",
            "Which language is primarily used for web development?"
    };
    String[][] options = {
            {"A. Central Processing Unit", "B. Computer Personal Unit", "C. Central Print Unit", "D. Control Processing Unit"},
            {"A. Monitor", "B. Keyboard", "C. Printer", "D. Speaker"},
            {"A. Python", "B. Java", "C. HTML", "D. C++"}
    };
    int[] answers = {0, 1, 2}; // Indexes of correct answers

    // UI Components
    Label questionLabel;
    CheckboxGroup choicesGroup;
    Checkbox[] choices;
    Checkbox hiddenReset;
    Button nextButton;
    Label errorLabel;
    int current = 0, score = 0;

    public LabActivity5QuizAppAWT() {
        setTitle("Quiz App");
        setSize(500, 300);
        setLayout(new BorderLayout());
        setResizable(false);

        // Question label
        questionLabel = new Label();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setAlignment(Label.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        // Choices panel
        Panel choicesPanel = new Panel(new GridLayout(2, 2, 40, 20));
        choicesGroup = new CheckboxGroup();
        choices = new Checkbox[4];
        for (int i = 0; i < 4; i++) {
            choices[i] = new Checkbox("", choicesGroup, false);
            choices[i].setForeground(Color.BLUE); // Customization 1
            choices[i].setFont(new Font("Arial", Font.PLAIN, 14));
            choicesPanel.add(choices[i]);
        }
        add(choicesPanel, BorderLayout.CENTER);

        // reset checkbox
        hiddenReset = new Checkbox("", choicesGroup, true);
        hiddenReset.setVisible(false);

        // Error label
        errorLabel = new Label("");
        errorLabel.setAlignment(Label.CENTER);
        errorLabel.setForeground(Color.RED);

        // Next button
        nextButton = new Button("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16)); // Customization 2
        nextButton.setBackground(Color.lightGray); // Customization 2
        nextButton.addActionListener(this);

        // Bottom panel for error label and button
        Panel bottomPanel = new Panel(new GridLayout(2, 1));
        bottomPanel.add(errorLabel);
        bottomPanel.add(nextButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Window close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        loadQuestion();
        setVisible(true);
    }

    void loadQuestion() {
        questionLabel.setText(questions[current]);
        // Reset selection
        hiddenReset.setState(true);
        for (int i = 0; i < 4; i++) {
            choices[i].setLabel(options[current][i]);
            choices[i].setState(false);
            choices[i].setEnabled(true);
        }
        nextButton.setEnabled(true);
        errorLabel.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        int selected = -1;
        for (int i = 0; i < 4; i++) {
            if (choices[i].getState()) {
                selected = i;
                break;
            }
        }
        if (selected == -1) {
            errorLabel.setText("Please select an answer.");
            return;
        } else {
            errorLabel.setText("");
        }
        if (selected == answers[current]) score++;

        current++;
        if (current < questions.length) {
            loadQuestion();
        } else {
            questionLabel.setText("Quiz Completed! Your Score: " + score + " out of " + questions.length + " correct!");
            for (Checkbox cb : choices) cb.setEnabled(false);
            nextButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new LabActivity5QuizAppAWT();
    }
}
