package main.dataaccess.common;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.*;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;


@Data
@EqualsAndHashCode(callSuper=false)
@Access(AccessType.FIELD)
@MappedSuperclass
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class NamePersistent extends Persistent {

	//private static final long serialVersionUID = 6857410091575760475L;
	
	@Column(name = "code")
	protected Long code;
	
	//@Column(name = "name", nullable=false, length=100, columnDefinition="varchar(100) not null default ''")
	@Column(name = "name", length=100)
	protected String name;
	
	@Column(name = "description", length=255)
	protected String description;


}
