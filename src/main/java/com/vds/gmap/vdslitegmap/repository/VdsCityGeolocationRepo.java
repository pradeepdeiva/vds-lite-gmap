package com.vds.gmap.vdslitegmap.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vds.gmap.vdslitegmap.entity.VdsCityGeolocations;

public interface VdsCityGeolocationRepo extends JpaRepository<VdsCityGeolocations, Long> {

	public Optional<ArrayList<VdsCityGeolocations>> findByLatitudeAndLongtitudeAndAddrType(String latitude, String longtitude, String addrType);
	
	@Query(value = "SELECT DISTINCT VDSM58_CITYDISTANCE_ID FROM  KVDSM58_VDS_CITY_GEOMETRIC_DETAILS WHERE VDSM58_CITYDISTANCE_ID IN (:id) ",nativeQuery=true)
	Optional<String> findbyCityDistId(@Param("id") int id);
	
	@Query(value = "SELECT DISTINCT VDSM58_PROVINCE FROM KVDSM58_VDS_CITY_GEOMETRIC_DETAILS WHERE VDSM58_COUNTRY = :country AND VDSM58_PROVINCE IS NOT NULL AND VDSM58_TYPE = 'S'", nativeQuery=true)
	Optional<List<String>> findByCountry(@Param("country") String country);

}
