package com.project.journalApp.service;

import com.project.journalApp.model.JournalEntity;
import com.project.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class JournalEntryService  {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void add(JournalEntity myjournal)
    {
        myjournal.setDate(LocalDate.now());
        journalEntryRepository.save(myjournal);
    }
    public List<JournalEntity> getAll()
    {
        return journalEntryRepository.findAll();
    }

    public JournalEntity findbyId(ObjectId id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    public void DeletebyId(ObjectId id) {
        journalEntryRepository.deleteById(id);
    }

}
