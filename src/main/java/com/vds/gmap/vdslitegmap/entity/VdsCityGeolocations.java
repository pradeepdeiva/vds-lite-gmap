package com.vds.gmap.vdslitegmap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="KVDSM58_VDS_CITY_GEOMETRIC_DETAILS")
@Data
public class VdsCityGeolocations {
	
	@Id
	@Column(name="VDSM58_CITY_GEO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_geo_id_seq")
    @SequenceGenerator(name="city_geo_id_seq", sequenceName = "KVDS_SEQ58_VDS_CITY_GEOMETRIC_DETAILS_SEQ", allocationSize = 1)
	private long geoId; 
	
	@Column(name="VDSM58_LATITUDE")
	private String latitude;
	
	@Column(name="VDSM58_LONGTITUDE")
	private String longtitude;
	
	@Column(name="VDSM58_LOCATION_TYPE")
	private String locationType;
	
	@Column(name="VDSM58_FORMATTED_ADDRESS")
	private String formattedAddress;
	
	@Column(name="VDSM58_COUNTRY")
	private String country;
	
	@Column(name="VDSM58_PROVINCE")
	private String province;
	
	@Column(name="VDSM58_LOCALITY")
	private String locality;
	
	@Column(name="VDSM58_TYPE")
	private String addrType;
	
	@Column(name="VDSM58_CITYDISTANCE_ID")
	private String sysCityID;

}
