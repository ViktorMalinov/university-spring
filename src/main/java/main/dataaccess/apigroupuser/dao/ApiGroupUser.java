package main.dataaccess.apigroupuser.dao;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;
import main.dataaccess.apigroup.dao.ApiGroup;
import main.dataaccess.apiuser.dao.ApiUser;
import main.dataaccess.common.Persistent;


@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "api_group_user")
public class ApiGroupUser extends Persistent {

	@ManyToOne
	@JoinColumn(name = "api_group_id", nullable = false)
	private ApiGroup apiGroup;

	@ManyToOne
	@JoinColumn(name = "api_user_id", nullable = false)	
	private ApiUser apiUser;


}
