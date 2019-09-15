package owuor91.io.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "book_category")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BookCategory {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
  private String name;

  public BookCategory() {
  }

  public BookCategory(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
