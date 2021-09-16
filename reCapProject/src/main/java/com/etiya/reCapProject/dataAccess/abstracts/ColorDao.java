package com.etiya.reCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.etiya.reCapProject.entities.concrates.Color;

@Repository
public interface ColorDao extends JpaRepository<Color, Integer> {

	List<Color> getBycolorId(int colorId);   
}
