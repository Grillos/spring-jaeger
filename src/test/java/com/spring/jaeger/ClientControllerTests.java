package com.spring.jaeger;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.jaeger.dto.ClientDto;
import com.spring.jaeger.service.ClientService;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTests {
	
	
	private ClientDto clientDto;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClientService clientService;
	
	@Test
	public void shouldReturnFindByIdClient() throws Exception {
		when(clientService.findById(1L)).thenReturn(clientDto);
		this.mockMvc.perform(get("/v1/client/1")).andExpect(status().isOk());
		
	}

}
