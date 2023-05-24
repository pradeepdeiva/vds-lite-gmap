package com.vds.gmap.vdslitegmap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="KVDSM13_COMPOUNDSETUP")
@Data
public class CompoundSetup {
	
	@Id
	@Column(name="VDSM13_COMPOUND_ID")
	private int compound_id;
	
	@Column(name="VDSM13_COMPOUND_NAME")
	private String compoundName;
	
	@Column(name="VDSM17_CITY_ID")
	private int cityId;
	
	@OneToOne
	@JoinColumn(name="VDSM17_CITY_ID", insertable=false, updatable=false)
	private City city;
	
}
