package com.logisticcomfort.model;

import com.logisticcomfort.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Set;

@Entity
@Table(name = "comp")
public class Company {

    @Id
    private Long id;

    private String name;

//    , mappedBy="company"
//    @JoinColumn(name = "company")
    @OneToMany(mappedBy="company", fetch = FetchType.LAZY)
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
