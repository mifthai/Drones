package sl.miftha.test.drones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.miftha.test.drones.repository.DroneRepository;

@Service
public class DroneService {
    @Autowired
    private DroneRepository droneRepository;
}
