package com.spring.jaeger.form;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientForm {
	
	@NotBlank(message = "name cannot be empty")
	private String name;
	
	@Valid
	private AddressForm address;
	@Valid
	private List<TelephoneForm> telephones;
	@Valid
	private List<DocumentForm> documents;

}
