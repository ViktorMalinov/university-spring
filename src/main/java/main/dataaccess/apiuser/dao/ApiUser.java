package main.dataaccess.apiuser.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;
import main.dataaccess.common.NamePersistent;


@Data
@EqualsAndHashCode(callSuper=false)
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


}
