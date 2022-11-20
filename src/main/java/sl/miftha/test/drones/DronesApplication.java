package sl.miftha.test.drones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sl.miftha.test.drones.dto.DroneDTO;
import sl.miftha.test.drones.service.DroneService;
import sl.miftha.test.drones.service.MedicationService;
import sl.miftha.test.drones.types.DroneModel;
import sl.miftha.test.drones.types.DroneStatus;

import java.util.List;

@SpringBootApplication
public class DronesApplication implements CommandLineRunner {

	@Autowired
	private DroneService droneService;

	@Autowired
	private MedicationService medicationService;

	public static void main(String[] args) {
		SpringApplication.run(DronesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<DroneDTO> dronesToSave = List.of(
				new DroneDTO(-1, "S100234", DroneModel.HEAVY_WEIGHT, 400, 0.93F, DroneStatus.DELIVERING),
				new DroneDTO(-1, "S100256", DroneModel.CRUISER_WEIGHT, 300, 0.56F, DroneStatus.DELIVERED),
				new DroneDTO(-1, "S120234", DroneModel.LIGHT_WEIGHT, 100, 0.76F, DroneStatus.IDLE),
				new DroneDTO(-1, "S103274", DroneModel.MIDDLE_WEIGHT, 200, 0.88F, DroneStatus.LOADED),
				new DroneDTO(-1, "S306334", DroneModel.HEAVY_WEIGHT, 400, 0.68F, DroneStatus.LOADING),
				new DroneDTO(-1, "S100244", DroneModel.CRUISER_WEIGHT, 300, 0.99F, DroneStatus.DELIVERED),
				new DroneDTO(-1, "S104534", DroneModel.LIGHT_WEIGHT, 100, 0.34F, DroneStatus.IDLE),
				new DroneDTO(-1, "S234234", DroneModel.MIDDLE_WEIGHT, 200, 0.13F, DroneStatus.RETURNING),
				new DroneDTO(-1, "S300334", DroneModel.HEAVY_WEIGHT, 400, 0.45F, DroneStatus.LOADING),
				new DroneDTO(-1, "S100234", DroneModel.CRUISER_WEIGHT, 300, 0.75F, DroneStatus.RETURNING),
				new DroneDTO(-1, "S340234", DroneModel.LIGHT_WEIGHT, 100, 0.93F, DroneStatus.IDLE),
				new DroneDTO(-1, "S106294", DroneModel.MIDDLE_WEIGHT, 200, 0.93F, DroneStatus.DELIVERING));

		for (DroneDTO droneDTO:dronesToSave) {
			droneService.save(droneDTO);
		}
	}
}
