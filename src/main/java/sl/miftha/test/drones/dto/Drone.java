package sl.miftha.test.drones.dto;

import sl.miftha.test.drones.types.DroneModel;
import sl.miftha.test.drones.types.DroneStatus;

public class Drone {
    private String serialNumber;
    private DroneModel model;
    private float weightLimit;
    private float batteryCapacity;
    private DroneStatus state;
}
