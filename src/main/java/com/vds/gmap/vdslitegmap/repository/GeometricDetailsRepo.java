package com.vds.gmap.vdslitegmap.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vds.gmap.vdslitegmap.entity.GeometricDetails;

public interface GeometricDetailsRepo extends JpaRepository<GeometricDetails, Long> {
	
	public Optional<ArrayList<GeometricDetails>> findByLatitudeAndLongtitudeAndAddrType(String lat,String lng,String addrType);

}
