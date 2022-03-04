package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Language;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class RentalEditDTO {
	
	@JsonProperty("IdAlquiler")
	private int rentalId;
	@JsonProperty("FechaAlquiler")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date rentalDate;
	@JsonProperty("idPelicula")
	@NotNull
	private int inventory;
	@JsonProperty("idCliente")
	@NotNull
	private int customerid;
	@JsonProperty("fechaDevolucion")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;
	@JsonProperty("Empleado")
	@NotNull
	private int empleado;
	@JsonProperty("Precio")
	private List<PaymentEditDTO> cantidad;

	public static RentalEditDTO from(Rental source) {
		return new RentalEditDTO(
				source.getRentalId(),
				source.getRentalDate(),
				source.getInventory().getInventoryId(),
				source.getCustomer().getCustomerId(),
				source.getReturnDate() == null ? null : source.getReturnDate(),
				source.getStaff().getStaffId(),
				source.getPayments().stream().map(pago -> PaymentEditDTO.from(pago)).toList()
				);
	}
	
	public static Rental from(RentalEditDTO source) {
		return new Rental(
				source.getRentalId(),
				source.getRentalDate(),
				new Inventory(source.getInventory()),
				new Customer(source.getCustomerid()),
				source.getReturnDate() == null ? null : source.getReturnDate(),
				new Staff(source.getEmpleado())
				);
	}
	
	public Rental update(Rental target) {
		target.setRentalId(rentalId);
		target.setRentalDate(rentalDate);
		target.setInventory(new Inventory(inventory));
		target.setCustomer(new Customer(customerid));
		target.setReturnDate(returnDate);
		target.setStaff(new Staff(empleado));
		
		//Borra los alquileres que sobran.
		var delAlquiladas = target.getPayments().stream()
				.filter(item -> cantidad.stream().noneMatch(pago -> pago.getPaymentId() == item.getPaymentId()))
				.toList();
		delAlquiladas.forEach(item -> target.removePayment(item));
		
		//Actualizo los alquileres que han quedado.
		target.getPayments().forEach(item -> {
			var nuevoPago = cantidad.stream().filter(pago -> pago.getPaymentId() == item.getPaymentId()).findFirst().get();
			if(item.getAmount() != nuevoPago.getAmount()) {
				item.setAmount(nuevoPago.getAmount());
			}
			if(item.getPaymentDate() != nuevoPago.getFecha()) {
				item.setPaymentDate(nuevoPago.getFecha());
			}
			
			if(item.getStaff().getStaffId() != nuevoPago.getEmpleado()) {
				item.setStaff(new Staff(nuevoPago.getEmpleado()));
			}
		});
		
		//Añadimos los alquileres nuevos.
		cantidad.stream()
			.filter(paymentDTO -> target.getPayments().stream().noneMatch(alquiler -> alquiler.getPaymentId() == paymentDTO.getPaymentId()))
			.forEach(paymentDTO -> target.addPayment(new Payment(
					paymentDTO.getPaymentId(), 
					paymentDTO.getAmount(),
					paymentDTO.getFecha(),
					new Staff(paymentDTO.getEmpleado()),
					target)));
		
		return target;
		
	}


}
