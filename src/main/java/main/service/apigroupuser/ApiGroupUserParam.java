package main.service.apigroupuser;

import lombok.*;
import main.service.common.BaseDto;

@Data
@EqualsAndHashCode(callSuper=false)
public class ApiGroupUserParam extends BaseDto {

	private Long apiGroupId;
	private Long apiUserId;


}
