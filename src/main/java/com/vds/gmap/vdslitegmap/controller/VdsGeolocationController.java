package com.vds.gmap.vdslitegmap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vds.gmap.vdslitegmap.repository.VdsCItyGeolocationRepoImp;

@RestController
@RequestMapping("vdsgeolocation/")
public class VdsGeolocationController {
	
	@Autowired
	private VdsCItyGeolocationRepoImp vImp;
	
	@GetMapping(path="details", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getCountryDetails(@RequestParam(name="country") String country){
		return new ResponseEntity<List<String>>(vImp.getStateDetails(country),HttpStatus.OK);
	}

}
