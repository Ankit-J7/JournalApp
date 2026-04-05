package com.project.journalApp.service;

import com.project.journalApp.entity.JournalEntity;
import com.project.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class JournalEntryService  {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntity myjournal)
    {
        myjournal.setDate(LocalDateTime.now());
        journalEntryRepository.save(myjournal);
    }
    public List<JournalEntity> getAll()
    {
        return journalEntryRepository.findAll();
    }

    public JournalEntity findbyId(ObjectId id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    public void deletebyId(ObjectId id) {
        journalEntryRepository.deleteById(id);
    }

}
