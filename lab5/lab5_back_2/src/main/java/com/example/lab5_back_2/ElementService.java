package com.example.lab5_back_2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementService {
    @Autowired
    private ElementRepository repo;

    public List<MyEntity> listAll(){
        return repo.findAll();
    }

    public void save(MyEntity element){
        repo.save(element);
    }

    public MyEntity get(Long id){
        return repo.findById(id).get();
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
