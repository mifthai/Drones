package sl.miftha.test.drones.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sl.miftha.test.drones.model.Drone;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {
    @Query("SELECT * from drone where status in ( :status) ")
    Drone findByStatus(int [] status);

}
