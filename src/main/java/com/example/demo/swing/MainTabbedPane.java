package com.example.demo.swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.example.demo.util.Constants;

public class MainTabbedPane extends JTabbedPane {
	private static final long serialVersionUID = 1L;


	public MainTabbedPane() {
		super();
		this.setPreferredSize(new Dimension(600, 500));

		addTab(Constants.PERSON, makePanel(Constants.PERSON));
		addTab(Constants.DOCTOR, makePanel(Constants.DOCTOR));

		this.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				processTabChange();
			}
		});

	}

	private void processTabChange() {
		Component c = this.getSelectedComponent();
		System.err.println("## " + c.getName());

	}

	private JComponent makePanel(String txt) {
		JComponent panel = new JPanel(new GridLayout(1, 1));
		panel.setName(txt);
		JLabel label = new JLabel(txt);
		panel.add(label);
		return panel;
	}
}
