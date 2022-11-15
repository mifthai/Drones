package sl.miftha.test.drones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.miftha.test.drones.repository.MedicationRepository;

@Service
public class MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;
}
