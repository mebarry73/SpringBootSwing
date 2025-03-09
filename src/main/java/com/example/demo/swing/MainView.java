package com.example.demo.swing;

import javax.swing.*;

import com.example.demo.model.PersonEntry;

import java.awt.*;

public abstract class MainView {
    private JPanel mainPanel;
    private JList personList;
    private JButton newEntryButton;
    private JButton viewEntryButton;

    {
    	create();
    }
    
    
    protected abstract  void newEntryButtonClicked();

    protected abstract  void viewEntryButtonClicked();

    public Object getSelectedEntry() {
        return personList.getSelectedValue();
    }

    @SuppressWarnings("unchecked")
    public void setJournalEntryListContent(Object[] objects) {
    	personList.setListData(objects);
    }

    protected MainView() {
        newEntryButton.addActionListener(event -> newEntryButtonClicked());
        viewEntryButton.addActionListener(event -> viewEntryButtonClicked());
    }


    private void create() {
        mainPanel = new JPanel();
        
        
        //mainPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setMinimumSize(new Dimension(420, 420));
        mainPanel.setPreferredSize(new Dimension(420, 420));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Ugly Journal"));
        personList = new JList();
        mainPanel.add(personList);
        //mainPanel.add(personList, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel1 = new JPanel();
        //panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        //mainPanel.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        mainPanel.add(panel1);
        newEntryButton = new JButton();
        newEntryButton.setText("New Entry");
        panel1.add(newEntryButton);
        viewEntryButton = new JButton();
        viewEntryButton.setText("View Entry");
        panel1.add(viewEntryButton);
    }

    
    public JComponent getRootComponent() {
        return mainPanel;
    }
    
    
}
