package sl.miftha.test.drones.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sl.miftha.test.drones.types.DroneModel;
import sl.miftha.test.drones.types.DroneStatus;

public class DroneDTO {
    private long id;
    private String serialNumber;
    private DroneModel model;
    private int weightLimit;
    private float batteryCapacity;
    private DroneStatus state;

    public DroneDTO() {
    }

    public DroneDTO(int id, String serialNumber, DroneModel model, int weightLimit, float batteryCapacity, DroneStatus state) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DroneModel getModel() {
        return model;
    }

    public void setModel(DroneModel model) {
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

    public DroneStatus getState() {
        return state;
    }

    public void setState(DroneStatus state) {
        this.state = state;
    }

    @JsonIgnore
    public sl.miftha.test.drones.model.Drone getDroneEntity() {
        sl.miftha.test.drones.model.Drone entity = new sl.miftha.test.drones.model.Drone();

        entity.setId(getId());
        entity.setSerialNumber(getSerialNumber());
        entity.setModel(getModel().ordinal());
        entity.setWeightLimit(getWeightLimit());
        entity.setBatteryCapacity(getBatteryCapacity());
        entity.setState(getState().ordinal());

        return entity;
    }
}
