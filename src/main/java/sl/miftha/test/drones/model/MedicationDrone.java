package sl.miftha.test.drones.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class MedicationDrone {

    @EmbeddedId
    private MedicationDroneId medicationDroneId;

    @ManyToOne
    @MapsId(value = "droneId")
    @JoinColumn(name = "droneId")
    private List<Drone> droneList;

    @ManyToOne
    @MapsId(value = "medicationId")
    @JoinColumn(name = "medicationId")
    private List<Medication> medicationList;

    private byte deliveryStatus;
}
