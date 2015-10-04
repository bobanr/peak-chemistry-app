package com.pca.domain;


import java.util.Date;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Base abstract class for entities which will hold definitions for created,
 * last modified by and created, last modified by date.
 */
@MappedSuperclass
@Audited
@EntityListeners(AuditingEntityListener.class)
public abstract class DefaultModel {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private long id;

	@CreatedBy
	@NotNull
	@Column(name = "CREATOR")
	private long creator = 1l;

	@CreatedDate
	@NotNull
	@Column(name = "DATE_CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated = new Date();

	@LastModifiedBy
	@Column(name = "LAST_MODIFIER")
	private long lastModifier = 1l;

	@LastModifiedDate
	@Column(name = "DATE_LAST_UPDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateLastUpdate = new Date();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCreator() {
		return creator;
	}

	public void setCreator(long creator) {
		this.creator = creator;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public long getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(long lastModifier) {
		this.lastModifier = lastModifier;
	}

	public Date getDateLastUpdate() {
		return dateLastUpdate;
	}

	public void setDateLastUpdate(Date dateLastUpdate) {
		this.dateLastUpdate = dateLastUpdate;
	}
}