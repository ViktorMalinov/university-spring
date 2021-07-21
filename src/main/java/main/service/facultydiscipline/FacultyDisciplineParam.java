package main.service.facultydiscipline;

import lombok.*;
import main.service.common.BaseDto;

@Data
@EqualsAndHashCode(callSuper=false)
public class FacultyDisciplineParam extends BaseDto {

	private Long disciplineId;
	private Long facultyId;


}
