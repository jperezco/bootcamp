package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PaymentEditDTO {
	
	@JsonProperty("id")
	private int paymentId;
	@JsonProperty("Empleado")
	private int empleado;
	@JsonProperty("Precio")
	private BigDecimal amount;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
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
