package com.vds.gmap.vdslitegmap.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vds.gmap.vdslitegmap.entity.CityDistance;
import com.vds.gmap.vdslitegmap.model.CityDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Repository
public class CityRepositoryImp {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private CityDistanceRepository cityRepository;
	
	@Autowired
	private VdsCityGeolocationRepo vdRepo;

	public List<CityDetails> getCityDetailsResult(String pag, String size, String process) {

		
		  List<CityDetails> list = new ArrayList<CityDetails>();
		  
		 /* Pageable pageable = PageRequest.of(Integer.valueOf(pag),
		  Integer.valueOf(size));
		  
		  Page<CityDistance> page = cityRepository.findAll(pageable);
		  
		  long total = cityRepository.count();
		  
		  cityRepository.findAll().stream().forEach((e) -> { CityDetails cityDetails =
		  new CityDetails(); if (e.getIsCompound().equals("Y")) {
		  cityDetails.setSourceCity( e.getSourceCmp().getCity().getCityName() != null ?
		  e.getSourceCmp().getCity().getCityName() : "");
		  cityDetails.setDestinationCity( e.getDestinationCmp().getCity().getCityName()
		  != null ? e.getDestinationCmp().getCity().getCityName() : "");
		  cityDetails.setSourceChineseName(e.getSourceCmp().getCity().
		  getCityChineseName());
		  cityDetails.setDestinationChineseName(e.getDestinationCmp().getCity().
		  getCityChineseName());
		  cityDetails.setDistance(String.valueOf(e.getDistance()));
		  cityDetails.setIsCompound("Y"); cityDetails.setTotalCount(total);
		  
		  } else { cityDetails .setSourceCity(e.getSourceCity().getCityName() != null ?
		  e.getSourceCity().getCityName() : ""); cityDetails.setDestinationCity(
		  (e.getDestiantionCity() != null && e.getDestiantionCity().getCityName() !=
		  null) ? e.getDestiantionCity().getCityName() : "");
		  cityDetails.setSourceChineseName(e.getSourceCity().getCityChineseName());
		  cityDetails.setDestinationChineseName(e.getDestiantionCity() != null ?
		  e.getDestiantionCity().getCityChineseName() : "" );
		  cityDetails.setDistance(String.valueOf(e.getDistance()));
		  cityDetails.setIsCompound("N"); cityDetails.setTotalCount(total); }
		  
		  list.add(cityDetails);
		  
		  });
		 */

			StringBuilder str = new StringBuilder();
			
			str.append("SELECT * FROM (");
			str.append("SELECT ROW_NUMBER() OVER(ORDER BY VDSM20_CITYDISTANCE_ID) row_num,");
			str.append("VDSM20_CITYDISTANCE_ID AS CITY_DISTANCE_ID,");
			str.append("DECODE(NVL(VDSM20_IS_COMPOUND,'N'),'Y',(SELECT VDSM17_CITY_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = (SELECT VDSM17_CITY_ID FROM KVDSM13_COMPOUNDSETUP WHERE VDSM13_COMPOUND_ID = CT.VDSM13_COMPOUND_ID)),");
			str.append("(SELECT VDSM17_CITY_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = VDSM13_COMPOUND_ID)) AS SOURCE,");
			str.append("DECODE(NVL(VDSM20_IS_COMPOUND,'N'),'Y',(SELECT VDSM17_CITY_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = (SELECT VDSM17_CITY_ID FROM KVDSM13_COMPOUNDSETUP WHERE VDSM13_COMPOUND_ID = CT.VDSM20_DESTINATION)),");
			str.append("(SELECT VDSM17_CITY_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = VDSM20_DESTINATION)) AS DESTINATION,");
			str.append("DECODE(NVL(VDSM20_IS_COMPOUND,'N'),'Y',(SELECT VDSM17_CITY_CHINESE_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = (SELECT VDSM17_CITY_ID FROM KVDSM13_COMPOUNDSETUP  WHERE VDSM13_COMPOUND_ID = CT.VDSM13_COMPOUND_ID)),");str.append("(SELECT VDSM17_CITY_CHINESE_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = VDSM13_COMPOUND_ID)) AS SOURCE_CHINESE,");
			str.append("DECODE(NVL(VDSM20_IS_COMPOUND,'N'),'Y',(SELECT VDSM17_CITY_CHINESE_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = (SELECT VDSM17_CITY_ID FROM KVDSM13_COMPOUNDSETUP WHERE VDSM13_COMPOUND_ID = CT.VDSM20_DESTINATION)),");
			str.append("(SELECT VDSM17_CITY_CHINESE_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = VDSM20_DESTINATION)) AS DESTINATION_CHINESE,");
			str.append("VDSM13_COMPOUND_ID AS SOURCE_ID, VDSM20_DESTINATION AS DESTINATION_ID, VDSM20_DISTANCE,VDSM20_IS_COMPOUND,VDSM20_AUTO_CONFIG,VDSM20_UPDATE_PROCESS,VDSM20_NEXT_UPDATE_D ");
					
					if(process.equalsIgnoreCase("N")) {
						str.append(" FROM KVDSM20_CITY_DISTANCE CT WHERE 1=1 AND VDSM20_CITYDISTANCE_ID NOT IN (SELECT DISTINCT VDSM58_CITYDISTANCE_ID FROM KVDSM58_VDS_CITY_GEOMETRIC_DETAILS CD ) ");
					}else {
						str.append(" ,SUBSTR(SUBSTR(LAT_LNG,0,LENGTH(LAT_LNG)-1),0,INSTR(SUBSTR(LAT_LNG,0,LENGTH(LAT_LNG)-1),'~')-1) AS SOURCE_LAT_LNG,");
						str.append(" SUBSTR(SUBSTR(LAT_LNG,0,LENGTH(LAT_LNG)-1),INSTR(SUBSTR(LAT_LNG,0,LENGTH(LAT_LNG)-1),'~')+1,LENGTH(LAT_LNG)-1) AS DESTINATION_LAT_LNG");
						str.append(" FROM KVDSM20_CITY_DISTANCE CT INNER JOIN (SELECT VDSM58_CITYDISTANCE_ID,LISTAGG(TO_CHAR(VDSM58_LATITUDE) || ',' ||TO_CHAR(VDSM58_LONGTITUDE) || '~') WITHIN GROUP (ORDER BY VDSM58_TYPE DESC) AS LAT_LNG  FROM KVDSM58_VDS_CITY_GEOMETRIC_DETAILS GROUP BY VDSM58_CITYDISTANCE_ID) GL ");
						str.append(" ON VDSM20_CITYDISTANCE_ID = GL.VDSM58_CITYDISTANCE_ID ");
						str.append(" AND NVL(VDSM20_AUTO_CONFIG,'N') <> 'N'");
						str.append(" AND TO_CHAR(VDSM20_NEXT_UPDATE_D,'DD-MM-YYYY') = TO_CHAR(SYSDATE,'DD-MM-YYYY') ");
					}
					str.append(" ) WHERE row_num >= "+pag+"	 and row_num <= "+size);

			Query query = entityManager.createNativeQuery(str.toString());

			List<Object[]> detailsResult = query.getResultList();

			for (Object[] object : detailsResult) {
				CityDetails cityDetails = new CityDetails();

				cityDetails.setCityDistanceId(object[1] != null ? object[1].toString() : "");
				cityDetails.setSourceCity(object[2] != null ? object[2].toString().replace("'", "") : "");
				cityDetails.setDestinationCity(object[3] != null ? object[3].toString().replace("'", "") : "");
				cityDetails.setSourceChinese(object[4] != null ? object[4].toString() : "");
				cityDetails.setDestinationChinese(object[5] != null ? object[5].toString() : "");
				cityDetails.setSourceId(object[6] != null ? object[6].toString() : "");
				cityDetails.setDestinationId(object[7] != null ? object[7].toString() : "");
				cityDetails.setDistance(object[8] != null ? object[8].toString() : "");
				cityDetails.setIsCompound(object[9] != null ? object[9].toString() : "");
				cityDetails.setAutoConfig(object[10] != null ? object[10].toString() : "");
				cityDetails.setUpdateProcess(object[11] != null ? object[11].toString() : "");
				cityDetails.setNextUpdateDate(object[12] != null ? object[12].toString() : ""); 
				
				if(!process.equalsIgnoreCase("N")) {
					cityDetails.setSourceLatLng(object[13] != null ? object[13].toString() : "");
					cityDetails.setDestinationLatLng(object[14] != null ? object[14].toString() : "");
				}

				list.add(cityDetails);

			}
		System.out.println(list.size());
		return list;
	}

