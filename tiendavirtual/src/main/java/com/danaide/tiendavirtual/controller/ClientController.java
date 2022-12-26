package com.danaide.tiendavirtual.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.danaide.tiendavirtual.dto.ClientBasiDetailscDTO;
import com.danaide.tiendavirtual.model.Cart;
import com.danaide.tiendavirtual.model.Client;
import com.danaide.tiendavirtual.service.ClientService;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping( "/api/priv/client" )
public class ClientController extends BaseRestController {

	private @Autowired ClientService clientService;
	
	
	public ClientController() {
		super();
	}
	
	/**
	 * Endpoint that returns the basic personal information of the client.
	 * @param dni
	 * @return
	 */
	@GetMapping( value = "/basic/{dni}" , produces = MediaType.APPLICATION_JSON_VALUE )
	public Map<String,Object> getClientBasicDetails( @NotNull @PathVariable String dni ) {
		return super.executeService( ()-> {
			return this.clientService.getClientBasicDetails( dni );
		});
	}
		
	
}
