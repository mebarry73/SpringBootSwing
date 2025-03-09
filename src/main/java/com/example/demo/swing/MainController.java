package com.example.demo.swing;

import java.util.Optional;
import java.util.UUID;

import javax.swing.JFrame;

import org.springframework.stereotype.Controller;

import com.example.demo.model.PersonEntry;
import com.example.demo.repository.PersonEntryRepository;

@Controller
public class MainController extends JFrame {
    private static final long serialVersionUID = 1L;
	private final MainView view;
    private final PersonEntryRepository repo;
    private final PersonEntryController personEntryController;

    public MainController(PersonEntryRepository personRepository, PersonEntryController personEntryController) {
        super("What a hideous application!");

        this.repo = personRepository;
        this.personEntryController = personEntryController.setCaller(this);

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
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        view.setJournalEntryListContent(repo.findAllByOrderByEntryTimeDesc().toArray());

        this.pack();
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

    /**
     * I hook the refresh of the JList up to the validate method.  Then you can call it from another view without
     * having to actually know the implementation under the hood.  It's just a JFrame that you're validating.
     */
    @Override
    public void validate() {
        super.validate();
        view.setJournalEntryListContent(repo.findAllByOrderByEntryTimeDesc().toArray());
    }
}
