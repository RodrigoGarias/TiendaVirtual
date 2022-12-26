package com.danaide.tiendavirtual.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danaide.tiendavirtual.model.PromotionDate;

import jakarta.validation.constraints.NotNull;

@Repository
public interface PromotionDateRepo extends JpaRepository< PromotionDate, String >{

	@Query( value = "select count(*) from promotion_date pro "
			+ "where :date between pro.initial_date and pro.final_date" , nativeQuery = true )
	public Integer isPromotionDate( @NotNull @Param("date") Date date );
	
	
}



