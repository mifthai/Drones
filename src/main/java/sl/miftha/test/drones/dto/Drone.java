package sl.miftha.test.drones.dto;

import sl.miftha.test.drones.types.DroneModel;
import sl.miftha.test.drones.types.DroneStatus;

public class Drone {
    private int id;
    private String serialNumber;
    private DroneModel model;
    private int weightLimit;
    private float batteryCapacity;
    private DroneStatus state;

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
