package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="doctor")
@Table
public class DoctorEntry {
    @Id
    private int id;

    @Column
    private String name;
    
	public DoctorEntry() {
	}

	public int getId() {
		return id;
	}
}
