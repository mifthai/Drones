package sl.miftha.test.drones.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MedicationDTO {
   private long id;
   private String name;
   private float weight;
   private String code;
   private byte[] image;

   public long getId() {
      return id;
   }

   public void setId(long id) {
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

   @JsonIgnore
   public sl.miftha.test.drones.model.Medication getMedicationEntity(){
      sl.miftha.test.drones.model.Medication entity = new sl.miftha.test.drones.model.Medication();

      entity.setId(getId());
      entity.setCode(getCode());
      entity.setName(getName());
      entity.setWeight(getWeight());
      entity.setImage(getImage());

      return entity;
   }
}
