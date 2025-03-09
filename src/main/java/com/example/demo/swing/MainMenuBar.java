package com.example.demo.swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.example.demo.controller.BarryController;
import com.example.demo.util.Constants;

import lombok.extern.java.Log;

@Log
public class MainMenuBar extends JMenuBar implements ActionListener {
	private static final long serialVersionUID = 1L;
	private BarryController parent;

	public MainMenuBar(BarryController barryController) {
		super();
		this.parent = barryController;
		add(Constants.PERSON, makePersonMenu(Constants.PERSON, KeyEvent.VK_P));
		add(Constants.DOCTOR, makeDoctorMenu(Constants.DOCTOR, KeyEvent.VK_D));
	}

	private JMenu makeDoctorMenu(String doctor, int keyEvent) {
		JMenu menu = makeMenu(doctor, keyEvent);
		JMenuItem jMenuItem = new JMenuItem(Constants.VIEW_DOCTOR);
		jMenuItem.addActionListener(this);
		menu.add(jMenuItem);
		JMenuItem jMenuItemFi = new JMenuItem(Constants.VIEW_DOCTOR_FI);
		jMenuItemFi.addActionListener(this);
		menu.add(jMenuItemFi);
		return menu;
	}

	private JMenu makePersonMenu(String person, int keyEvent) {
		JMenu menu = makeMenu(person, keyEvent);
		JMenuItem jMenuItemRead = new JMenuItem(Constants.READ_PERSON_CSV);
		jMenuItemRead.addActionListener(this);
		menu.add(jMenuItemRead);
		JMenuItem jMenuItemView = new JMenuItem(Constants.VIEW_PERSON);
		jMenuItemView.addActionListener(this);
		menu.add(jMenuItemView);
		JMenuItem jMenuItemNew = new JMenuItem(Constants.NEW_PERSON);
		jMenuItemNew.addActionListener(this);
		menu.add(jMenuItemNew);
		return menu;
	}

	private JMenu makeMenu(String txt, int keyEvent) {
		JMenu menu = new JMenu(txt);
		menu.setMnemonic(keyEvent);
		menu.getAccessibleContext().setAccessibleDescription(txt);
		return menu;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		log.info("actionPerformed " + event.getActionCommand());
		parent.actionPerformed(event);
	}
}
