import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LabActivity6SwingToDoList extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addTaskButton;
    private ToDoListForm formWindow = null;

    public LabActivity6SwingToDoList() {
        setTitle("To-Do List Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.PINK);

        // Table setup
        String[] columns = {"Task Name", "Task Description", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.PINK);
        add(scrollPane, BorderLayout.CENTER);

        // Add Task button
        addTaskButton = new JButton("Add Task");
        addTaskButton.setBackground(Color.PINK);
        addTaskButton.addActionListener(e -> openForm());
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.PINK);
        topPanel.add(addTaskButton);
        add(topPanel, BorderLayout.NORTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void openForm() {
        if (formWindow == null || !formWindow.isDisplayable()) {
            formWindow = new ToDoListForm(this);
        } else {
            formWindow.toFront();
        }
    }

    public void addTask(String name, String desc, String status) {
        tableModel.addRow(new Object[]{name, desc, status});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LabActivity6SwingToDoList::new);
    }
}

// Inner class for the form window
class ToDoListForm extends JFrame {
    private JTextField nameField;
    private JTextArea descArea;
    private JComboBox<String> statusBox;
    private JButton saveButton;
    private LabActivity6SwingToDoList parent;

    public ToDoListForm(LabActivity6SwingToDoList parent) {
        this.parent = parent;
        setTitle("Add New Task");
        setSize(350, 260);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.PINK);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

        JLabel nameLabel = new JLabel("Task Name:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameField = new JTextField(16);
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descLabel = new JLabel("Task Description:");
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        descArea = new JTextArea(3, 16);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        JScrollPane descScroll = new JScrollPane(descArea);
        descScroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        descScroll.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusBox = new JComboBox<>(new String[]{"Not Started", "Ongoing", "Completed"});
        statusBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        statusBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        saveButton = new JButton("Save Task");
        saveButton.setBackground(Color.PINK);
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveButton.addActionListener(e -> saveTask());

        // Add components vertically and center them
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(Box.createVerticalStrut(8));
        mainPanel.add(descLabel);
        mainPanel.add(descScroll);
        mainPanel.add(Box.createVerticalStrut(8));
        mainPanel.add(statusLabel);
        mainPanel.add(statusBox);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(saveButton);

        setContentPane(mainPanel);
        setVisible(true);
    }

    private void saveTask() {
        String name = nameField.getText().trim();
        String desc = descArea.getText().trim();
        String status = (String) statusBox.getSelectedItem();

        if (name.isEmpty() || status == null || status.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in Task Name and Status.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        parent.addTask(name, desc, status);
        dispose();
    }
}