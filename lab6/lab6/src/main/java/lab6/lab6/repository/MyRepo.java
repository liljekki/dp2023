package lab6.lab6.repository;

import lab6.lab6.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepo extends JpaRepository<MyEntity, Long> {

}
