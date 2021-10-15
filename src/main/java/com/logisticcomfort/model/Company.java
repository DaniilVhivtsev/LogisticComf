package com.logisticcomfort.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "comp")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<User> author;


    public Set<User> getAuthor() {
        return author;
    }

    public void setAuthor(Set<User> author) {
        this.author = author;
    }

    public void addAuthor(User author) {
        this.author.add(author);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
