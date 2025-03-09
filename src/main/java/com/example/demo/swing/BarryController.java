package com.example.demo.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Optional;
import java.util.UUID;

import javax.swing.JFrame;

import org.springframework.stereotype.Controller;

import com.example.demo.model.PersonEntry;
import com.example.demo.repository.PersonEntryRepository;
import com.example.demo.util.ComponentFactory;
import com.example.demo.util.ImportCSV;

@Controller
public class BarryController extends JFrame {
    private static final long serialVersionUID = 1L;
    
    {
    	new ImportCSV();
    }
    
	private final MainView view;
    private final PersonEntryRepository repo;
    private final PersonEntryController personEntryController;

    public BarryController(PersonEntryRepository personRepository, PersonEntryController personEntryController) {
        super("Swing Demo for Epikur!");

        this.repo = personRepository;
        this.personEntryController = personEntryController.setCaller(this);
        this.view = null;
        
        /*
        this.view = new MainView() {
            @Override
            protected void newEntryButtonClicked() {
                doNewEntry();
            }

            @Override
            protected void viewEntryButtonClicked() {
                doViewEntry();
            }
        };

        this.setContentPane(view.getRootComponent());
        view.setJournalEntryListContent(repo.findAllByOrderByEntryTimeDesc().toArray());
        */

        this.add(ComponentFactory.getMenuBar(), BorderLayout.NORTH);
        System.err.println("menu");

        /*
        this.add(ComponentFactory.getTabbedPane(), BorderLayout.CENTER);
        System.err.println("tabbed");
        */
        
        
        
        this.setPreferredSize(new Dimension(600, 500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    private void doNewEntry() {
    	
        personEntryController.setModel(new PersonEntry());
        personEntryController.setVisible(true);
    }

    private void doViewEntry() {
        UUID id = ((PersonEntry)view.getSelectedEntry()).getId();
        Optional<PersonEntry> maybeEntry = repo.findById(id);
        personEntryController.setModel(maybeEntry.orElse(new PersonEntry()));
        personEntryController.setVisible(true);
    }

    @Override
    public void validate() {
        super.validate();
        //view.setJournalEntryListContent(repo.findAllByOrderByEntryTimeDesc().toArray());
    }
}
