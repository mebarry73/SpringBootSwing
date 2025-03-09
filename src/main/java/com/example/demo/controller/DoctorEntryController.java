package com.example.demo.controller;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import com.example.demo.model.DoctorEntry;
import com.example.demo.repository.DoctorEntryRepository;
import com.example.demo.swing.DoctorEntryView;

/**
 * not used but later could be used to view single Psychotherapist (add, modify, delete)
 */
@Component
public class DoctorEntryController {    
	private final DoctorEntryView view;
	private final DoctorEntryRepository repository;
    private DoctorEntry model;
    private JFrame caller;

    public DoctorEntryController(DoctorEntryRepository doctorEntryRepository) {
        //super("Selected Doctor");
        this.repository = doctorEntryRepository;
        this.view = new DoctorEntryView() {
            private static final long serialVersionUID = 1L;

			@Override
            protected void actionButtonClicked() {
                doAction();
            }
        };
    }
        
    private void doAction() {
        if(model == null) {
        	model = DoctorEntry.builder().license(view.getLicenseEntry().getText()).name(view.getNameEntry().getText()).build();
        	model.setLicense(view.getLicenseEntry().getText());
        	model.setName(view.getNameEntry().getText());
            repository.save(model);
        }
        model = null;
        view.getLicenseEntry().setText("");
        view.getNameEntry().setText("");
        caller.validate();
    }

    public void setModel(DoctorEntry model) {
        this.model = model;
        if(model == null) {
            view.getLicenseEntry().setText("");
            view.getNameEntry().setText("");
            view.writeMode();
        } else {
            view.getLicenseEntry().setText(model.getLicense());
            view.getNameEntry().setText(model.getName());
            view.viewMode();
        }
    }

    public DoctorEntryController setCaller(JFrame caller) {
        this.caller = caller;
        return this;
    }
    
    public DoctorEntryView getView() {
		return view;
	}    
}