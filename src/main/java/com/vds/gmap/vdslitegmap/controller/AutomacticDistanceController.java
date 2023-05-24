package com.vds.gmap.vdslitegmap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vds.gmap.vdslitegmap.entity.AutomaticCityDistance;
import com.vds.gmap.vdslitegmap.repository.AutomcaticCityDistanceRepoImp;

@RestController
@RequestMapping("automatic/")
public class AutomacticDistanceController {

	@Autowired
	private AutomcaticCityDistanceRepoImp autoCityDistance;

	@GetMapping(path = "cities", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutomaticCityDistance>> getAutomaticDistance() {

		return new ResponseEntity<List<AutomaticCityDistance>>(autoCityDistance.getDetails(), HttpStatus.OK);
	}

	@PostMapping(path="save",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutomaticCityDistance>> createAutomaticDistance(@RequestBody List<AutomaticCityDistance> auCityDistance) {

		return new ResponseEntity<List<AutomaticCityDistance>> (autoCityDistance.saveDetails(auCityDistance), HttpStatus.OK);
	}

}
