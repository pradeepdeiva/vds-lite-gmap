package com.vds.gmap.vdslitegmap.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name="KVDSM57_SYSTEM_CITY_SETTINGS")
@Data
public class AutomaticCitySettings {
	
	@Id
	@Column(name="VDSM57_SYS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "KVDS_SEQ57_SYSTEM_CITY_SETTINGS_SEQ", allocationSize = 1)
	private Long sysId;
	
	@Column(name="VDSM57_DEPATURE_TIME")
	private Date picker;
	
	@Column(name="VDSM57_AVOID_TOLL")
	private String avoidToll;
	
	@Column(name="VDSM57_AVOID_HIGHWAY")
	private String avoidHighways;
	
	@Column(name="VDSM57_COMBINED_MODE")
	private String combinedMode;
	
	@Column(name="VDSM57_WAYPOINT")
	private String combinedPoints;
	
	@Transient
	private String[] waylocations;

}
