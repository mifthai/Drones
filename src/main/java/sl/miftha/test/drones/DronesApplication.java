package sl.miftha.test.drones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sl.miftha.test.drones.service.DroneService;
import sl.miftha.test.drones.service.MedicationService;

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

	}
}
