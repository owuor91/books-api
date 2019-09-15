package owuor91.io.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import owuor91.io.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
  List<Book> findByBookCategoryId(int categoryId);
}
