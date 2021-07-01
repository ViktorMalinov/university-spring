package main.dataaccess.facultydiscipline.dao;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import main.dataaccess.common.Persistent;
import main.dataaccess.discipline.dao.Discipline;
import main.dataaccess.faculty.dao.Faculty;

@Entity
@Table(name = "faculty_discipline")
public class FacultyDiscipline extends Persistent {

	@ManyToOne
	@JoinColumn(name = "faculty_id", nullable = false)
	private Faculty faculty;
	
	@ManyToOne
	@JoinColumn(name = "discipline_id", nullable = false)
	private Discipline discipline;
	


	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}


	
}
