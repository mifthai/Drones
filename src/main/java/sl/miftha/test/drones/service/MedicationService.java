package sl.miftha.test.drones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.miftha.test.drones.dto.MedicationDTO;
import sl.miftha.test.drones.model.Medication;
import sl.miftha.test.drones.repository.MedicationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;

    public MedicationDTO save(MedicationDTO dto){
        sl.miftha.test.drones.model.Medication  saved =  medicationRepository.save(dto.getMedicationEntity());
        return saved.getMedicationDTO();
    }

    public List<MedicationDTO> findAllById(List<Long> medicationIdList){
        List<sl.miftha.test.drones.model.Medication>  medicationList =  medicationRepository.findAllById(medicationIdList);
        return medicationList.stream().map(Medication::getMedicationDTO).collect(Collectors.toList());
    }
}
