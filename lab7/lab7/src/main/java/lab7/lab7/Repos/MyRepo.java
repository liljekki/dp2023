package lab7.lab7.Repos;

import lab7.lab7.MyEntity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "things", path = "things")
public interface MyRepo extends JpaRepository<MyEntity,Long> {

}
