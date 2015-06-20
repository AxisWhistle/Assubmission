package com.axis.assubmission.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_ASSIGNMENT")
public class Assignment {
	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ownerTeacherId", nullable = false)
	private Teacher owner;

	@ManyToOne
	@JoinColumn(name = "coursePlanId")
	private CoursePlan coursePlan;
	@Column
	private Timestamp deadline = new Timestamp(System.currentTimeMillis());

	@Column
	private Integer point;

	public CoursePlan getCoursePlan() {
		return coursePlan;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public Long getId() {
		return id;
	}

	public Teacher getOwner() {
		return owner;
	}

	public Integer getPoint() {
		return point;
	}

	public void setCoursePlan(CoursePlan coursePlan) {
		this.coursePlan = coursePlan;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public void setOwner(Teacher owner) {
		this.owner = owner;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

}
