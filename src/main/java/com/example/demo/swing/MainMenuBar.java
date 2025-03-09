package com.example.demo.swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.example.demo.util.Constants;

public class MainMenuBar extends JMenuBar implements ActionListener {
	private static final long serialVersionUID = 1L;

	public MainMenuBar() {
		super();
		
		JMenuBar menuBar = new JMenuBar();
		
		add(Constants.PERSON, makePersonMenu(Constants.PERSON, KeyEvent.VK_P));
		add(Constants.DOCTOR, makeDoctorMenu(Constants.DOCTOR, KeyEvent.VK_D));
		
	}

	private JMenu makeDoctorMenu(String doctor, int keyEvent) {
		JMenu menu = makeMenu(doctor, keyEvent);
		JMenuItem jMenuItem = new JMenuItem(Constants.VIEW_DOCTOR);
		jMenuItem.addActionListener(this);		
		menu.add(jMenuItem);
		
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
		
        /*
		JComponent panel = new JPanel(new GridLayout(1, 1));
		panel.setName(txt);
		JLabel label = new JLabel(txt);
		panel.add(label);
		return panel;
		*/
        
        return menu;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.err.println(event.getActionCommand());
	}
	
	private void setCtrlAccelerator(JMenuItem mi, char acc)
	{
	     KeyStroke ks = KeyStroke.getKeyStroke(
	       acc
	     );
	     mi.setAccelerator(ks);
	   }
}
