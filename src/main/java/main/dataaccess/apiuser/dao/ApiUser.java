package main.dataaccess.apiuser.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import main.dataaccess.common.NamePersistent;


@Entity
@Table(name = "api_user")
public class ApiUser extends NamePersistent {
	
	@Column(name = "display_name", nullable=false, length=100, columnDefinition="varchar(100) not null default ''")
	private String displayName;
	
	@Column(name = "email", length=100, columnDefinition="varchar(100) not null default ''")
	private String email;
	
	
	@Column(name = "password", nullable=false, length=100, columnDefinition="varchar(100) not null default ''")
	private String password;
	
	@Column(name = "username", nullable=false, length=100, columnDefinition="varchar(100) not null default ''")
	private String username;
	

	
	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
}
