package com.example.demo.swing;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import com.example.demo.model.PersonEntry;
import com.example.demo.repository.PersonEntryRepository;


@Component
public class PersonEntryController extends JFrame {
    private static final long serialVersionUID = 1L;
    
	private final PersonEntryView view;
    private final PersonEntryRepository repo;
    private PersonEntry model;
    private JFrame caller;

    public PersonEntryController(PersonEntryRepository personRepository) {
        super("Another hideous screen?!");
        this.repo = personRepository;
        this.view = new PersonEntryView() {
            @Override
            protected void actionButtonClicked() {
                doAction();
            }
        };
        this.setContentPane(view.getRootComponent());
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.pack();
    }

    /**
     * We allow for two potential actions.  If the JournalEntry is new, then the action is Save.  If the JournalEntry
     * already exists in the database, we just display it and close the window when we're done.
     */
    private void doAction() {
        if(model.isNew()) {
        	
        	/*
            model.setEntry(view.getText());
            model.setEntryTime(LocalDateTime.now());
            repo.save(model);
            */
        }
        this.setVisible(false);
        model = null;
        //view.setText("");
        caller.validate();
    }

    /**
     * Set the model and manipulate the view appropriately.  If the model is New, then set the View into Write Mode.  If
     * it isn't new, set it in Write mode.
     *
     * @param model - The JournalEntry object to be displayed and - maybe - edited.
     */
    public void setModel(PersonEntry model) {
        this.model = model;
        /*
        if(model.isNew()) {
            view.setText("");
            view.writeMode();
        } else {
            view.setText(model.getEntry());
            view.viewMode();
        }
        */
    }

    /**
     * Set the View calling to this one, so that we can get it to refresh after we save an entry to the database.
     *
     * @param caller - A JFrame that instantiated this one.
     * @return A reference to this instance of JournalEntryController.  This is a builder method, because I like them.
     */
    public PersonEntryController setCaller(JFrame caller) {
        this.caller = caller;
        return this;
    }
}
