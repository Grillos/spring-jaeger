package com.spring.jaeger.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = -4585073193943206996L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
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
