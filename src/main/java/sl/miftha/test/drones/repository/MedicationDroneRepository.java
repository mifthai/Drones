package sl.miftha.test.drones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sl.miftha.test.drones.model.MedicationDrone;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicationDroneRepository extends JpaRepository<MedicationDrone, Long> {

    @Query(value = " SELECT md.medicationDroneId.medicationId FROM MedicationDrone md WHERE md.medicationDroneId.droneId = :droneId")
    Optional<Long> findMedicationIdByDroneId(@Param(value = "droneId") long droneId);

}
