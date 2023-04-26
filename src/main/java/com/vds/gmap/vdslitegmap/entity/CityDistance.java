package com.vds.gmap.vdslitegmap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="KVDSM02_CITY_DISTANCE")
@Data
public class CityDistance {
	
	@Id
	@Column(name="VDSM20_CITYDISTANCE_ID")
	private int cityDistId;
	
	@Column(name="VDSM20_SOURCE_ID")
	private int sourceId;
	
	@Column(name="VDSM20_DESTINATION")
	private int destinationId;
	
	@Column(name="VDSM20_DISTANCE")
	private int distance;

}
