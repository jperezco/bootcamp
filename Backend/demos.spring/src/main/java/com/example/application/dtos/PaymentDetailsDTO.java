package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.example.domains.entities.Payment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PaymentDetailsDTO {
	
	@JsonProperty("id")
	private int paymentId;
	@JsonProperty("Empleado")
	private String empleado;
	@JsonProperty("Precio")
	private BigDecimal amount;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fecha;

	public static PaymentDetailsDTO from(Payment source) {
		return new PaymentDetailsDTO(
				source.getPaymentId(),
				source.getStaff().getFirstName() + "" + source.getStaff().getLastName(),
				source.getAmount(),
				source.getPaymentDate()
				);			
	}
	

}
