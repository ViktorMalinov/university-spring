package main.dataaccess.apigroup.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;
import main.dataaccess.common.NamePersistent;


@Data
@EqualsAndHashCode(callSuper=false)
@Entity
//@EqualsAndHashCode(callSuper=true)
@Table(name = "api_group")
public class ApiGroup extends NamePersistent {

	//private static final long serialVersionUID = 1L;
	
	@Column(name = "display_name", length = 50)
	private String displayName;


}
