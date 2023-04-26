package com.vds.gmap.vdslitegmap.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vds.gmap.vdslitegmap.model.CityDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CityRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public List<CityDetails> getCityDetailsResult() {
		
		StringBuilder str = new StringBuilder();
		
		str.append("SELECT\r\n" + 
				"(SELECT VDSM17_CITY_NAME FROM KVDSM01_CITY WHERE VDSM17_CITY_ID = VDSM20_SOURCE_ID) AS SOURCE,\r\n" + 
				"(SELECT VDSM17_CITY_NAME FROM KVDSM01_CITY WHERE VDSM17_CITY_ID = VDSM20_DESTINATION) AS DESTINATION,\r\n" + 
				"(SELECT VDSM17_CITY_CHINESE_NAME FROM KVDSM01_CITY WHERE VDSM17_CITY_ID = VDSM20_SOURCE_ID) AS SOURCE_CHINESE,\r\n" + 
				"(SELECT VDSM17_CITY_CHINESE_NAME FROM KVDSM01_CITY WHERE VDSM17_CITY_ID = VDSM20_DESTINATION) AS DESTINATION_CHINESE,\r\n" + 
				"VDSM20_DISTANCE\r\n" + 
				"FROM KVDSM02_CITY_DISTANCE ");
		
		Query query =  entityManager.createNativeQuery(str.toString());
		
		List<Object[]> detailsResult = query.getResultList();
		
		List<CityDetails> list = new ArrayList<CityDetails>();
		
		for(Object[] object : detailsResult) {
			CityDetails cityDetails = new CityDetails();
			
			cityDetails.setSourceCity(object[0].toString());
			cityDetails.setDestinationCity(object[1].toString());
			cityDetails.setSourceChineseName(object[2].toString());
			cityDetails.setDestinationChineseName(object[3].toString());
			cityDetails.setDistance(object[4].toString());
			
			list.add(cityDetails);
			
		}
		return list;
		
	}

}
