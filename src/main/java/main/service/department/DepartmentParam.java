package main.service.department;

import lombok.*;
import main.service.common.NameDto;

@Data
@EqualsAndHashCode(callSuper=false)
public class DepartmentParam extends NameDto{


	private Long facultyId;


}
