package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Book {
    Integer id;
    String title;
    String description;
    Integer user_id;
    String authors;

    public Book(String title, String description, String authors) {
        this.title = title;
        this.description = description;
        this.authors = authors;
    }
}
