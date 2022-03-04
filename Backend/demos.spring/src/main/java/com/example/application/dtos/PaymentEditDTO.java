package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class PaymentEditDTO {
	
	@JsonProperty("idPago")
	@ApiModelProperty(notes = "Identificador del pago.")
	private int paymentId;
	@JsonProperty("idEmpleado")
	@ApiModelProperty(value = "Longitud máxima de 45 caracteres para el nombre y 45 para el apellido.", notes = "Nombre y apellidos del empleado.")
	private int empleado;
	@JsonProperty("Precio")
	@ApiModelProperty(value = "Un máximo de 3 dígitos enteros y 2 decimales.", notes = "Precio de la pelicula alquilada")
	private BigDecimal amount;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonProperty("FechaPago")
	@ApiModelProperty(notes = "Fecha del pago realizado")
	private Date fecha;

	public static PaymentEditDTO from(Payment source) {
		return new PaymentEditDTO(
				source.getPaymentId(),
				source.getStaff().getStaffId(),
				source.getAmount(),
				source.getPaymentDate()
				);			
	}
	
	public static Payment from(PaymentEditDTO source, Rental rental) {
		return new Payment(
				source.getPaymentId(),
				source.getAmount(),
				source.getFecha(),
				new Staff (source.getEmpleado()),
				rental
				);			
	}
	

}
