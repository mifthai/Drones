package sl.miftha.test.drones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sl.miftha.test.drones.model.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
}
