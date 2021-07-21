package main.dataaccess.discipline.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import main.dataaccess.common.NamePersistent;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "discipline")
public class Discipline extends NamePersistent {


	
}
