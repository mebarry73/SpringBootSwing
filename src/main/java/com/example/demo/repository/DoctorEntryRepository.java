package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.DoctorEntry;

public interface DoctorEntryRepository extends CrudRepository<DoctorEntry, Integer> {
    List<DoctorEntry> findAll();
}
