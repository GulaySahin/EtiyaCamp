package com.etiya.reCapProject.entities.concrates;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="brands")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","cars" })
@ToString
public class Brand {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="brand_id")
  private int brandId;

   @Column(name="brand_name")
   private String brandName;
   
   
   @JsonIgnore
   @OneToMany(mappedBy ="brand")
   private List<Car>cars;

}
