package main.service.facultydiscipline;

import lombok.*;
import main.service.common.BaseDto;

@Data
@EqualsAndHashCode(callSuper=false)
public class FacultyDisciplineResult extends BaseDto {

	private Long disciplineId;
	private Long facultyId;
	private String disciplineName;
	private String facultyName;


}
