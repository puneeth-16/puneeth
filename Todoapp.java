import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Todoapp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JButton addButton, deleteButton;

    public Todoapp() {
        setTitle("To-Do List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.CENTER);

        
        JPanel inputPanel = new JPanel(new BorderLayout());
        taskField = new JTextField();
        addButton = new JButton("Add");

        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.NORTH);

        deleteButton = new JButton("Delete Selected Task");
        add(deleteButton, BorderLayout.SOUTH);

       
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteSelectedTask());

        taskField.addActionListener(e -> addTask());

        setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            taskField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a task.");
        }
    }

    private void deleteSelectedTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Todoapp());
    }
}
