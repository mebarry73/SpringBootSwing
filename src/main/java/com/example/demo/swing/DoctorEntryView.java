package com.example.demo.swing;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public abstract class DoctorEntryView extends JPanel {
	private static final long serialVersionUID = 1L;

	public JTextArea getLicenseEntry() {
		return licenseEntry;
	}

	public void setLicenseEntry(JTextArea licenseEntry) {
		this.licenseEntry = licenseEntry;
	}

	public JTextArea getNameEntry() {
		return nameEntry;
	}

	public void setNameEntry(JTextArea nameEntry) {
		this.nameEntry = nameEntry;
	}

	private JTextArea licenseEntry;
	private JTextArea nameEntry;
	private JButton actionButton;

	protected abstract void actionButtonClicked();

	public void viewMode() {
		licenseEntry.setEditable(false);
		nameEntry.setEditable(false);
		actionButton.setText("Close");
	}

	public void writeMode() {
		licenseEntry.setEditable(true);
		nameEntry.setEditable(true);
		actionButton.setText("Save");
	}

	public DoctorEntryView() {
		super(true);
		
		setPreferredSize(new Dimension(500, 450));
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Psychotherapist"));
		licenseEntry = new JTextArea();
		add(licenseEntry);
		add(new JPanel());
		nameEntry = new JTextArea();
		add(nameEntry);
		add(new JPanel());
		actionButton = new JButton();
		actionButton.setText("Button");
		add(actionButton);
		
		actionButton.addActionListener(e -> actionButtonClicked());		
	}
}