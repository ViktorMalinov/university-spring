package main.dataaccess.common;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;


@Access(AccessType.FIELD)
@MappedSuperclass
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class NamePersistent extends Persistent {

	@Column(name = "code")
	protected Long code;
	
	@Column(name = "name", nullable=false, length=100, columnDefinition="varchar(100) not null default ''")
	protected String name;
	
	@Column(name = "description", length=255)
	protected String description;
	
	
	
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	


}
