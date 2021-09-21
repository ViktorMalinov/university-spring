package main.service.apisession;

import lombok.Data;
import lombok.EqualsAndHashCode;
import main.service.common.NameDto;

@Data
@EqualsAndHashCode(callSuper=false)
public class ApiSessionResult extends NameDto{

	private String authToken;


}
