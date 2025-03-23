package com.project.journal.repository;

import com.project.journal.model.journalEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<journalEntity, ObjectId> {
}
