package com.spring.example.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.spring.example.form.validator.EmailExistsConstraint;
import com.spring.example.form.validator.SelectValueConstraint;
import com.spring.example.form.validator.SizeConstraint;

/**
 *
 * @author ajay
 */

@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public User() {
		/*
		 * By default role was null so when mapped in createUser.jsp
		 * and fetching value in UserController it was throwing NPE
		 * to avoid that situation created role object in constructor.
		 * */ 
		role = new Role();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@NotEmpty
	@SizeConstraint(min=2, max=50)
	@Pattern(regexp = "^[\\p{L} .'-]+$")
	@Column(name = "first_name")
	private String firstName;
	
	@NotEmpty
	@SizeConstraint(min=2, max=50)
	@Pattern(regexp = "^[\\p{L} .'-]+$")
	@Column(name = "last_name")
	private String lastName;
	
	@NotEmpty 
	@Email
	@Length(max=65)
	@EmailExistsConstraint
	@Column(name = "email",unique=true)
	private String email;

	@Length(min=6)
	@Column(name = "password")
	private String password;
	
	@NotNull
	@SelectValueConstraint
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id", referencedColumnName="id")
	private Role role; 
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "account_non_expired")
	private boolean accountNonExpired;
	
	@Column(name = "credentials_non_expired")
	private boolean credentialsNonExpired;
	
	@Column(name = "account_non_locked")
	private boolean accountNonLocked;


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the accountNonExpired
	 */
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	/**
	 * @param accountNonExpired the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @return the credentialsNonExpired
	 */
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	/**
	 * @param credentialsNonExpired the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	/**
	 * @return the accountNonLocked
	 */
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	/**
	 * @param accountNonLocked the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

}