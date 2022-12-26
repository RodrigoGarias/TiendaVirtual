package com.danaide.tiendavirtual.repository;

import java.awt.print.Pageable;
import java.util.Set;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danaide.tiendavirtual.enums.ProductCategory;
import com.danaide.tiendavirtual.model.Product;

import jakarta.validation.constraints.NotNull;

@Repository
public interface ProductRepo extends JpaRepository< Product , String >{
	
	@Query(  value = "select oid ,active, name , description , expiration_date , price , category , file_image  from Product as prod "
			+ "where "
			+ "( :category is null or prod.category = :category )"
			+ "order by prod.name "
			+ "limit ( :size * ( :page - 1) ) , ( :size * :page )" , 
			nativeQuery = true )
	public Set<Product> pageableList(  @Param("size") Integer size ,  @Param("page") Integer page , @Param("category") Integer category );
	
	
	@Query(  value = "select oid ,active, name , description , expiration_date , price , category , file_image from Product as prod "
			+ "where "
			+ "( :category is null or prod.category = :category )"
			+ "order by prod.name " , 
			nativeQuery = true )
	public Set<Product> completeList( @Param("category") Integer category );
	
	
	@Query(  value = "select count(*) from Product p where p.category = :category" )
	public int getAmountOfProductsByCategory( @NotNull @Param("category") ProductCategory category );
}

