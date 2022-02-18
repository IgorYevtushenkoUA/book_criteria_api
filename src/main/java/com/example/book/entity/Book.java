package com.example.book.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@Getter
@Setter
@ToString
public class Book implements Serializable {
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
    @ToString.Exclude
    @JoinTable(
            name="book_has_genres",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="genre_id"))
    private List<Genre> genres;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(
            name="book_has_authors",
            joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="author_id", referencedColumnName = "id"))
    private List<Author> authors;


}
