package com.spring.jaeger.dto;

import java.util.List;

import com.spring.jaeger.domain.Address;
import com.spring.jaeger.domain.Client;
import com.spring.jaeger.domain.Document;
import com.spring.jaeger.domain.Telephone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDto {
	
	public ClientDto() {}
	
	public ClientDto(Client client) {
		this.id = client.getId();
		this.telephones = client.getTelephones();
		this.documents = client.getDocuments();
		this.address = client.getAddress();
	}
	
    private Long id;
	
    private List<Telephone> telephones;
	
	private List<Document> documents;
	
	private Address address;
	
}
