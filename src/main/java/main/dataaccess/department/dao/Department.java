package main.dataaccess.department.dao;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;
import main.dataaccess.common.NamePersistent;
import main.dataaccess.faculty.dao.Faculty;


@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "department")
public class Department extends NamePersistent {

	@ManyToOne
	@JoinColumn(name = "faculty_id", nullable = false)
	private Faculty faculty;


}
