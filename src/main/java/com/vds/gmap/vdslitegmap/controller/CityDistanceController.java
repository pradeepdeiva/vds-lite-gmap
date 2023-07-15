package com.vds.gmap.vdslitegmap.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vds.gmap.vdslitegmap.entity.CityDistance;
import com.vds.gmap.vdslitegmap.model.CityDetails;
import com.vds.gmap.vdslitegmap.repository.CityRepositoryImp;

@RestController
@RequestMapping("vdscitydistance/")
public class CityDistanceController {
	
	@Autowired
	private CityRepositoryImp cityRepo;
	
	@GetMapping(path="details", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CityDetails>> getCityDetails(@RequestParam(name="page") String pag,@RequestParam("size") String size, @RequestParam(name="process") String process) {	
		
		return new ResponseEntity<List<CityDetails>>(cityRepo.getCityDetailsResult(pag,size,process),HttpStatus.OK);
		
	}
	
	@PostMapping(path="save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CityDistance>> getSystemCityDistance(@RequestBody List<CityDistance>ciList ){
		return new ResponseEntity<List<CityDistance>>(cityRepo.saveCityDistance(ciList),HttpStatus.OK);
		
	}
	
	@PutMapping(path="update", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CityDistance>> getUpdateSysCityDistance(@RequestBody List<CityDistance> cityDistances){
		return new ResponseEntity<List<CityDistance>>(cityRepo.updateCityDistance(cityDistances), HttpStatus.OK);
		
	}
	
	@GetMapping(path="citydetails", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CityDetails>> getSystemCityDistance(@RequestParam(name="country") String country, @RequestParam(name="province") Optional<String> province){
		
		return new ResponseEntity<List<CityDetails>>(cityRepo.getSystemCityDistance(country,province.orElse(null)), HttpStatus.OK);
		
	}
	

}
