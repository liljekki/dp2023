package Entity;

import java.io.Serializable;

public class MyEntity implements Serializable {
    public static final long serialVersionUID =1L;
    private String name;
    private String description;
    private String ImgUrl;

    public MyEntity(String name, String description, String ImgUrl) {
        this.name = name;
        this.description = description;
        this.ImgUrl = ImgUrl;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return ImgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.ImgUrl = imgUrl;
    }
}
