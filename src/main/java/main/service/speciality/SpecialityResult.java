package main.service.speciality;

import lombok.*;
import main.service.common.NameDto;

@Data
@EqualsAndHashCode(callSuper=false)
public class SpecialityResult extends NameDto{

	private Long facultyId;
	private String facultyName;

}
