package com.vds.gmap.vdslitegmap.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vds.gmap.vdslitegmap.entity.AutomaticCityDistance;
import com.vds.gmap.vdslitegmap.entity.AutomaticCitySettings;
import com.vds.gmap.vdslitegmap.entity.GeometricDetails;

@Transactional
@Repository
public class AutomcaticCityDistanceRepoImp {

	@Autowired
	private AutomaticCityDistanceRepo auDistanceRepo;

	@Autowired
	private GeometricDetailsRepo geRepo;

	public List<AutomaticCityDistance> getDetails() {

		List<AutomaticCityDistance> aList  = new ArrayList<AutomaticCityDistance>();
		
	   auDistanceRepo.findAll().stream().forEach((e)->{
		 System.out.println(e.toString()); 
		 AutomaticCitySettings aSettings = new AutomaticCitySettings();
		 aSettings.setSysId(e.getAutoCitySettings().getSysId());
		 aSettings.setPicker(e.getAutoCitySettings().getPicker());
		 aSettings.setAvoidToll(e.getAutoCitySettings().getAvoidToll());
		 aSettings.setAvoidHighways(e.getAutoCitySettings().getAvoidHighways());
		 aSettings.setCombinedMode(e.getAutoCitySettings().getCombinedMode());
		 aSettings.setCombinedPoints(e.getAutoCitySettings().getCombinedPoints());
		 
		 List<GeometricDetails> geDetails = new ArrayList<GeometricDetails>();
		 geDetails.addAll(e.getGeometricDetails());
		 
		 AutomaticCityDistance aCityDistance = new AutomaticCityDistance();
		 aCityDistance.setSysCityID(e.getSysCityID());
		 aCityDistance.setSource(e.getSource());
		 aCityDistance.setDestination(e.getDestination());
		 aCityDistance.setDistance(e.getDistance());
		 aCityDistance.setDuration(e.getDuration());
		 aCityDistance.setTravelMode(e.getTravelMode());
		 aCityDistance.setGeometricDetails(geDetails);
		 aCityDistance.setAutoCitySettings(aSettings);
		 
		 aList.add(aCityDistance);
		 
	   });
		
		return aList;

	}

	public List<AutomaticCityDistance> saveDetails(List<AutomaticCityDistance> auCityDistance) {

		List<AutomaticCityDistance> automaticCityDistances = new ArrayList<AutomaticCityDistance>();

		auCityDistance.forEach((value) -> {
			String waypoints = "";
			Map<String, GeometricDetails> geMap = new HashMap<String, GeometricDetails>();
			for (String way : value.getAutoCitySettings().getWaylocations()) {
				waypoints += way + "~";
			}
			value.getAutoCitySettings()
					.setCombinedPoints((waypoints.length() > 1) ? waypoints.substring(0, waypoints.length() - 1) : "");

			value.getGeometricDetails().stream().forEach((e) -> {
				ArrayList<GeometricDetails> geometricDetails = geRepo
						.findByLatitudeAndLongtitudeAndAddrType(e.getLatitude(), e.getLongtitude(), e.getAddrType())
						.orElse(null);
				if (geometricDetails.size() > 0) {
					boolean flag = true;
					for (GeometricDetails d : geometricDetails) {
						if ((geMap.put(d.getSysCityID(), d) != null) && (e.getAddrType().equalsIgnoreCase("D"))) {
							flag = false;
						}
					}
					if (flag && e.getAddrType().equalsIgnoreCase("D")) {
						automaticCityDistances.add(auDistanceRepo.save(value));
						return;
					}
				} else if (e.getAddrType().equalsIgnoreCase("D")) {
					automaticCityDistances.add(auDistanceRepo.save(value));
					return;
				}
			});
		});

		return automaticCityDistances;

	}

}
