package Entity;

import java.io.Serializable;

public class MyEntity implements Serializable {
    public static final long serialVersionUID =1L;
    private int id;
    private String name;
    private String description;
    private String ImgUrl;

    public MyEntity(int id, String name, String description, String ImgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ImgUrl = ImgUrl;
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

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String ImgUrl) {
        this.ImgUrl = ImgUrl;
    }


    @Override
    public String toString() {
        return "{\"id\": \""+id+"\", \"name\": \""+name+"\", \"description\": \""+description+"\", \"ImgUrl\": "+ImgUrl+"}";
    }
}
