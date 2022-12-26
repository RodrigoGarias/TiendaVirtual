package com.danaide.tiendavirtual.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danaide.tiendavirtual.model.Cart;
import com.danaide.tiendavirtual.model.Client;
import jakarta.validation.constraints.NotNull;

@Repository
public interface ClientRepo extends JpaRepository< Client , String >{

	public Optional< Client > findByDni( @NotNull String email );

	@Query( value = "select cli.cart from Client cli"
			+ " join cli.cart cart "
			+ "where "
			+ "cli.oid = :clientOid and "
			+ "cart.status = 0")
	public Optional< Cart > findClientActiveCart ( @NotNull String clientOid );
	
}
