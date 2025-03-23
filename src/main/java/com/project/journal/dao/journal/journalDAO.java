package com.project.journal.dao.journal;

import com.project.journal.model.journalEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface journalDAO  {
    public void add(journalEntity myjournal);
    public List<journalEntity> getAll();
    public journalEntity findbyId(ObjectId id);
    public void DeletebyId(ObjectId id);
}
