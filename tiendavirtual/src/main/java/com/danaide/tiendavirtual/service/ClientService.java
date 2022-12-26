package com.danaide.tiendavirtual.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danaide.tiendavirtual.dto.ClientBasiDetailscDTO;
import com.danaide.tiendavirtual.enums.CartStatus;
import com.danaide.tiendavirtual.model.Cart;
import com.danaide.tiendavirtual.model.Client;
import com.danaide.tiendavirtual.repository.CartProductRepo;
import com.danaide.tiendavirtual.repository.ClientRepo;

import jakarta.validation.constraints.NotNull;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ClientService {


	private @Autowired ClientRepo clientRepo;

	private @Autowired ModelMapper modelMapper;
	
	
	/**
	 * Metodo que devuelve informacion basica del cliente sumandole la cart que tenga activa por si se quiere hacer una busqueda sobre eso.
	 * @param dni
	 * @return
	 */
	@Transactional( readOnly = true )
	public ClientBasiDetailscDTO getClientBasicDetails( @NotNull String dni ) {
		
		Client client = this.clientRepo.findByDni( dni )
				.orElseThrow( ()-> new RuntimeException("Client with dni : " + dni + " not found."));
		
		ClientBasiDetailscDTO dto = this.modelMapper.map( client, ClientBasiDetailscDTO.class );	
		
		Cart activeCart = this.clientRepo.findClientActiveCart( client.getOid() ).orElse( null );
		
		dto.setActiveCartOid( activeCart != null ? activeCart.getOid() : null );
		
		return dto;
	}


	
}
