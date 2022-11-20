package sl.miftha.test.drones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sl.miftha.test.drones.dto.DroneDTO;
import sl.miftha.test.drones.dto.MedicationDTO;
import sl.miftha.test.drones.exception.DroneNotFoundException;
import sl.miftha.test.drones.exception.DroneNotLoadableException;
import sl.miftha.test.drones.exception.MissingMedicationException;
import sl.miftha.test.drones.service.DroneService;

import java.util.List;

@RestController()
@RequestMapping("/drone")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @PostMapping()
    public @ResponseBody DroneDTO register(@RequestBody DroneDTO droneDTO){
        return droneService.save(droneDTO);
    }

    @PostMapping("{droneSerial}/load")
    public @ResponseBody DroneDTO loadMedication(@RequestBody MedicationDTO medicationDTO, @PathVariable String droneSerial) throws DroneNotFoundException, DroneNotLoadableException {
        return droneService.loadMedication(medicationDTO, droneSerial);
    }

    @GetMapping("{droneSerial}/medication")
    public @ResponseBody List<MedicationDTO> findMedication(@PathVariable String droneSerial) throws DroneNotFoundException, MissingMedicationException {
        return droneService.findMedicationInDrone(droneSerial);
    }

    @GetMapping("/available")
    public @ResponseBody List<DroneDTO> findAvailableForLoading() {
        List<DroneDTO> result = droneService.findLoadableDrone();
        return result;
    }

    @GetMapping("{droneSerial}/batteryCapacity")
    public @ResponseBody float findAvailableForLoading(@PathVariable String droneSerial) throws DroneNotFoundException {
        return droneService.findBatteryCapacity(droneSerial);
    }
}
