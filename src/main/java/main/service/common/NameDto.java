package main.service.common;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
public class NameDto extends BaseDto {

	protected Long code;
	protected String name;
	protected String description;


}
