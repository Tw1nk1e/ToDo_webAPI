package com.coxautodev.graphql.tools.example.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;
    private String desc;
    private Statuses status;
    private String category;

    public Task(String desc) {
        this.desc = desc;
        this.status = Statuses.UNDONE;
    }
}
