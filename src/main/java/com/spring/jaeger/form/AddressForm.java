package com.spring.jaeger.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressForm {

	@NotNull
	private Long number;
	
	@NotBlank(message = "postal code cannot be empty")
	private String postalCode;
	
	@NotBlank(message = "street cannot be empty")
	private String street;
	
	@NotBlank(message = "state cannot be empty")
	private String state;
	
	@NotBlank(message = "country cannot be empty")
	private String country;
	
	@NotBlank(message = "city cannot be empty")
	private String city;
	
	
}
