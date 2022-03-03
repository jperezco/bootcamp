package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Language;
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
	private int inventory;
	@JsonProperty("idCliente")
	private int customerid;
	@JsonProperty("fechaDevolucion")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;
	@JsonProperty("Empleado")
	private int empleado;
	@JsonProperty("Precio")
	private List<BigDecimal> cantidad;

	public static RentalEditDTO from(Rental source) {
		return new RentalEditDTO(
				source.getRentalId(),
				source.getRentalDate(),
				source.getInventory().getInventoryId(),
				source.getCustomer().getCustomerId(),
				source.getReturnDate(),
				source.getStaff().getStaffId(),
				source.getPayments().stream()
					.map(item -> item.getAmount()).toList()
				);
	}
	
	public static Rental from(RentalEditDTO source) {
		return new Rental(
				source.getRentalId(),
				source.getRentalDate(),
				new Inventory(source.getInventory()),
				new Customer(source.getCustomerid()),
				source.getReturnDate(),
				new Staff(source.getEmpleado()),
				null		
				);
	}
	
	public Rental update(Rental target) {
		target.setRentalId(rentalId);
		target.setRentalDate(rentalDate);
		if(target.getInventory().getInventoryId() != inventory)
			target.setInventory(new Inventory(inventory));
		if(target.getCustomer().getCustomerId() != customerid)
			target.setCustomer(new Customer(customerid));
		target.setReturnDate(returnDate);
		if(target.getStaff().getStaffId() != empleado)
			target.setStaff(new Staff(empleado));
		
	}


}
