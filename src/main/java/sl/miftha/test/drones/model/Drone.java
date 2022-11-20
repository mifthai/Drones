package sl.miftha.test.drones.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sl.miftha.test.drones.dto.DroneDTO;
import sl.miftha.test.drones.types.DroneModel;
import sl.miftha.test.drones.types.DroneStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Drone {
    @Id
    @GeneratedValue
    private long id;

    @Size(max = 100, message = "100 characters max")
    private String serialNumber;

    private int model;

    @Max(value = 500, message = "500gr max")
    private int weightLimit;

    @OneToMany
    private List<MedicationDrone> medicationDroneList;

    private float batteryCapacity;

    private int state;

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

    public List<MedicationDrone> getMedicationDroneList() {
        return medicationDroneList;
    }

    public void setMedicationDroneList(List<MedicationDrone> medicationDroneList) {
        this.medicationDroneList = medicationDroneList;
    }

    public void loadMedication(MedicationDrone medicationDrone){
        if (medicationDrone == null) medicationDroneList = new ArrayList<>();
        medicationDroneList.add(medicationDrone);
    }

    @JsonIgnore
    public DroneDTO getDroneDTO(){
        DroneDTO dto = new DroneDTO();

        dto.setId(getId());
        dto.setSerialNumber(getSerialNumber());
        dto.setModel(DroneModel.get(getModel()));
        dto.setWeightLimit(getWeightLimit());
        dto.setBatteryCapacity(getBatteryCapacity());
        dto.setState(DroneStatus.get(getState()));

        return dto;
    }
}
