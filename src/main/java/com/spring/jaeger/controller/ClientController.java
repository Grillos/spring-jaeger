package com.spring.jaeger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.jaeger.domain.Client;
import com.spring.jaeger.dto.ClientDto;
import com.spring.jaeger.form.ClientForm;
import com.spring.jaeger.service.ClientService;
import com.sun.istack.NotNull;

@RestController
@RequestMapping(value = "/v1/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	 
    @GetMapping
    public Page<ClientDto> findAll(@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pageable) {
    	return clientService.findAll(pageable);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable @NotNull Long id) {
    	ClientDto clientDto = clientService.findById(id);
    	return (clientDto != null) ? new ResponseEntity<>(clientDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody @Valid ClientForm clientForm, UriComponentsBuilder uri) {
    	ClientDto clientDto = clientService.create(new Client(clientForm));
    	
    	return ResponseEntity.created(
    			uri.path("/users/{id}").buildAndExpand(clientDto.getId()).toUri()).body(clientDto);
    }
    
    @PutMapping("/{id}")
    public void send(@PathVariable Long id, @RequestBody @Valid Client user) {
    	clientService.update(id, user);
    }
    
}
