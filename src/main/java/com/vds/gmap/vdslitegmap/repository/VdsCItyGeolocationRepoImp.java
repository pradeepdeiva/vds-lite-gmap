package com.vds.gmap.vdslitegmap.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class VdsCItyGeolocationRepoImp {
	
	@Autowired
	private VdsCityGeolocationRepo vRepo;

	public List<String> getStateDetails(String country) {
		
		List<String> states = vRepo.findByCountry(country).orElse(null);
		
		return states;
	}

}
