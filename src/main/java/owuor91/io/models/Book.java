package owuor91.io.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity public class Book {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
  private String title;
  private String description;
  @Transient private int categoryId;
  @ManyToOne @JoinColumn(name="book_category_id") @JsonIgnore private BookCategory bookCategory;

  public Book() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BookCategory getBookCategory() {
    return bookCategory;
  }

  public void setBookCategory(BookCategory bookCategory) {
    this.bookCategory = bookCategory;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }
}
