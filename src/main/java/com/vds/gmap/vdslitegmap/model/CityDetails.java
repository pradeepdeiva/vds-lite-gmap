package com.vds.gmap.vdslitegmap.model;


public class CityDetails {
	
	private  String sourceCity;
	
	private String destinationCity;
	
	private String sourceChineseName;
	
	private String destinationChineseName;
	
	private String distance;
	
	public CityDetails() {}

	public CityDetails(String sourceCity, String destinationCity, String sourceChineseName,
			String destinationChineseName, String distance) {
		super();
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.sourceChineseName = sourceChineseName;
		this.destinationChineseName = destinationChineseName;
		this.distance = distance;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getSourceChineseName() {
		return sourceChineseName;
	}

	public void setSourceChineseName(String sourceChineseName) {
		this.sourceChineseName = sourceChineseName;
	}

	public String getDestinationChineseName() {
		return destinationChineseName;
	}

	public void setDestinationChineseName(String destinationChineseName) {
		this.destinationChineseName = destinationChineseName;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	

}
