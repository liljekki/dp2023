package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="entity.entity")
public class MyEntity implements Serializable {
    @Id
    private int id;
    private String name;
    private String description;
    private String img;

    public MyEntity(int id, String name, String description, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
    }

    public MyEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getimg() {
        return img;
    }

    public void setimg(String img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "{\"id\": \""+id+"\", \"name\": \""+name+"\", \"description\": \""+description+"\", \"ImgUrl\": "+img+"}";
    }
}
