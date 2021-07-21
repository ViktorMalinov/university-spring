package main.service.lecturer;

import lombok.*;
import main.service.common.NameDto;

@Data
@EqualsAndHashCode(callSuper=false)
public class LecturerResult extends NameDto{

	private String familyName;
	private Long apiUserId;
	private Long departmentId;
	
	private String apiUserDisplayName;
	private String departmentName;


}
