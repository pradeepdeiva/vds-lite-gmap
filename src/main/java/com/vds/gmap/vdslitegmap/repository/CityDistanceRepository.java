package com.vds.gmap.vdslitegmap.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vds.gmap.vdslitegmap.entity.CityDistance;

public interface CityDistanceRepository extends JpaRepository<CityDistance, Long> {
	
	Page<CityDistance> findAll(Pageable pageable);
	
	List<CityDistance> findAll();
	
	@Query(value = "SELECT VDSM20_CITYDISTANCE_ID FROM  KVDSM20_CITY_DISTANCE WHERE VDSM20_CITYDISTANCE_ID IN (:id) ",nativeQuery=true)
	Optional<String> findbyId(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE KVDSM20_CITY_DISTANCE SET VDSM20_SYSTEM_DISTANCE = :sysdist,VDSM20_AUTO_CONFIG = :autoconfig, VDSM20_NEXT_UPDATE_D = :nextdate, VDSM20_UPDATE_PROCESS = :process, VDSM20_LAST_PROCESS_DATE = SYSDATE WHERE VDSM20_CITYDISTANCE_ID IN (:id) ",nativeQuery = true)
	public Integer updateCityDistance(@Param("id") int id,@Param("sysdist") String sysdist, @Param("autoconfig") String autoconfig,@Param("nextdate") Date nextDate,@Param("process") String process);

}
