package sl.miftha.test.drones.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MedicationDroneId implements Serializable {

    @Column(name = "droneId")
    private long droneId;

    @Column(name = "medicationId")
    private long medicationId;

    public MedicationDroneId() {
    }

    public MedicationDroneId(long droneId, long medicationId) {
        this.droneId = droneId;
        this.medicationId = medicationId;
    }
}
