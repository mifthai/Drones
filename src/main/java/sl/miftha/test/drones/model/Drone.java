package sl.miftha.test.drones.model;

import sl.miftha.test.drones.types.DroneModel;
import sl.miftha.test.drones.types.DroneStatus;

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

    private int model;

    @Max(value = 500, message = "500gr max")
    private int weightLimit;

    private float batteryCapacity;

    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public sl.miftha.test.drones.dto.Drone getDroneDTO(){
        sl.miftha.test.drones.dto.Drone dto = new sl.miftha.test.drones.dto.Drone();

        dto.setId(getId());
        dto.setSerialNumber(getSerialNumber());
        dto.setModel(DroneModel.get(getModel()));
        dto.setWeightLimit(getWeightLimit());
        dto.setBatteryCapacity(getBatteryCapacity());
        dto.setState(DroneStatus.get(getModel()));

        return dto;
    }
}
