package com.example.application.dtos;

import java.util.Date;
import java.util.List;


import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
@ApiModel(value = "Detalles del alquiler", description = "Informacion detallada de los alquileres.")
public class RentalDetailsDTO {

	@JsonProperty("IdAlquiler")
	@ApiModelProperty(notes = "Identificador del alquiler.")
	private int rentalId;
	@JsonProperty("FechaAlquiler")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(notes = "Fecha de inicio del alquiler")
	private Date rentalDate;
	@JsonProperty("Pelicula")
	@ApiModelProperty(value = "Longitud máxima de 128 caracteres.", notes = "Nombre de la película alquilada")
	private String titulo;
	@JsonProperty("idCliente")
	private int customerid;
	@ApiModelProperty(value = "Longitud máxima de 45 caracteres para el nombre y 45 para el apellido.", notes = "Nombre y apellidos del cliente")
	private String cliente;
	@JsonProperty("fechaDevolucion")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(notes = "Fecha de devolución del alquiler.")
	private Date returnDate;
	@JsonProperty("Empleado")
	@ApiModelProperty(value = "Longitud máxima de 45 caracteres para el nombre y 45 para el apellido.", notes = "Nombre y apellidos del empleado.")
	private String staff;
	@JsonProperty("DatosPago")
	@ApiModelProperty(notes = "Fecha de devolución del alquiler.")
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
