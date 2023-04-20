package lab7.lab7.MyEntity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="entity")
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String img;
}
