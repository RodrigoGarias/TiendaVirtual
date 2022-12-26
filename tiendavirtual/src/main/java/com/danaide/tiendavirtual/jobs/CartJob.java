package com.danaide.tiendavirtual.jobs;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.danaide.tiendavirtual.service.CartService;


@Component
public class CartJob {

	private static final Logger logger = LoggerFactory.getLogger( CartJob.class.getName() );
	
	private @Autowired CartService cartService;
	
	@Scheduled( cron = "0 */5 * ? * *" )
    public void deleteUnusedCarts() {
		
		this.logger.info("Comenzando proceso de eliminacion de carts no utilizadas");
		
		this.cartService.findUnsedCarts( new Date() )
		.stream()
		.forEach( t -> {
			try {
				this.cartService.deleteCart(t);
			} catch (Exception e) {}
		});
		
		this.logger.info("Finalizando proceso de eliminacion de carts no utilizadas");
   }
	
	
}
