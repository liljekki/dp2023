package Crud;

import Entity.MyEntity;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import fileIO.FileIO;
import fileIO.FileIOInterface;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class fileCrud implements Lab2CrudInterface {
    FileIOInterface fio;
    public fileCrud(){
        this.fio = new FileIO();
    }
    @Override
    public MyEntity readEntity() {
        return (MyEntity) fio.loadFromFile();
    }

    @Override
    public void updateEntity(MyEntity entity) {
        fio.savetoFile(entity);
    }

    public JsonElement bodyParse(HttpServletRequest request){
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch ( IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }
    @Override
    public MyEntity Parse(HttpServletRequest request) {
        MyEntity ent = new MyEntity();
        JsonElement jsonElement = bodyParse(request);
        ent.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        ent.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        ent.setDescription(jsonElement.getAsJsonObject().get("description").getAsString());
        ent.setImgUrl(jsonElement.getAsJsonObject().get("ImgUrl").getAsString());
        return ent;
    }

    @Override
    public int getIndexById(int id, List<MyEntity> list) {
        int listId = id;

        Iterator<MyEntity> iterator = list.iterator();
        while(((Iterator<?>) iterator).hasNext()) {
            MyEntity temp = iterator.next();
            if(temp.getId() == listId) {
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
    @Override
    public int getNextId(List<MyEntity> list) {
        int maxId = 0;

        Iterator<MyEntity> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }
}
