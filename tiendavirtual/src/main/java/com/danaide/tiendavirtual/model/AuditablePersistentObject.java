package com.danaide.tiendavirtual.model;


import java.sql.Timestamp;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditablePersistentObject extends PersistentObject {

	@Column( name = "created_date", updatable = false )
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Timestamp createdDate;

    @Column(name = "created_by" , updatable = false )
    @CreatedBy
    protected String createdBy;

    @Column( name = "update_date" ,  updatable = false )
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Timestamp updateDate;
    
    @Column( name = "update_by" , updatable = false )
    @LastModifiedBy
    protected String updateBy;


	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

    
}
