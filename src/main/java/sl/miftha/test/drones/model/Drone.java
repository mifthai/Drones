package sl.miftha.test.drones.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
public class Drone {
    @Id
    @GeneratedValue
    private int id;

    @Size(max = 100, message = "100 characters max")
    private String serialNumber;

    private byte model;

    @Max(value = 500, message = "500gr max")
    private int weightLimit;

    private float batteryCapacity;

    private byte state;
}
