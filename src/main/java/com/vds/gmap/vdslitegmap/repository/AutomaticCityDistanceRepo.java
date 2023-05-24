package com.vds.gmap.vdslitegmap.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vds.gmap.vdslitegmap.entity.AutomaticCityDistance;

public interface AutomaticCityDistanceRepo extends JpaRepository<AutomaticCityDistance, Long> {
	
	 public List<AutomaticCityDistance> findAll();

}
