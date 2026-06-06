package com.project.journalApp.service;

import com.project.journalApp.entity.JournalEntity;
import com.project.journalApp.entity.User;
import com.project.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class JournalEntryService  {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    UserService userservice;

    public void saveEntry(String user,JournalEntity myjournal)
    {
        User u = userservice.findByUserName(user);
        myjournal.setDate(LocalDateTime.now());
        journalEntryRepository.save(myjournal);
        u.getJournalEntries().add(myjournal);
        userservice.saveEntry(u);
    }

    public void saveEntry(JournalEntity myjournal)
    {
        journalEntryRepository.save(myjournal);
    }
    public List<JournalEntity> getAll()
    {
        return journalEntryRepository.findAll();
    }

    public JournalEntity findbyId(ObjectId id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    public void deletebyId(String userName,ObjectId id) {
        User u=userservice.findByUserName(userName);
        u.getJournalEntries().removeIf(x->x.getId().equals(id));
        journalEntryRepository.deleteById(id);
        userservice.saveEntry(u);
    }

}
