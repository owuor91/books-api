package owuor91.io.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import owuor91.io.models.BookCategory;
import owuor91.io.repository.BookCategoryRepository;

@RestController public class BookCategoryController {

  @Autowired BookCategoryRepository bookCategoryRepository;

  @GetMapping("/api/book_categories") public List<BookCategory> index() {
    return bookCategoryRepository.findAll();
  }

  @GetMapping("/api/book_categories/{id}")
  public BookCategory getBookCategory(@PathVariable String id) {
    return bookCategoryRepository.getOne(Integer.parseInt(id));
  }

  @PostMapping("/api/book_categories")
  public BookCategory createBookCategory(@RequestParam("name") String name) {
    return bookCategoryRepository.save(new BookCategory(name));
  }

  @PutMapping("/api/book_categories/{id}")
  public BookCategory updateBookCategory(@PathVariable String id,
      @RequestParam("name") String name) {
    BookCategory bookCategory = bookCategoryRepository.getOne(Integer.parseInt(id));
    bookCategory.setName(name);
    return bookCategoryRepository.save(bookCategory);
  }
}
