package com.danaide.tiendavirtual.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danaide.tiendavirtual.service.ApplicationPropertiesService;

@RestController
@RequestMapping( "/api/priv/applicationProperties" )
public class ApplicationPropertiesController extends BaseRestController {

	private @Autowired ApplicationPropertiesService appService;
	
	@GetMapping("/descuento")
	public Map< String , Object > getDescuentos(){
		return super.executeService( ()->{
			return this.appService.getDescuentos();
		});
	}
	
	
}
