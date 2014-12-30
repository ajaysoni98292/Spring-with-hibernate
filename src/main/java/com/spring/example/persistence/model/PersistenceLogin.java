package com.spring.example.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 *
 * @author ajay
 */

@Entity
@Table(name = "persistent_logins")
public class PersistenceLogin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "series")
	@Length(max=100)
	@NotNull
	private String series;
	
	@Column(name = "username")
	@Length(max=100)
	@NotNull
	private String username;
	
	
	@Column(name = "token")
	@Length(max=100)
	@NotNull
	private String token;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_used", nullable = false, updatable=true)
	private Date lastUsed;

	/**
	 * @return the series
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(String series) {
		this.series = series;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the lastUsed
	 */
	public Date getLastUsed() {
		return lastUsed;
	}

	/**
	 * @param lastUsed the lastUsed to set
	 */
	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}
	
	
}
