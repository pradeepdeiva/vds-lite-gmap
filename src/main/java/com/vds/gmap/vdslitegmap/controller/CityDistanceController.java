package com.vds.gmap.vdslitegmap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vds.gmap.vdslitegmap.model.CityDetails;
import com.vds.gmap.vdslitegmap.repository.CityRepository;

@Controller
@RequestMapping("vdscitydistance/")
public class CityDistanceController {
	
	@Autowired
	private CityRepository cityRepo;
	
	@GetMapping(path="details", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CityDetails>> getCityDetails() {
		
		return new ResponseEntity<List<CityDetails>>(cityRepo.getCityDetailsResult(),HttpStatus.OK);
		
	}

}
