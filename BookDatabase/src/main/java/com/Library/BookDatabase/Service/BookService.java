package com.Library.BookDatabase.Service;

import com.Library.BookDatabase.DAO.BookDAO;
import com.Library.BookDatabase.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;
    public List<Book> getAllBooks(){
       return bookDAO.findAll();
    }

    public List<Book> getBooksInOrderOfId() {
        List<Book> arr=bookDAO.findAll(Sort.by(Sort.Direction.ASC,"book"));
        return arr;
    }

    public Book getBookByAuthorName(String authorName) {
        return bookDAO.findByAuthorName(authorName);
    }

    public void addBook(Book book)
    {
        bookDAO.save(book);
    }

    public void deleteBook(int bookId) {
        bookDAO.deleteById(bookId);
    }

    public void updateBookById(int bookId, Book newBook) {
        Book old=bookDAO.findById(bookId);
        old.setBookId(newBook.getBookId());
       old.setBookTitle(newBook.getBookTitle());
       old.setCost(newBook.getCost());
       old.setAuthorName(newBook.getAuthorName());
       bookDAO.save(old);
    }
}























//bookDAO.findAll(Sort.by(Sort.Direction.ASC,"numberOfPages")); // select *from book;
