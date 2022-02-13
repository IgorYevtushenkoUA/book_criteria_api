package com.example.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "page_number")
    private int pageNumber;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "cover")
    private String cover;
    @Column(name = "price")
    private double price;

    @ManyToMany
    @JoinTable(
            name="book_has_genres",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="genre_id"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(
            name="book_has_authors",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id"))
    private List<Author> authors;


}
