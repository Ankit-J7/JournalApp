package com.project.journal.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Document(collection = "journalEntries")
public class journalEntity {
    @Id
    private ObjectId id;

    private String name;
    private String description;
    private LocalDate date;
}
