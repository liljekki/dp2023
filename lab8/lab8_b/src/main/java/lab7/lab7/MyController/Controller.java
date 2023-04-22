package lab7.lab7.MyController;

import lab7.lab7.MyEntity.MyEntity;
import lab7.lab7.Repos.MyRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/things")
@Slf4j
public class Controller {

    @Autowired
    MyRepo myRepo;

    @GetMapping("/get")
    public List<MyEntity> getEntities(){
        List<MyEntity> list;
        log.info("[MY CONTROLLER] Before GET");
        list = myRepo.findAll();
        log.info("[MY CONTROLLER] After GET Found {} things", list.size());
        return list;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MyEntity postEntity(@RequestBody MyEntity newEntity){
        log.info("[MY CONTROLLER] After POST Found new entity {} ", newEntity);
        return myRepo.save(newEntity);
    }

    @PutMapping("/update/{id}")
    public MyEntity putEntity(@PathVariable long id, @RequestBody MyEntity newEntity){
        MyEntity updatedEntity = myRepo.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found Entity with id: "+id));
        updatedEntity.setName(newEntity.getName());
        updatedEntity.setDescription(newEntity.getDescription());
        updatedEntity.setImg(newEntity.getImg());
        log.info("[MY CONTROLLER] After PUT Found updated entity {} ", updatedEntity);
        return myRepo.save(updatedEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id){
        MyEntity deletedEntity = myRepo.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found Entity with id: "+id));
        log.info("[MY CONTROLLER] After DELETE Found deleted entity {} ", deletedEntity);
        myRepo.deleteById(id);
    }

}