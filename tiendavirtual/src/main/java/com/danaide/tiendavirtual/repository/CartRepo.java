package com.danaide.tiendavirtual.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.danaide.tiendavirtual.enums.CartStatus;
import com.danaide.tiendavirtual.model.Cart;

import jakarta.validation.constraints.NotNull;

@Repository
public interface CartRepo extends JpaRepository< Cart, String >{

	Optional<Cart> findByStatus( CartStatus status );

	@Query( value = "select cart.oid from Cart cart "
			+ "where cart.createdDate < :hourLimit and "
			+ "cart.status = 0 " )
	public List<String> findCartsNotUse( @NotNull Timestamp hourLimit );
	
}
