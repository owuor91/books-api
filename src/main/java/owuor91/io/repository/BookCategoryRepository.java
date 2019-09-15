package owuor91.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owuor91.io.models.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}
