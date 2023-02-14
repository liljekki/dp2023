package Crud;

import Entity.MyEntity;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface Lab2CrudInterface {
    public MyEntity readEntity();
    public void updateEntity(MyEntity entity);
    MyEntity Parse(HttpServletRequest request);
    int getIndexById(int id, List<MyEntity> le);
    int getNextId(List<MyEntity> le);
}
