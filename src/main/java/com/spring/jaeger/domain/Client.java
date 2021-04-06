package com.spring.jaeger.domain;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.spring.jaeger.form.ClientForm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = -1330120291666923843L;
	
	public Client(ClientForm clientForm) {
		this.name = clientForm.getName();
		this.address = Address.builder()
				.number(clientForm.getAddress().getNumber())
				.postalCode(clientForm.getAddress().getPostalCode())
				.street(clientForm.getAddress().getStreet())
				.state(clientForm.getAddress().getState())
				.country(clientForm.getAddress().getCountry())
				.city(clientForm.getAddress().getCity())
				.build();
		this.telephones = clientForm.getTelephones().stream()
				.map(temp -> Telephone.builder().number(temp.getNumber()).type(temp.getType()).build())
				.collect(Collectors.toList());
		this.documents = clientForm.getDocuments().stream()
				.map(temp -> Document.builder().number(temp.getNumber()).type(temp.getType()).build())
				.collect(Collectors.toList());
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "name cannot be empty")
	private String name;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Telephone> telephones;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Document> documents;
	
}
