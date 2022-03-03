package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.List;

import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalShortDTO {

	@JsonProperty("id")
	private int rentalId;
	@JsonProperty("titulo")
	private String title;
	@JsonProperty("Cliente")
	private String nombre;
	@JsonProperty("Precio")
	private List<BigDecimal> cantidad;

	public static RentalShortDTO from(Rental source) {
		return new RentalShortDTO(
				source.getRentalId(), 
				source.getInventory().getFilm().getTitle(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName(),
				source.getPayments().stream().map(item -> item.getAmount()).toList()
				);
	}
}
