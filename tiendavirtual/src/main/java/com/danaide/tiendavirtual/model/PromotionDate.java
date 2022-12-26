package com.danaide.tiendavirtual.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table( name = "promotion_date")
public class PromotionDate extends PersistentObject{

	@NotNull(message = "El dia inical de la promocion es obligatorio.")
	@Column( name = "initial_date" , unique = false , nullable = false )
	@Temporal(TemporalType.DATE )
	private Timestamp initialDate;
	
	@NotNull(message = "El dia final de la promocion es obligatorio.")
	@Column( name = "final_date" , unique = false , nullable = false )
	@Temporal(TemporalType.DATE )
	private Timestamp finishData;
	

	public Timestamp getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Timestamp initialDate) {
		this.initialDate = initialDate;
	}

	public Timestamp getFinishData() {
		return finishData;
	}

	public void setFinishData(Timestamp finishData) {
		this.finishData = finishData;
	}

	
}
