package com.example.application.dtos;

import com.example.domains.entities.City;
import com.example.domains.entities.Country;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class CityEditDTO {
	
	@JsonProperty("id")
	private int cityId;
	@JsonProperty("city")
	private String city;
	//Este DTO se usa para editar la BBDD. Aquí sí manejamos la clave.
	@JsonProperty("pais")
	private int country;
	
	//Dos direcciones porque usaremos este DTO para ver y para modificar datos.
	public static CityEditDTO from(City source) {
		return new CityEditDTO(
				source.getCityId(), 
				source.getCity(),
				source.getCountry().getCountryId());
	}
	
	public static City from(CityEditDTO source) {
		return new City(
				source.getCityId(), 
				source.getCity(),
				new Country(source.getCountry())
				);
	}


}
