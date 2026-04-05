package com.project.journalApp.repository;

import com.project.journalApp.model.JournalEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntity, ObjectId> {
}
