package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.example.domains.entities.Payment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
@ApiModel(value = "Pago", description = "Detalles del pago realizado.")
public class PaymentDetailsDTO {
	
	@JsonProperty("idPago")
	@ApiModelProperty(notes = "Identificador del pago.")
	private int paymentId;
	@JsonProperty("Empleado")
	@ApiModelProperty(value = "Longitud máxima de 45 caracteres para el nombre y 45 para el apellido.", notes = "Nombre y apellidos del empleado.")
	private String empleado;
	@JsonProperty("Precio")
	@ApiModelProperty(value = "Un máximo de 3 dígitos enteros y 2 decimales.", notes = "Precio de la pelicula alquilada")
	private BigDecimal amount;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonProperty("FechaPago")
	@ApiModelProperty(notes = "Fecha del pago realizado")
	private Date fecha;

	public static PaymentDetailsDTO from(Payment source) {
		return new PaymentDetailsDTO(
				source.getPaymentId(),
				source.getStaff().getFirstName() + " " + source.getStaff().getLastName(),
				source.getAmount(),
				source.getPaymentDate()
				);			
	}
	

}
