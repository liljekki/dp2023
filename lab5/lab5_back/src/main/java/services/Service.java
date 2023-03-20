package services;

import entity.MyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.Repositor;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repositor repo;

    public List<MyEntity> listAll(){
        return repo.findAll();
    }

    public void save(MyEntity ent){
        repo.save(ent);
    }

    public MyEntity get(int id){
        return repo.findById(id).get();
    }

    public void delete(int id){
        repo.deleteById(id);
    }
}
