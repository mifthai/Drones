package sl.miftha.test.drones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.miftha.test.drones.dto.DroneDTO;
import sl.miftha.test.drones.dto.MedicationDTO;
import sl.miftha.test.drones.exception.DroneNotFoundException;
import sl.miftha.test.drones.exception.DroneNotLoadableException;
import sl.miftha.test.drones.exception.MissingMedicationException;
import sl.miftha.test.drones.model.Drone;
import sl.miftha.test.drones.model.MedicationDrone;
import sl.miftha.test.drones.model.MedicationDroneId;
import sl.miftha.test.drones.repository.DroneRepository;
import sl.miftha.test.drones.repository.MedicationDroneRepository;
import sl.miftha.test.drones.types.DroneStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DroneService {
    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private MedicationService medicationService;

    @Autowired
    private MedicationDroneRepository medicationDroneRepository;

    @Transactional
    public DroneDTO save(DroneDTO dto){
       sl.miftha.test.drones.model.Drone  saved =  droneRepository.save(dto.getDroneEntity());
       return saved.getDroneDTO();
    }

    public List<DroneDTO> findLoadableDrone(){
        return findLoadableDroneInt().stream().map(Drone::getDroneDTO).collect(Collectors.toList());
    }

    private List<Drone> findLoadableDroneInt(){
        return droneRepository.findAllByStateIn(List.of(
                DroneStatus.IDLE.ordinal(), DroneStatus.RETURNING.ordinal()
        ));
    }

    /**
     * Loads provided medication to the drone specified by the drone id
     * @param medicationDTOToLoad Medication DTO
     * @param droneSerial Serial of the drone to which the medication needs to be loaded.
     */
    @Transactional
    public DroneDTO loadMedication(MedicationDTO medicationDTOToLoad, String droneSerial) throws DroneNotFoundException, DroneNotLoadableException {
        MedicationDTO savedMedicationDTO = medicationService.save(medicationDTOToLoad);
        Optional<sl.miftha.test.drones.model.Drone> droneFound = droneRepository.findBySerialNumber(droneSerial);
        sl.miftha.test.drones.model.Drone droneToLoad = null;
        if (droneFound.isPresent()){
            droneToLoad = droneFound.get();
            if (droneToLoad.getState() == DroneStatus.IDLE.ordinal() || droneToLoad.getState() == DroneStatus.RETURNING.ordinal()){
                MedicationDrone medicationDrone = new MedicationDrone();
                medicationDrone.setMedication(savedMedicationDTO.getMedicationEntity());
                medicationDrone.setDrone(droneToLoad);
                medicationDrone.setMedicationDroneId(new MedicationDroneId(droneToLoad.getId(), savedMedicationDTO.getId()));
                droneToLoad.loadMedication(medicationDrone);
                medicationDroneRepository.save(medicationDrone);
                droneToLoad.setState(DroneStatus.LOADED.ordinal());
                return droneRepository.save(droneToLoad).getDroneDTO();
            }
            else{
                throw new DroneNotLoadableException();
            }
        }

        throw new DroneNotFoundException();
    }

    public List<MedicationDTO> findMedicationInDrone(String serialNumber) throws DroneNotFoundException, MissingMedicationException {
        Optional<Long> droneIdFound = droneRepository.findIdBySerialNumber(serialNumber);
        if (droneIdFound.isPresent()) {
            long droneId = droneIdFound.get();
            Optional<Long> medicationIdFound = medicationDroneRepository.findMedicationIdByDroneId(droneId);
            if (medicationIdFound.isPresent()){
                return medicationService.findAllById(List.of(medicationIdFound.get()));
            }
            throw new MissingMedicationException();
        }

        throw new DroneNotFoundException();
    }

    public float findBatteryCapacity(String serialNumber)throws DroneNotFoundException {
        Optional<Float> droneFound = droneRepository.findBatteryCapacityBySerialNumber(serialNumber);
        if (droneFound.isPresent()) {
            return droneFound.get();
        }

        throw new DroneNotFoundException();
    }

    public Drone findBySerialNumber(String serialNumber) throws DroneNotFoundException {
        Optional<Drone> droneFound = droneRepository.findBySerialNumber(serialNumber);
        if (droneFound.isPresent()) {
            return droneFound.get();
        }

        throw new DroneNotFoundException();
    }

    private sl.miftha.test.drones.model.Drone pickDroneToLoad(float weight){
        float smallestRemainingCapacity = Float.MAX_VALUE;
        sl.miftha.test.drones.model.Drone selectedDrones = null;

        List<Drone> loadableDrones = findLoadableDroneInt();
        for (sl.miftha.test.drones.model.Drone drone:loadableDrones ) {
            float remainingCapacity = drone.getWeightLimit() - weight;
            if (remainingCapacity > 0 && remainingCapacity < smallestRemainingCapacity) {
                smallestRemainingCapacity = remainingCapacity;
                selectedDrones = drone;
            }
            else if (remainingCapacity == 0 ) {
                selectedDrones = drone;
                break;
            }
        }
        return selectedDrones;
    }
}
