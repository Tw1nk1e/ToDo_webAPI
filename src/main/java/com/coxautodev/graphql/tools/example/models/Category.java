package com.coxautodev.graphql.tools.example.models;

        import lombok.Data;
        import org.springframework.data.annotation.Id;
        import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "categories")
public class Category {

    @Id
    private String id;
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
