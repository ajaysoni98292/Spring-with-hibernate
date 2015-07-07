package com.spring.example.persistence.model;

import com.spring.example.form.validator.EmailExistsConstraint;
import com.spring.example.form.validator.SelectValueConstraint;
import com.spring.example.form.validator.SizeConstraint;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author ajay
 */

@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> roleList = new ArrayList<>();
		roleList.add(role.getRole());
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : roleList) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		return email;
	}
}