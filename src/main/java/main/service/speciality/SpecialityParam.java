package main.service.speciality;

import lombok.*;
import main.service.common.NameDto;

@Data
@EqualsAndHashCode(callSuper=false)
public class SpecialityParam extends NameDto {

	private Long facultyId;

}
