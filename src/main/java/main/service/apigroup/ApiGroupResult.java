package main.service.apigroup;

import lombok.*;
import main.service.common.NameDto;

@Data
@EqualsAndHashCode(callSuper=false)
public class ApiGroupResult extends NameDto{
	
	private String displayName;

}
