package main.dataaccess.department.dao;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import main.dataaccess.common.NamePersistent;
import main.dataaccess.faculty.dao.Faculty;


@Entity
@Table(name = "department")
public class Department extends NamePersistent {

	@ManyToOne
	@JoinColumn(name = "faculty_id", nullable = false)
	private Faculty faculty;



	public Faculty getFaculty() {
		return faculty;
	}


	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}



	
	
}
