package com.vds.gmap.vdslitegmap.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class AddressComponent {

	private String country;
	
	private String province;
	
	private String locality;
}
