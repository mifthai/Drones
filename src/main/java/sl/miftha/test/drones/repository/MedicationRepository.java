package sl.miftha.test.drones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sl.miftha.test.drones.model.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
