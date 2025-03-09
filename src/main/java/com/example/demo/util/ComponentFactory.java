package com.example.demo.util;

import com.example.demo.swing.MainMenuBar;
import com.example.demo.swing.MainTabbedPane;
import com.example.demo.swing.TableView;

public class ComponentFactory {

	public static MainTabbedPane getTabbedPane() {
		return new MainTabbedPane();
	}

	public static MainMenuBar getMenuBar() {
		return new MainMenuBar();
	}

	public static TableView getTableView() {
		return new TableView(null, null);
	}
}
