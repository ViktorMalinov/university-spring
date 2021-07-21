package main.dataaccess.lecturer.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;
import main.dataaccess.apiuser.dao.ApiUser;
import main.dataaccess.common.NamePersistent;
import main.dataaccess.department.dao.Department;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "lecturer")
public class Lecturer extends NamePersistent {

	@Column(name = "family_name", length = 50)
	private String familyName;
	
	@ManyToOne
	@JoinColumn(name = "api_user_id", nullable = false)
	private ApiUser apiUser;
	
	
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;


}
