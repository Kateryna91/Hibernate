package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name="tbl_author")

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200, nullable = false)
    private String fullName;

    @OneToMany (mappedBy = "author")
    private List<Book> books;

}


