package com.pca.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A user permission.
 */
@Entity
@Table(name = "PCA_USER_PERMISSIONS")
public class UserPermission extends DefaultModel implements Serializable {

	@JoinColumn(name = "USER_ID")
	@ManyToOne
	private User user;

	@JoinColumn(name = "PERMISSION_ID")
	@ManyToOne
	private Authority authority;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
}
