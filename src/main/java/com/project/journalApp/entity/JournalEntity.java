package com.project.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "journalEntries")
public class JournalEntity {
    @Id
    private ObjectId id;

    private String name;
    private String description;
    private LocalDateTime date;
}
