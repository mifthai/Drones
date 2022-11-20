package sl.miftha.test.drones.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MedicationDrone {

    @EmbeddedId
    private MedicationDroneId medicationDroneId;

    @ManyToOne
    @MapsId(value = "droneId")
    @JoinColumn(name = "droneId")
    private Drone drone;

    @ManyToOne
    @MapsId(value = "medicationId")
    @JoinColumn(name = "medicationId")
    private Medication medication;

    private byte deliveryStatus;

    public MedicationDroneId getMedicationDroneId() {
        return medicationDroneId;
    }

    public void setMedicationDroneId(MedicationDroneId medicationDroneId) {
        this.medicationDroneId = medicationDroneId;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public byte getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(byte deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
