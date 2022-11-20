package sl.miftha.test.drones.model;

import sl.miftha.test.drones.dto.MedicationDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Medication {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Medication")
   private long id;
   private String name;
   private float weight;
   private String code;
   private byte[] image;

   @OneToMany
   private List<MedicationDrone> medicationDrone;

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

   public MedicationDTO getMedicationDTO(){
      MedicationDTO dto = new MedicationDTO();

      dto.setId(getId());
      dto.setCode(getCode());
      dto.setName(getName());
      dto.setWeight(getWeight());
      dto.setImage(getImage());

      return dto;
   }
}
