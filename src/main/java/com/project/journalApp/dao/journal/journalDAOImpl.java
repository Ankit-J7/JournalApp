package com.project.journalApp.dao.journal;

import com.project.journalApp.model.journalEntity;
import com.project.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class journalDAOImpl implements journalDAO {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void add(journalEntity myjournal)
    {
        myjournal.setDate(LocalDate.now());
        journalEntryRepository.save(myjournal);
    }
    public List<journalEntity> getAll()
    {
        return journalEntryRepository.findAll();
    }

    @Override
    public journalEntity findbyId(ObjectId id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    @Override
    public void DeletebyId(ObjectId id) {
        journalEntryRepository.deleteById(id);
    }

}
