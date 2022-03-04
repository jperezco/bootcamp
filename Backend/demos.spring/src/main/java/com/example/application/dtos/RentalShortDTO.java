package com.example.application.dtos;

import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Alquiler", description = "Detalles concretos de los alquileres.")
public class RentalShortDTO {

	@JsonProperty("idAlquiler")
	@ApiModelProperty(notes = "Identificador del alquiler.")
	private int rentalId;
	@JsonProperty("Pelicula")
	@ApiModelProperty(value = "Longitud máxima de 128 caracteres.")
	private String title;
	@JsonProperty("Cliente")
	@ApiModelProperty(value = "Longitud máxima de 45 caracteres para el nombre y 45 para el apellido.")
	private String nombre;


	public static RentalShortDTO from(Rental source) {
		return new RentalShortDTO(
				source.getRentalId(), 
				source.getInventory().getFilm().getTitle(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName()
				);
	}
}
