package com.vds.gmap.vdslitegmap.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.Data;

@Embeddable
@Data
public class GeometricAddress {
	
	
	private String formattedaddr;
	private String latlng;
	private String loc_type;
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name = "country", column = @Column(name = "Country_addr",insertable = false, updatable = false)),
        @AttributeOverride(name = "province", column = @Column(name = "Province_addr",insertable = false, updatable = false)),
        @AttributeOverride(name = "locality", column = @Column(name = "Locality_addr",insertable = false, updatable = false))
    })
	public AddressComponent addrcmp;

}
