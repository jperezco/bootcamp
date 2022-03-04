package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Film;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Language;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class RentalDetailsDTO {

	@JsonProperty("IdAlquiler")
	private int rentalId;
	@JsonProperty("FechaAlquiler")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date rentalDate;
	@JsonProperty("Titulo")
	private String titulo;
	@JsonProperty("idCliente")
	private int customerid;
	private String cliente;
	@JsonProperty("fechaDevolucion")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;
	@JsonProperty("Empleado")
	private String staff;
	@JsonProperty("Precio")
	private List<PaymentDetailsDTO> cantidad;

	public static RentalDetailsDTO from(Rental source) {
		return new RentalDetailsDTO(
				source.getRentalId(),
				source.getRentalDate(),
				source.getInventory().getFilm().getTitle(),
				source.getCustomer().getCustomerId(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName(),
				source.getReturnDate() == null ? null : source.getReturnDate(),
				source.getStaff().getFirstName() + " " + source.getStaff().getLastName(),
				source.getPayments().stream().map(pago -> PaymentDetailsDTO.from(pago)).toList()
				);

	}

}
