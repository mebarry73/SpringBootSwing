package com.example.demo.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import org.springframework.stereotype.Controller;

import com.example.demo.model.DoctorEntry;
import com.example.demo.repository.DoctorEntryRepository;
import com.example.demo.swing.MainMenuBar;
import com.example.demo.swing.ViewPsychotherapists;
import com.example.demo.util.ComponentFactory;
import com.example.demo.util.ImportCSV;

import lombok.extern.java.Log;

/**
 * The main Swing Component.
 */
@Controller
@Log
public class BarryController extends JFrame {
	private static final long serialVersionUID = 1L;

	{
		log.info("Starting BarryController!");
	}

	private ViewPsychotherapists viewPsychotherapists = ComponentFactory.getViewPsychotherapists();

	private final DoctorEntryRepository doctorRepository;
	private final DoctorEntryController doctorEntryController;
	private MainMenuBar menuBar;

	public BarryController(DoctorEntryRepository doctorRepository, DoctorEntryController doctorEntryController) {
		super("Swing Demo for Epikur!");
		log.info("BarryController is up.");

		this.doctorRepository = doctorRepository;
		this.doctorEntryController = doctorEntryController.setCaller(this);
		this.doctorEntryController.getView().setVisible(false);

		menuBar = ComponentFactory.getMenuBar(this);
		this.add(menuBar, BorderLayout.NORTH);

		/*
		 * this.add(ComponentFactory.getTabbedPane(), BorderLayout.CENTER);
		 * this.add(doctorEntryController.getView());
		 */
		this.add(viewPsychotherapists);

		this.setPreferredSize(new Dimension(600, 500));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		String actionCommand = event.getActionCommand();
		log.info("actionPerformed " + actionCommand);

		viewPsychotherapists.setVisible(false);
		if ("Read Person CSV".equals(actionCommand)) {
			ImportCSV instance = ImportCSV.getInstance();
			try {
				instance.importPersons();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else if ("View Doctor".equals(actionCommand)) {
			viewPsychotherapists.setDoctors(doctorRepository.findAll().toArray());
			viewPsychotherapists.setVisible(true);
		} else if ("View Doctor with Fi".equals(actionCommand)) {
			List<DoctorEntry> filtered = doctorRepository.findAll().stream().filter(c -> c.getName().contains("Fi"))
					.collect(Collectors.toList());
			viewPsychotherapists.setDoctors(filtered.toArray());
			viewPsychotherapists.setVisible(true);
		}
	}

	@Override
	public void validate() {
		super.validate();
	}
}
