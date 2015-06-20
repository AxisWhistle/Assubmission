package com.axis.assubmission.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_TEACHER")
public class Teacher {
	@Id
	private Long id;

	@OneToOne
	@JoinColumn(name = "accountId")
	private Account account;
	@ManyToMany(mappedBy = "teachers")
	private Set<CoursePlan> coursePlans;
	@OneToMany(mappedBy = "owner")
	private Set<Assignment> assignments;

	public Account getAccount() {
		return account;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public Set<CoursePlan> getCoursePlans() {
		return coursePlans;
	}

	public Long getId() {
		return id;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public void setCoursePlans(Set<CoursePlan> coursePlans) {
		this.coursePlans = coursePlans;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}
}
