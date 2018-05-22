package com.vadim.site.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class Book implements Model{

    @Id
    private ObjectId id;
    private String title;
    private int prise;

    public Book() {
    }

    public Book(ObjectId id, String title, int prise) {

        this.id = id;
        this.title = title;
        this.prise = prise;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrise() {
        return prise;
    }

    public void setPrise(int prise) {
        this.prise = prise;
    }
}