	public List<CityDistance> saveCityDistance(List<CityDistance> ciList) {
		
		List<CityDistance> cityDistancesList = new ArrayList<CityDistance>();
		

		/* ciList.stream().forEach((value) -> {
			Map<String, VdsCityGeolocations> geMap = new HashMap<String, VdsCityGeolocations>();

			if((cityRepository.findbyId(value.getCityDistId())).isPresent()) {
				Integer updateCount = cityRepository.updateCityDistance(value.getCityDistId(), value.getSystemDistance(), value.getAutoConfig(), value.getNextUpdateDate(),value.getUpdateProcess());
				System.out.println(updateCount);
			}
			
			value.getVdsCityGeolocations().stream().forEach((e) -> {
				ArrayList<VdsCityGeolocations> vdGeolocations = vdRepo
						.findByLatitudeAndLongtitudeAndAddrType(e.getLatitude(), e.getLongtitude(), e.getAddrType())
						.orElse(null);
				if (vdGeolocations.size() > 0) {
					boolean flag = true;
					for (VdsCityGeolocations d : vdGeolocations) {
						if ((geMap.put(d.getSysCityID(), d) != null) && (e.getAddrType().equalsIgnoreCase("D"))) {
							flag = false;
						}
					}
					if (flag && e.getAddrType().equalsIgnoreCase("D")) {
						cityDistancesList.add(cityRepository.save(value));
						return;
					}
				} else if (e.getAddrType().equalsIgnoreCase("D")) {
					cityDistancesList.add(cityRepository.save(value));
					return;
				}
			});
		}); */
		
		ciList.stream().forEach((value) -> {
			
			String cityDistId = cityRepository.findbyId(value.getCityDistId()).orElse(null);
			
			if(cityDistId != null) {
				if(!(vdRepo.findbyCityDistId(value.getCityDistId()).isPresent())) {
					cityDistancesList.add(cityRepository.save(value));
				}else {
					Integer updateCount = cityRepository.updateCityDistance(value.getCityDistId(), value.getSystemDistance(), value.getAutoConfig(), value.getNextUpdateDate(),value.getUpdateProcess());
					System.out.println(updateCount);
					cityDistancesList.add(value);
					}
				}
			});
		
		return cityDistancesList;
	}

