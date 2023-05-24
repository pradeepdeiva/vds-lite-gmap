package com.vds.gmap.vdslitegmap.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="KVDSM20_CITY_DISTANCE")
@Data
public class CityDistance {
	
	@Id
	@Column(name="VDSM20_CITYDISTANCE_ID")
	private int cityDistId;
	
	/* @Column(name="VDSM13_COMPOUND_ID")
	private int sourceId;
	
	@Column(name="VDSM20_DESTINATION")
	private int destinationId;
	
	@Column(name="VDSM20_DISTANCE")
	private int distance;
	
	@Column(name="VDSM20_IS_COMPOUND")
	private String isCompound; */
	
	@Column(name="VDSM20_SYSTEM_DISTANCE")
	private String systemDistance;
	
	@Column(name="VDSM20_AUTO_CONFIG")
	private String autoConfig;
	
	@Column(name="VDSM20_NEXT_UPDATE_D")
	private Date nextUpdateDate;
	
	@Column(name="VDSM20_UPDATE_PROCESS")
	private String updateProcess;
	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="VDSM13_COMPOUND_ID", insertable=false, updatable=false)
//	@NotFound(action = NotFoundAction.IGNORE)
//	private City sourceCity;
//	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="VDSM20_DESTINATION", insertable=false, updatable=false)
//	@NotFound(action = NotFoundAction.IGNORE)
//	private City destiantionCity;
//	
//	@ManyToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name = "VDSM13_COMPOUND_ID", nullable = true, insertable=false, updatable=false)
//	@NotFound(action = NotFoundAction.IGNORE)
//	private CompoundSetup sourceCmp;
//	
//	@ManyToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name = "VDSM20_DESTINATION", nullable = true, insertable=false, updatable=false)
//	@NotFound(action = NotFoundAction.IGNORE)
//	private CompoundSetup destinationCmp;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="VDSM58_CITYDISTANCE_ID",referencedColumnName="VDSM20_CITYDISTANCE_ID")
	private List<VdsCityGeolocations> vdsCityGeolocations;
	
//	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	@JoinColumn(name="VDSM20_SYS_ID")
//	private AutomaticCitySettings autoCitySettings;
	
	
}
