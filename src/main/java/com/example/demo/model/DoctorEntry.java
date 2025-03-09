package com.example.demo.model;

import java.util.UUID;

import com.example.demo.util.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity(name="doctor")
@Table
public class DoctorEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
		
    @Column
    private String license;

    @Column
    private String name;
    
    public String toString() {
    	return new StringBuffer().append(id).append(Constants.CSV_DELIMITER).append(license).append(Constants.CSV_DELIMITER).append(name).toString();
    }
}
