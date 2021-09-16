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
@Table(name="colors")
@Entity
public class Color {
	  @Id
	  
	  @Column(name="color_id")
	  private int colorId;

	   @Column(name="color_name")
	   private String colorName;

}