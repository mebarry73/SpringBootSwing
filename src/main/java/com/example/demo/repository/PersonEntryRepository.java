package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PersonEntry;

import java.util.List;
import java.util.UUID;

public interface PersonEntryRepository extends CrudRepository<PersonEntry, UUID> {
    List<PersonEntry> findAllByOrderByEntryTimeDesc();
}
