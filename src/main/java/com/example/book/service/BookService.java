package com.example.book.service;

import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BookService {

    final BookRepository bookRepository;

    public List<Book> findAuthorBook(Integer id) {
        return bookRepository.findAuthorBook(id);
    }

    public List<Book> findGroupAuthorsBook(List<Integer> ids) {
        return bookRepository.findGroupAuthorsBook(ids,  ids.size());
    }
//
    public List<Book> findAuthorsBook(List<Integer> ids) {
        return bookRepository.findAuthorsBook(ids);
    }

    public List<Book> findByPrice(double priceFrom, double priceTo) {
        return bookRepository.findByPrice(priceFrom, priceTo);
    }

    public List<Book> findByPrice(double price) {
        return bookRepository.findByPrice(price);
    }

}
