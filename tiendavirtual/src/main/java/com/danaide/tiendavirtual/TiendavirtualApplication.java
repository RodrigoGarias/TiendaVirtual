package com.danaide.tiendavirtual;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.danaide.tiendavirtual.enums.CartType;
import com.danaide.tiendavirtual.enums.ProductCategory;
import com.danaide.tiendavirtual.model.Cart;
import com.danaide.tiendavirtual.model.Client;
import com.danaide.tiendavirtual.model.Product;
import com.danaide.tiendavirtual.repository.CartRepo;
import com.danaide.tiendavirtual.repository.ClientRepo;
import com.danaide.tiendavirtual.repository.ProductRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.danaide.tiendavirtual.repository")
@EnableScheduling
@EnableJpaAuditing
public class TiendavirtualApplication {

	private @Autowired ClientRepo clientRepo;
	
	private @Autowired ProductRepo poductRepo;
	
	private @Autowired CartRepo cartRepo;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(TiendavirtualApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	      };
	   }
	
}
