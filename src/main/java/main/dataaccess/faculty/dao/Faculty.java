package main.dataaccess.faculty.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import main.dataaccess.common.NamePersistent;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "faculty")
public class Faculty extends NamePersistent {


	
}
