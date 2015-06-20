package com.axis.assubmission.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_SUBMISSION")
public class Submission {
	public static final Integer STATUS_UNJUDGED = 0;
	public static final Integer STATUS_UNCHECKED = 0;
	public static final Integer STATUS_CHECKED = 0;
	@Id
	private Long id;
	/**
	 * many-to-one mapping 没有mappedBy属性,通过JoinColumn指定外键名称
	 */
	@ManyToOne
	@JoinColumn(name = "ownerStudentId")
	private Student ownerStudent;
	@ManyToOne(optional = false)
	@JoinColumn(name = "assignmentId")
	private Assignment assignment;
	@ManyToOne
	@JoinColumn(name = "judgeStudentId")
	private Student judgeStudent;
	@Column
	private Integer point;
	@Column
	private Integer status;

	public Assignment getAssignment() {
		return assignment;
	}

	public Long getId() {
		return id;
	}

	public Student getJudgeStudent() {
		return judgeStudent;
	}

	public Student getOwnerStudent() {
		return ownerStudent;
	}

	public Integer getPoint() {
		return point;
	}

	public Integer getStatus() {
		return status;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public void setJudgeStudent(Student judgeStudent) {
		this.judgeStudent = judgeStudent;
	}

	public void setOwnerStudent(Student ownerStudent) {
		this.ownerStudent = ownerStudent;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
