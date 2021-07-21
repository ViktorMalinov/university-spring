package main.dataaccess.common;

import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.*;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;



@Data
@Access(AccessType.FIELD)
@MappedSuperclass
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class Persistent {

	//private static final long serialVersionUID = 6857410091575760475L;
	
	
	@Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;

	@Column(name = "modification_time", columnDefinition = "TIMESTAMP")
	protected LocalDateTime modificationTime;


	/*
	@Version
	@NotNull
	@Column(name = "version", columnDefinition = "BIGINT(20) NOT NULL DEFAULT 0")
	protected Long version = 1L; // = 1L;
	*/
	

	/*  
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	*/

}
