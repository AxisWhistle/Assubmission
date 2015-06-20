package com.axis.assubmission.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "T_STUDENT")
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(optional = false)
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.DELETE })
	@JoinColumn(name = "accountId", nullable = false)
	private Account account;
	@OneToMany(mappedBy = "student")
	private Set<CourseSelection> courseSelections;
	@OneToMany(mappedBy = "student")
	private Set<AssistanceSelection> assistanceSelections;
	@OneToMany(mappedBy = "judgeStudent")
	private Set<Submission> submissionsForJudging;

	public Account getAccount() {
		return account;
	}

	public Set<AssistanceSelection> getAssistanceSelections() {
		return assistanceSelections;
	}

	public Set<CourseSelection> getCourseSelections() {
		return courseSelections;
	}

	public Long getId() {
		return id;
	}

	public Set<Submission> getSubmissionsForJudging() {
		return submissionsForJudging;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setAssistanceSelections(
			Set<AssistanceSelection> assistanceSelections) {
		this.assistanceSelections = assistanceSelections;
	}

	public void setCourseSelections(Set<CourseSelection> courseSelections) {
		this.courseSelections = courseSelections;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public void setSubmissionsForJudging(Set<Submission> submissionsForJudging) {
		this.submissionsForJudging = submissionsForJudging;
	}
}
