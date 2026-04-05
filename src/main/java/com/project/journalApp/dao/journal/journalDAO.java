package com.project.journalApp.dao.journal;

import com.project.journalApp.model.journalEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface journalDAO  {
    public void add(journalEntity myjournal);
    public List<journalEntity> getAll();
    public journalEntity findbyId(ObjectId id);
    public void DeletebyId(ObjectId id);
}
