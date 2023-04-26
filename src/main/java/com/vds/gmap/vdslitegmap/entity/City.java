package com.vds.gmap.vdslitegmap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="KVDSM01_CITY")
@Data
public class City {
	
	@Id
	@Column(name="VDSM17_CITY_ID")
	private int cityId;
	
	@Column(name="VDSM17_CITY_NAME")
	private String cityName;
	
	@Column(name="VDSM17_CITY_CHINESE_NAME")
	private String cityChineseName;
	
	@Column(name="VDSM17_ACTIVE")
	private String activeFlag;
	

}
