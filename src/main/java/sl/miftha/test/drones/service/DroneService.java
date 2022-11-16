package sl.miftha.test.drones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.miftha.test.drones.dto.Drone;
import sl.miftha.test.drones.dto.Medication;
import sl.miftha.test.drones.repository.DroneRepository;
import sl.miftha.test.drones.repository.MedicationRepository;
import sl.miftha.test.drones.types.DroneStatus;

@Service
public class DroneService {
    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private MedicationService medicationService;

    public sl.miftha.test.drones.dto.Drone save(sl.miftha.test.drones.dto.Drone dto){
       sl.miftha.test.drones.model.Drone  saved =  droneRepository.save(dto.getDroneEntity());
       return saved.getDroneDTO();
    }

    public void findLoadableDrone(Drone dto){
        droneRepository.findByStatus(new int []{
            DroneStatus.IDLE.ordinal(), DroneStatus.RETURNING.ordinal()
        });
    }

    /**
     * Loads provided medication to the drone specified by the drone id
     * @param medicationToLoad Medication DTO
     * @param droneId id of the drone to which the medication needs to be loaded.
     */
    public void loadMedication(Medication medicationToLoad, long droneId){
        Medication savedMedication = medicationService.save(medicationToLoad);

    }
}
