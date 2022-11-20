package sl.miftha.test.drones.repository;

import net.bytebuddy.dynamic.DynamicType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sl.miftha.test.drones.model.Drone;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {
    //@Query("SELECT Drone from Drone drone where drone.state in (:status)")
    List<Drone> findAllByStateIn(List<Integer> status);

    @Query(value = " SELECT D.id FROM Drone D WHERE serialNumber = :serialNumber")
    Optional<Long> findIdBySerialNumber(@Param("serialNumber") String serialNumber);

    Optional<Drone> findBySerialNumber(String serialNumber);

    @Query(value = " SELECT D.batteryCapacity FROM Drone D WHERE serialNumber = :serialNumber")
    Optional<Float> findBatteryCapacityBySerialNumber(@Param("serialNumber") String serialNumber);
}
