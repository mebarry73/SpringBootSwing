package com.example.demo.util;

import com.example.demo.controller.BarryController;
import com.example.demo.fhir.FhirClient;
import com.example.demo.swing.MainMenuBar;
import com.example.demo.swing.MainTabbedPane;
import com.example.demo.swing.TableView;
import com.example.demo.swing.ViewPsychotherapists;

import ca.uhn.fhir.rest.client.api.IGenericClient;

public class ComponentFactory {

	public static MainTabbedPane getTabbedPane() {
		return new MainTabbedPane();
	}

	public static MainMenuBar getMenuBar(BarryController barryController) {
		return new MainMenuBar(barryController);
	}

	public static TableView getTableView() {
		return new TableView(null, null);
	}
	
	public static ViewPsychotherapists getViewPsychotherapists()
	{
		return new ViewPsychotherapists();
	}
	
	public static FhirClient createClient()
	{
		return FhirClient.getInstance();
	}	
}