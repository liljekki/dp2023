package lab6.lab6.controller;

import lab6.lab6.entity.MyEntity;
import lab6.lab6.repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping ("/lab6/api/my_entity")
public class MyController {

    @Autowired
    MyRepo myRepo;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MyEntity postEntity(@RequestBody MyEntity element) {
       return myRepo.save(element);
    }

    @GetMapping("/retrieve")
    public List<MyEntity> getEntities(){
        return myRepo.findAll();
    }

    @PutMapping("/update/{id}")
    public MyEntity putEntity(@PathVariable long id, @RequestBody MyEntity newElement){
        MyEntity updatedEntity = myRepo.findById(id).orElseThrow(()-> new ResourceAccessException("Not found with id"+id));
        updatedEntity.setName(newElement.getName());
        updatedEntity.setDescription(newElement.getDescription());
        updatedEntity.setImg(newElement.getImg());
        myRepo.save(updatedEntity);
        return myRepo.save(updatedEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id){
        myRepo.deleteById(id);
    }
}
