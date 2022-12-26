package com.danaide.tiendavirtual.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danaide.tiendavirtual.model.CartProducts;

import jakarta.validation.constraints.NotNull;

@Repository
public interface CartProductRepo extends JpaRepository< CartProducts, String >{

	@Query("select cp from CartProducts cp where cp.cart.oid = :cartOid")
	public Set<CartProducts> findProductsByCartOid( @NotNull @Param("cartOid") String cartOid );
	
	@Query( value = "select sum( p.cantidad_producto ) "
			+ "from cart_products p where p.cart_oid = :cartOid " ,
			nativeQuery = true)
	public Integer cantidadProductosPorCart( @NotNull @Param("cartOid") String cartOid );
	
	
	@Query( value = "select SUM( p.cantidadProducto * p.product.price) "
			+ "from CartProducts p "
			+ "join p.cart c "
			+ "where c.oid = :cartOid " ,
			nativeQuery = false)
	public Integer precioFinalCart( @NotNull @Param("cartOid") String cartOid );
	
	
	@Modifying
	@Query( value = "delete from CartProducts cp where cp.cart.oid = :cartOid ")
	public void deleteByCartOid( @NotNull @Param("cartOid") String cartOid );
	
	@Modifying
	@Query( value = "delete from CartProducts cp where cp.cart.oid = :cartOid and cp.product.oid = :productOid")
	public void deleteProductFromCart( @NotNull @Param("cartOid") String cartOid  , @NotNull @Param("productOid") String productOid  );
	
}



