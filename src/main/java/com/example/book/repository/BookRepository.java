package com.example.book.repository;

import com.example.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    /*
    отримати всі книжки конкретного автора,


    аналогічні запити по видавництвам, жанрам, сторінкам,
    можливість шукати фрагмент тексту скрізь: в описі, назві, авторах, видавництві.
    Кожен запит є окремим методом сервісу.
     */

    @Query("select b from Book b " +
            "inner join b.authors a " +
            "where a.id= :id ")
    List<Book> findAuthorBook(@Param("id") Integer id);


    //    хз ,  це точно не найкращий запит, даремно гулю прогулював
//    todo why we need only long in amountOfAuthors ?
//    всі книжки групи авторів,
    @Query("select distinct b from Book b " +
            "inner join b.authors a " +
            "where a.id in (:ids) " +
            "group by b.id " +
            "having count(b.id) >= (:amountOfAuthors) ")
    List<Book> findGroupAuthorsBook(@Param("ids") List<Integer> ids, @Param("amountOfAuthors") long amountOfAuthors);

    //
//    всі книжки де вказаний хоч один з вказаних авторів,
    @Query("select b from Book b " +
            "inner join b.authors a " +
            "where a.id in(:ids)")
    List<Book> findAuthorsBook(@Param("ids") List<Integer> ids);

    //    всі книжки в діапазоні цін,
    @Query("select b from Book b where b.price >= :priceFrom and b.price <= :priceTo")
    List<Book> findByPrice(@Param("priceFrom") double priceFrom, @Param("priceTo") double priceTo);

    //    всі книжки з конкретною ціною,
    @Query("select b from Book b where b.price = :price")
    List<Book> findByPrice(@Param("price") double price);


    // find text from description, book name, author name, publisher
    @Query("select distinct b from Book b inner join b.authors a " +
            "where lower(b.description) like concat('%', lower(:text), '%') " +
            "or lower(b.name) like concat('%', lower(:text), '%') " +
            "or lower(b.publisher) like concat('%', lower(:text), '%') " +
            "or lower(a.name) like concat('%', lower(:text), '%') ")
    List<Book> findBookByTextInDescriptionOrNameOrAuthorOrPublisher(@Param("text") String text);
}
