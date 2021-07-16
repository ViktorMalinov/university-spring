package main.dataaccess.apigroup.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import main.dataaccess.common.NamePersistent;


@Entity
//@EqualsAndHashCode(callSuper=true)
@Table(name = "api_group")
public class ApiGroup extends NamePersistent {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "display_name", length = 50)
	private String displayName;
	

	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	} 
	

	
}
