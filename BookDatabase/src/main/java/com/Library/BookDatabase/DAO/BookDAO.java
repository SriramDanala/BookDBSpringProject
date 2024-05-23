package com.Library.BookDatabase.DAO;

import com.Library.BookDatabase.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer>
{
Book findByAuthorName(String authorName);
Book findById(int bookId);
}
