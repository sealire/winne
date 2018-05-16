package org.winne.bookstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.winne.base.ResponseStatus;
import org.winne.base.RestResponse;
import org.winne.bookstore.domain.Book;
import org.winne.bookstore.service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "books", method = RequestMethod.GET)
    @ResponseBody
    public RestResponse books(HttpServletRequest request, HttpServletResponse response) {
        RestResponse<List<Book>> result = new RestResponse<>();

        List<Book> books = bookService.books();
        result.setData(books);
        result.setStatus(ResponseStatus.SUCCESS);

        return result;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResponse book(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) {
        RestResponse<Book> result = new RestResponse<>();

        Book book = bookService.book(id);
        result.setData(book);
        result.setStatus(ResponseStatus.SUCCESS);

        return result;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse insert(HttpServletRequest request, HttpServletResponse response, Book book) {
        RestResponse<Integer> result = new RestResponse<>();
        int insert = bookService.insert(book);
        result.setData(insert);
        result.setStatus(ResponseStatus.SUCCESS);

        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(HttpServletRequest request, HttpServletResponse response, Book book) {
        RestResponse<Integer> result = new RestResponse<>();
        int update = bookService.update(book);
        result.setData(update);
        result.setStatus(ResponseStatus.SUCCESS);

        return result;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object res(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) {
        RestResponse<Integer> result = new RestResponse<>();

        int delete = bookService.delete(id);
        result.setData(delete);
        result.setStatus(ResponseStatus.SUCCESS);

        return result;
    }
}
