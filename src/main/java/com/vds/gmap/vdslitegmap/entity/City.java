package com.vds.gmap.vdslitegmap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="KVDSM17_CITY")
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
