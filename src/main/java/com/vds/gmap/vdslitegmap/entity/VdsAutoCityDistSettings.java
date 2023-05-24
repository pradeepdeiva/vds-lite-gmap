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
@Table(name="KVDSM59_VDS_CITY_SETTINGS")
@Data
public class VdsAutoCityDistSettings {
	
	@Id
	@Column(name="VDSM59_SYS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sys_id_seq")
    @SequenceGenerator(name="sys_id_seq", sequenceName = "KVDS_SEQ59_VDS_CITY_SETTINGS_SEQ", allocationSize = 1)
	private Long sysId;
	
	@Column(name="VDSM59_DEPATURE_TIME")
	private Date picker;
	
	@Column(name="VDSM59_AVOID_TOLL")
	private String avoidToll;
	
	@Column(name="VDSM59_AVOID_HIGHWAY")
	private String avoidHighways;
	
	@Column(name="VDSM59_AUTO_CONFIG_F")
	private String autoConfig;
	
	@Column(name="VDSM59_NEXT_UPDATE_D")
	private Date nextUpdateDate;
	
	@Transient
	private String[] waypoints;

}
