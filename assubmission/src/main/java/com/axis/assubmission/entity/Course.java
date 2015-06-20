package com.axis.assubmission.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_COURSE")
public class Course {
	@Id
	private Long id;
	
}		
