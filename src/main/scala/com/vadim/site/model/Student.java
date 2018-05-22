package com.vadim.site.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "students")
public class Student implements Model{

    @Id
    private ObjectId id;
    private String name;
    @DBRef
    private Group group;
    @DBRef
    private List<Book> books;

    public Student() {
    }

    public Student(ObjectId id, String name, Group group, List<Book> books) {

        this.id = id;
        this.name = name;
        this.group = group;
        this.books = books;
    }

    public ObjectId getId() {

        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
