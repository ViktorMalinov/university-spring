package main.dataaccess.apisession.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;
import main.dataaccess.common.NamePersistent;
import main.dataaccess.common.Persistent;


@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "api_session")
public class ApiSession extends NamePersistent {
	
	@Column(name = "authToken")
	private String authToken;

}
