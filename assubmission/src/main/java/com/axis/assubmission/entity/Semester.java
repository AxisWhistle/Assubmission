package com.axis.assubmission.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_SEMESTER")
public class Semester {
	@Id
	private Long id;
	
}
