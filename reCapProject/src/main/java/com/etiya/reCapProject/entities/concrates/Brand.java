package com.etiya.reCapProject.entities.concrates;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="brands")
@Entity
public class Brand {
	
  @Id

  @Column(name="brand_id")
  private int brandId;

   @Column(name="brand_name")
   private String brandName;

}
