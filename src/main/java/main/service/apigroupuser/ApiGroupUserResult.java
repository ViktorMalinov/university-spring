package main.service.apigroupuser;

import lombok.*;
import main.service.common.BaseDto;

@Data
@EqualsAndHashCode(callSuper=false)
public class ApiGroupUserResult extends BaseDto {

	private Long apiGroupId;
	private Long apiUserId;
	
	private String apiGroupDisplayName;
	private String apiUserDisplayName;


}
