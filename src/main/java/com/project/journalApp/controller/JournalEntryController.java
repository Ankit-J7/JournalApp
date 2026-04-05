package com.project.journalApp.controller;

import com.project.journalApp.entity.JournalEntity;
import com.project.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api")
public class  JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping(value = "/journals")
    public ResponseEntity<?> getAllJournal() {
        List<JournalEntity> j = journalEntryService.getAll();
        if (j != null && !j.isEmpty()) {
            return new ResponseEntity<>(j, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/addjournal")
    public ResponseEntity<?> addJournal(@RequestBody JournalEntity myjournal) {
        try {
            journalEntryService.saveEntry(myjournal);
            return new ResponseEntity<>(myjournal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/journal/{id}")
    public ResponseEntity<JournalEntity> getJournalbyId(@PathVariable ObjectId id) {
        Optional<JournalEntity> j = Optional.ofNullable(journalEntryService.findbyId(id));
        if (j.isPresent()) {
            return new ResponseEntity<>(j.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/journal/{id}")
    public ResponseEntity<?> deleteJournalbyId(@PathVariable ObjectId id) {
        journalEntryService.deletebyId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/journal/{id}")
    public ResponseEntity<?> updateJournalbyId(@PathVariable ObjectId id, @RequestBody JournalEntity newEntry) {
            JournalEntity old = journalEntryService.findbyId(id);
            if (old != null) {
                old.setName(newEntry.getName() != null && !newEntry.getName().equals("") ? newEntry.getName() : old.getName());
                old.setDescription(newEntry.getDescription() != null && !newEntry.getDescription().equals("") ? newEntry.getDescription() : old.getDescription());
                journalEntryService.saveEntry(old);
                return new ResponseEntity<>(old, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
