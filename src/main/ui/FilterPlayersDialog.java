package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// The FilterPlayersDialog class is a dialog for filtering players by position
public class FilterPlayersDialog extends JDialog {
    private JTextField positionField;
    private String position;

    // EFFECTS: constructs a new FilterPlayersDialog and initializes components
    public FilterPlayersDialog(JFrame parent) {
        super(parent, "Filter Players by Position", true);
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Position:"));
        positionField = new JTextField();
        add(positionField);

        JButton filterButton = new JButton("Filter");
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                position = positionField.getText();
                setVisible(false);
            }
        });
        add(filterButton);

        setSize(300, 100);
        setLocationRelativeTo(parent);
    }

    // EFFECTS: returns the position entered by the user
    public String getPosition() {
        return position;
    }
}
