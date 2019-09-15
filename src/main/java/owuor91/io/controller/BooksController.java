package owuor91.io.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import owuor91.io.models.Book;
import owuor91.io.models.BookCategory;
import owuor91.io.repository.BookCategoryRepository;
import owuor91.io.repository.BookRepository;

@RestController public class BooksController {
  @Autowired BookRepository bookRepository;
  @Autowired BookCategoryRepository bookCategoryRepository;

  @GetMapping("/api/books") private List<Book> getAll() {
    List<Book> books = bookRepository.findAll();
    books.stream().forEach(book -> book.setCategoryId(book.getBookCategory().getId()));
    return books;
  }

  @GetMapping("/api/books/{id}") public Book getBookById(@PathVariable("id") String id) {
    Book book = bookRepository.getOne(Integer.parseInt(id));
    book.setCategoryId(book.getBookCategory().getId());
    return book;
  }

  @PostMapping("/api/books") public Book createBook(@RequestParam("title") String title,
      @RequestParam("description") String description,
      @RequestParam("book_category_id") String categoryId) {
    Book book = new Book();
    book.setTitle(title);
    book.setDescription(description);
    book.setBookCategory(bookCategoryRepository.getOne(Integer.parseInt(categoryId)));
    Book book1 = bookRepository.save(book);
    book1.setCategoryId(book1.getBookCategory().getId());
    return book1;
  }

  @PutMapping("/api/books/{id}")
  public Book editBook(@PathVariable("id") String id, @RequestParam("title") String title,
      @RequestParam("description") String description,
      @RequestParam("book_category_id") String categoryId) {
    Book book = bookRepository.getOne(Integer.parseInt(id));
    book.setTitle(title);
    book.setDescription(description);
    book.setBookCategory(bookCategoryRepository.getOne(Integer.parseInt(categoryId)));
    Book book1 = bookRepository.save(book);
    book1.setCategoryId(book1.getBookCategory().getId());
    return book1;
  }

  @DeleteMapping("/api/books/{id}")
  public Map<String, String> deleteBook(@PathVariable("id") String id) {
    bookRepository.deleteById(Integer.parseInt(id));
    Map<String, String> deleteMap = new HashMap<String, String>();
    deleteMap.put("message", "book deleted");
    return deleteMap;
  }

  @GetMapping("/api/book_categories/{id}/books")
  public List<Book> getBooksByCategoryId(@PathVariable("id") String categoryId) {
    List<Book> bookList = bookRepository.findByBookCategoryId(Integer.parseInt(categoryId));
    bookList.stream().forEach(book -> book.setCategoryId(book.getBookCategory().getId()));
    return bookList;
  }
}
