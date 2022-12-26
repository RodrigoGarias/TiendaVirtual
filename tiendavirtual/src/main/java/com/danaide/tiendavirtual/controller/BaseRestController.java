package com.danaide.tiendavirtual.controller;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.danaide.tiendavirtual.commons.ServiceExecution;
import com.danaide.tiendavirtual.commons.VoidServiceExecution;


public abstract class BaseRestController {

private static final Logger logger = LoggerFactory.getLogger(BaseRestController.class.getName());
	
	protected @Autowired ModelMapper modelMapper; 

	public BaseRestController() {
		super();
	}
	
	protected Map<String, Object> executeService( ServiceExecution e ) {
		Map<String, Object> res = new HashMap<>();
		try {
			Object r = e.execute();
			res.put("result", r);
		} catch (Exception e2) {
			logger.error("Error",e2);
			res.put("result", "Error");
			res.put("error", e2.getMessage());
		}
		return res;
	}

	protected Map<String, Object> executeVoidService( VoidServiceExecution e ) {
		Map<String, Object> res = new HashMap<>();
		try {
			e.execute();
			res.put("result", "ok");
		} catch (Exception e2) {
			logger.error("Error",e2);
			res.put("result", "Error");
			res.put("error", e2.getMessage());
		}
		return res;
	}

	
}
