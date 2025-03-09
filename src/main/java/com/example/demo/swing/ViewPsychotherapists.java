package com.example.demo.swing;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class ViewPsychotherapists extends JPanel {
	private static final long serialVersionUID = 1L;

	private JList<Object> personList;

	public Object getSelectedEntry() {
		return personList.getSelectedValue();
	}

	public void setDoctors(Object[] objects) {
		personList.setListData(objects);
	}

	public ViewPsychotherapists() {
		super();
		setPreferredSize(new Dimension(420, 420));
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Show me the Psychotherapists!"));
		personList = new JList<Object>();
		add(personList);
		add(new JPanel());
		setVisible(false);
	}
}
