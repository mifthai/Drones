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


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public float getWeight() {
      return weight;
   }

   public void setWeight(float weight) {
      this.weight = weight;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public byte[] getImage() {
      return image;
   }

   public void setImage(byte[] image) {
      this.image = image;
   }

   public sl.miftha.test.drones.dto.Medication getDroneDTO(){
      sl.miftha.test.drones.dto.Medication dto = new sl.miftha.test.drones.dto.Medication();

      dto.setCode(getCode());
      dto.setName(getName());
      dto.setWeight(getWeight());
      dto.setImage(getImage());

      return dto;
   }
}
