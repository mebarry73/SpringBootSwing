package com.example.demo.swing;

import javax.swing.*;
import java.awt.*;

/**
 * This view is for displaying or writing a Journal Entry.  Just a simple JTextArea with an action button for either
 * saving the record or closing the view.
 */
public abstract class PersonEntryView {
    private JPanel entryPanel;
    private JTextArea personEntry;
    private JButton actionButton;

    protected PersonEntryView() {
        actionButton.addActionListener(e -> actionButtonClicked());
    }

    protected abstract void actionButtonClicked();

    public void setText(String text) {
        personEntry.setText(text);
    }

    public String getText() {
        return personEntry.getText();
    }

    /**
     * Enable View Mode, which just makes the JTextArea non-editable and sets the text of the Action Button to "Close."
     */
    public void viewMode() {
        personEntry.setEditable(false);
        actionButton.setText("Close");
    }

    public void writeMode() {
        personEntry.setEditable(true);
        actionButton.setText("Save");
    }

    {
        create();
    }

    private void create() {
        entryPanel = new JPanel();
        //entryPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        entryPanel.setPreferredSize(new Dimension(500, 450));
        entryPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Ugly Journal Entry"));
        personEntry = new JTextArea();
        //entryPanel.add(personEntry, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        entryPanel.add(personEntry);
        final JPanel panel1 = new JPanel();
        //panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        //entryPanel.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        entryPanel.add(panel1);
        actionButton = new JButton();
        actionButton.setText("Button");
        //panel1.add(actionButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel1.add(actionButton);
    }

    public JComponent getRootComponent() {
        return entryPanel;
    }
}
