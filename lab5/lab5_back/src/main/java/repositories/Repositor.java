package repositories;

import entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositor extends JpaRepository<MyEntity, Integer> {

}
