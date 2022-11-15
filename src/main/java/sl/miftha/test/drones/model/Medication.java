package sl.miftha.test.drones.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Medication {
   @Id
   @GeneratedValue
   private int id;
   private String name;
   private float weight;
   private String code;
   private byte[] image;
}
