package com.vds.gmap.vdslitegmap.model;

public class CityDetails {
	
	private String cityDistanceId;
	
	private  String sourceCity;
	
	private String destinationCity;
	
	private String sourceId;
	
	private String destinationId;
	
	private String sourceChinese;
	
	private String destinationChinese;
	
	private String distance;
	
	private String isCompound;
	
	private String nextUpdateDate;
	
	private String autoConfig;
	
	private String updateProcess;
	
	private String sourceLatLng;
	
	private String destinationLatLng;
	
	private boolean autoupdate;
	
	public CityDetails() {}

	public CityDetails(String cityDistanceId, String sourceCity, String destinationCity, String sourceId,
			String destinationId, String sourceChinese, String destinationChinese, String distance, String isCompound,
			String nextUpdateDate, String autoConfig, String updateProcess, String sourceLatLng,
			String destinationLatLng, boolean autoupdate) {
		super();
		this.cityDistanceId = cityDistanceId;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.sourceId = sourceId;
		this.destinationId = destinationId;
		this.sourceChinese = sourceChinese;
		this.destinationChinese = destinationChinese;
		this.distance = distance;
		this.isCompound = isCompound;
		this.nextUpdateDate = nextUpdateDate;
		this.autoConfig = autoConfig;
		this.updateProcess = updateProcess;
		this.sourceLatLng = sourceLatLng;
		this.destinationLatLng = destinationLatLng;
		this.autoupdate = autoupdate;
	}



	public String getUpdateProcess() {
		return updateProcess;
	}


	public void setUpdateProcess(String updateProcess) {
		this.updateProcess = updateProcess;
	}

	public String getCityDistanceId() {
		return cityDistanceId;
	}



	public void setCityDistanceId(String cityDistanceId) {
		this.cityDistanceId = cityDistanceId;
	}



	public String getSourceChinese() {
		return sourceChinese;
	}



	public void setSourceChinese(String sourceChinese) {
		this.sourceChinese = sourceChinese;
	}



	public String getDestinationChinese() {
		return destinationChinese;
	}



	public void setDestinationChinese(String destinationChinese) {
		this.destinationChinese = destinationChinese;
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

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getIsCompound() {
		return isCompound;
	}

	public void setIsCompound(String isCompound) {
		this.isCompound = isCompound;
	}

	public String getNextUpdateDate() {
		return nextUpdateDate;
	}

	public void setNextUpdateDate(String nextUpdateDate) {
		this.nextUpdateDate = nextUpdateDate;
	}

	public String getAutoConfig() {
		return autoConfig;
	}
	
	public void setAutoConfig(String autoConfig) {
		this.autoConfig = autoConfig;
	}


	public String getSourceLatLng() {
		return sourceLatLng;
	}


	public void setSourceLatLng(String sourceLatLng) {
		this.sourceLatLng = sourceLatLng;
	}


	public String getDestinationLatLng() {
		return destinationLatLng;
	}


	public void setDestinationLatLng(String destinationLatLng) {
		this.destinationLatLng = destinationLatLng;
	}

	public boolean isAutoupdate() {
		return autoupdate;
	}

	public void setAutoupdate(boolean autoupdate) {
		this.autoupdate = autoupdate;
	}

}
