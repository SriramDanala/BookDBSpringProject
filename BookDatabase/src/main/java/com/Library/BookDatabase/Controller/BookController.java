package com.Library.BookDatabase.Controller;
import com.Library.BookDatabase.Model.Book;
import com.Library.BookDatabase.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("Books")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/getBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/getBooksInOrderOfId")
    public List<Book> getBooksInOrderOfId(){
        return bookService.getBooksInOrderOfId();
    }

    @GetMapping("/bookByAuthor")
    public Book getBookByAuthorName(@RequestParam String authorName,
                                    @RequestParam int bookId)
    {
        return bookService.getBookByAuthorName(authorName);
    }
    @PutMapping("update-book/{bookId}")
    public String updateBookById(@PathVariable int bookId,@RequestBody Book newBook){
        bookService.updateBookById(bookId,newBook);
        return "book with id:"+bookId+" has been Updated";
    }
    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book)
    {
       bookService.addBook(book);
       return "Added a Book";
    }
    @DeleteMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable int bookId){
        bookService.deleteBook(bookId);
        return "Deleted book with id"+ bookId;
    }

}
