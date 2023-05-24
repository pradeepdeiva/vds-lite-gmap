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
@Table(name="KVDSM56_GEOMETRIC_DETAILS")
@Data
public class GeometricDetails {
	
	@Id
	@Column(name="VDSM56_GEO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geo_id_seq")
    @SequenceGenerator(name="geo_id_seq", sequenceName = "KVDS_SEQ56_GEOMETRIC_DETAILS_SEQ", allocationSize = 1)
	private long geoId; 
	
	@Column(name="VDSM56_LATITUDE")
	private String latitude;
	
	@Column(name="VDSM56_LONGTITUDE")
	private String longtitude;
	
	@Column(name="VDSM56_LOCATION_TYPE")
	private String locationType;
	
	@Column(name="VDSM56_FORMATTED_ADDRESS")
	private String formattedAddress;
	
	@Column(name="VDSM56_COUNTRY")
	private String country;
	
	@Column(name="VDSM56_PROVINCE")
	private String province;
	
	@Column(name="VDSM56_LOCALITY")
	private String locality;
	
	@Column(name="VDSM56_TYPE")
	private String addrType;
	
	@Column(name="VDSM56_SYS_CITY_ID")
	private String sysCityID;

//	@Embedded
//	@AttributeOverrides({
//        @AttributeOverride(name = "formattedaddr", column = @Column(name = "sourceFormattedAddr")),
//        @AttributeOverride(name = "latlng", column = @Column(name = "sourceLatLng")),
//        @AttributeOverride(name = "loc_type", column = @Column(name = "sourceLoc_Type"))
//    })
//	private GeometricAddress sourceAddress;
//	
//	@Embedded
//	@AttributeOverrides({
//        @AttributeOverride(name = "formattedaddr", column = @Column(name = "destinationFormattedAddr")),
//        @AttributeOverride(name = "latlng", column = @Column(name = "destinationLatLng")),
//        @AttributeOverride(name = "loc_type", column = @Column(name = "destinationLoc_Type"))
//    })
//	private GeometricAddress destinationAddress;

}