	public List<CityDistance> updateCityDistance(List<CityDistance> cityDistances) {
		
		List<CityDistance> cityDistancesList = new ArrayList<CityDistance>();
		
		cityDistances.stream().forEach((value) -> {
			if(cityRepository.findbyId(value.getCityDistId()).isPresent()) {
				Integer updateCount = cityRepository.updateCityDistance(value.getCityDistId(), value.getSystemDistance(), value.getAutoConfig(), value.getNextUpdateDate(),value.getUpdateProcess());
				System.out.println(updateCount);
				cityDistancesList.add(value);
			}
		});
		
		return cityDistancesList;
	}

	public List<CityDetails> getSystemCityDistance(String country, String province) {
		
		
		List<CityDetails> list = new ArrayList<CityDetails>();
		StringBuilder str = new StringBuilder();
		
		str.append("SELECT * FROM ");
		str.append("(SELECT VDSM20_CITYDISTANCE_ID AS CITY_DISTANCE_ID,");
		str.append("DECODE(NVL(VDSM20_IS_COMPOUND,'N'),'Y',(SELECT VDSM17_CITY_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = (SELECT VDSM17_CITY_ID FROM KVDSM13_COMPOUNDSETUP WHERE VDSM13_COMPOUND_ID = CT.VDSM13_COMPOUND_ID)),");
		str.append("(SELECT VDSM17_CITY_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = VDSM13_COMPOUND_ID)) AS SOURCE,");
		str.append("DECODE(NVL(VDSM20_IS_COMPOUND,'N'),'Y',(SELECT VDSM17_CITY_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = (SELECT VDSM17_CITY_ID FROM KVDSM13_COMPOUNDSETUP WHERE VDSM13_COMPOUND_ID = CT.VDSM20_DESTINATION)),");
		str.append("(SELECT VDSM17_CITY_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = VDSM20_DESTINATION)) AS DESTINATION,");
		str.append("DECODE(NVL(VDSM20_IS_COMPOUND,'N'),'Y',(SELECT VDSM17_CITY_CHINESE_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = (SELECT VDSM17_CITY_ID FROM KVDSM13_COMPOUNDSETUP  WHERE VDSM13_COMPOUND_ID = CT.VDSM13_COMPOUND_ID)),");str.append("(SELECT VDSM17_CITY_CHINESE_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = VDSM13_COMPOUND_ID)) AS SOURCE_CHINESE,");
		str.append("DECODE(NVL(VDSM20_IS_COMPOUND,'N'),'Y',(SELECT VDSM17_CITY_CHINESE_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = (SELECT VDSM17_CITY_ID FROM KVDSM13_COMPOUNDSETUP WHERE VDSM13_COMPOUND_ID = CT.VDSM20_DESTINATION)),");
		str.append("(SELECT VDSM17_CITY_CHINESE_NAME FROM KVDSM17_CITY WHERE VDSM17_CITY_ID = VDSM20_DESTINATION)) AS DESTINATION_CHINESE,");
		str.append("VDSM13_COMPOUND_ID AS SOURCE_ID, VDSM20_DESTINATION AS DESTINATION_ID, VDSM20_SYSTEM_DISTANCE,VDSM20_IS_COMPOUND,VDSM20_AUTO_CONFIG,VDSM20_UPDATE_PROCESS,VDSM20_NEXT_UPDATE_D ");
		str.append(",SUBSTR(SUBSTR(LAT_LNG,0,LENGTH(LAT_LNG)-1),0,INSTR(SUBSTR(LAT_LNG,0,LENGTH(LAT_LNG)-1),'~')-1) AS SOURCE_LAT_LNG,");  
        str.append("SUBSTR(SUBSTR(LAT_LNG,0,LENGTH(LAT_LNG)-1),INSTR(SUBSTR(LAT_LNG,0,LENGTH(LAT_LNG)-1),'~')+1,LENGTH(LAT_LNG)-1) AS DESTINATION_LAT_LNG "); 
		str.append("FROM KVDSM20_CITY_DISTANCE CT INNER JOIN (SELECT VDSM58_CITYDISTANCE_ID,LISTAGG(TO_CHAR(VDSM58_LATITUDE) || ',' ||TO_CHAR(VDSM58_LONGTITUDE) || '~') WITHIN GROUP (ORDER BY VDSM58_TYPE DESC) AS LAT_LNG  FROM KVDSM58_VDS_CITY_GEOMETRIC_DETAILS GROUP BY VDSM58_CITYDISTANCE_ID) GL "); 
        str.append(" ON VDSM20_CITYDISTANCE_ID = GL.VDSM58_CITYDISTANCE_ID)");
		str.append("WHERE CITY_DISTANCE_ID IN (SELECT VDSM58_CITYDISTANCE_ID FROM KVDSM58_VDS_CITY_GEOMETRIC_DETAILS GT WHERE GT.VDSM58_TYPE = 'S' ");
		
		if(!country.equals("null") && !province.equals("null")) {
		str.append(" AND UPPER(GT.VDSM58_COUNTRY) = '"+country.toUpperCase()+"'");
		str.append(" AND UPPER(GT.VDSM58_PROVINCE) = '"+province.toUpperCase()+"')");
		}else if(!country.equals("null")) {
			str.append(" AND UPPER(GT.VDSM58_COUNTRY) = '"+country.toUpperCase()+"')");
		}		
		
		Query query = entityManager.createNativeQuery(str.toString());

		List<Object[]> detailsResult = query.getResultList();

		for (Object[] object : detailsResult) {
			CityDetails cityDetails = new CityDetails();

			cityDetails.setCityDistanceId(object[0] != null ? object[0].toString() : "");
			cityDetails.setSourceCity(object[1] != null ? object[1].toString().replace("'", "") : "");
			cityDetails.setDestinationCity(object[2] != null ? object[2].toString().replace("'", "") : "");
			cityDetails.setSourceChinese(object[3] != null ? object[3].toString() : "");
			cityDetails.setDestinationChinese(object[4] != null ? object[4].toString() : "");
			cityDetails.setSourceId(object[5] != null ? object[5].toString() : "");
			cityDetails.setDestinationId(object[6] != null ? object[6].toString() : "");
			cityDetails.setDistance(object[7] != null ? object[7].toString() : "");
			cityDetails.setIsCompound(object[8] != null ? object[8].toString() : "");
			cityDetails.setAutoConfig(object[9] != null ? object[9].toString() : "");
			cityDetails.setAutoupdate(cityDetails.getAutoConfig().equals("N") ? false : true);
			cityDetails.setUpdateProcess(object[10] != null ? object[10].toString() : "");
			cityDetails.setNextUpdateDate(object[11] != null ? object[11].toString() : "");
			cityDetails.setSourceLatLng(object[12] != null ? object[12].toString() : "");
			cityDetails.setDestinationLatLng(object[13] != null ? object[13].toString() : "");

			list.add(cityDetails);

		}
		System.out.println(list.size());
		return list;

		
		
		
	}

}
