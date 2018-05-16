package org.winne.bookstore.service;

import org.winne.bookstore.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> books();

    Book book(String id);

    int insert(Book book);

    int update(Book book);

    int delete(String id);
}
