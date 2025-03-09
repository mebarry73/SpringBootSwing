package com.example.demo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity(name="person")
@Table
public class PersonEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private int doctor;

    @Column
    private String name;
    
    
    @Column
    private LocalDateTime entryTime;

    @Column    
	private Geschlecht geschlecht;
	
    @Column	
	private int koerpergroesse;
	
    @Column    
	private float koerpergewicht;
    
	public PersonEntry() {
		super();
	}
        
    @Override
    public String toString() {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(entryTime);
    }

    public boolean isNew() {
        return id == null;
    }

	public UUID getId() {
		return id;
	}
}
