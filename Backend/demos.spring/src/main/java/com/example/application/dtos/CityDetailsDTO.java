package com.example.application.dtos;

import com.example.domains.entities.City;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class CityDetailsDTO {

	@JsonProperty("id")
	private int cityId;
	@JsonProperty("city")
	private String city;
	//Vamos a darle el país no como clave, sino como nombre. No le damos 
	//el código 87, le damos "España".
	@JsonProperty("pais")
	private String country;
	
	//Solo lo usaremos para ver datos, no para modificarlos, por lo tanto solo vamos de
	// la entidad al DTO, y no al revés.
	public static CityDetailsDTO from (City source) {
		return new CityDetailsDTO(
				source.getCityId(), 
				source.getCity(),
				source.getCountry().getCountry());
	}
}
