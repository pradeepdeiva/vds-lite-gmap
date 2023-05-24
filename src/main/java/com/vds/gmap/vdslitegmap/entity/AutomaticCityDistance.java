package com.vds.gmap.vdslitegmap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="KVDSM55_SYSTEM_CITY_DISTANCE")
@Data
public class AutomaticCityDistance  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VDSM55_SYS_CITY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sys_id_seq")
    @SequenceGenerator(name="sys_id_seq", sequenceName = "KVDS_SEQ55_SYSTEM_CITY_DISTANCE_SEQ", allocationSize = 1)
	private long sysCityID;
	
	@Column(name="VDSM55_SOURCE")
	private String source;
	
	@Column(name="VDSM55_DESTINATION")
	private String destination;
	
	@Column(name="VDSM55_DISTANCE")
	private String distance;
	
	@Column(name="VDSM55_DURATION")
	private String duration;
	
	@Column(name="VDSM55_TRAVEL_MODE")
	private String travelMode;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="VDSM56_SYS_CITY_ID",referencedColumnName="VDSM55_SYS_CITY_ID")
	private List<GeometricDetails> geometricDetails;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="VDSM55_SYS_ID")
	private AutomaticCitySettings autoCitySettings;
	
}
