package com.example.demo.swing;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableView extends JTable {
	private static final long serialVersionUID = 1L;

	public TableView(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		JScrollPane scroll = new JScrollPane();
		add(scroll);
		setVisible(true);
	}
}
