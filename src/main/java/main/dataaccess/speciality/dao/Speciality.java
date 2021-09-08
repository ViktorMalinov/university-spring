package main.dataaccess.speciality.dao;

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
@Table(name = "speciality")
public class Speciality extends NamePersistent {
	
	@ManyToOne
	@JoinColumn(name = "faculty_id", nullable = false)
	private Faculty faculty;


}
