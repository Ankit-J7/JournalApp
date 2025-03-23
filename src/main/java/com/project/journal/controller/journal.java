package com.project.journal.controller;

import com.project.journal.dao.journal.journalDAOImpl;
import com.project.journal.model.journalEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api")
public class journal {

    @Autowired
    private journalDAOImpl JournalDAOimpl;

    @GetMapping(value = "/journals")
    public ResponseEntity<?> getAllJournal() {
        List<journalEntity> j = JournalDAOimpl.getAll();
        if (j != null && !j.isEmpty()) {
            return new ResponseEntity<>(j, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/journal/{id}")
    public ResponseEntity<journalEntity> getJournalbyId(@PathVariable ObjectId id) {
        Optional<journalEntity> j = Optional.ofNullable(JournalDAOimpl.findbyId(id));
        if (j.isPresent()) {
            return new ResponseEntity<>(j.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/addjournal")
    public ResponseEntity<?> addJournal(@RequestBody journalEntity myjournal) {
        try {
            JournalDAOimpl.add(myjournal);
            return new ResponseEntity<>(myjournal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/journal/{id}")
    public ResponseEntity<?> DeleteJournalbyId(@PathVariable ObjectId id) {
        JournalDAOimpl.DeletebyId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/journal/{id}")
    public ResponseEntity<?> editJournalbyId(@PathVariable ObjectId id, @RequestBody journalEntity newEntry) {
            journalEntity old = JournalDAOimpl.findbyId(id);
            if (old != null) {
                old.setName(newEntry.getName() != null && !newEntry.getName().equals("") ? newEntry.getName() : old.getName());
                old.setDescription(newEntry.getDescription() != null && !newEntry.getDescription().equals("") ? newEntry.getDescription() : old.getDescription());
                JournalDAOimpl.add(old);
                return new ResponseEntity<>(old, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
