package com.axis.assubmission.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "T_COURSE_PLAN")
public class CoursePlan {
	/**
	 * @Id 用来标注primary key,推荐使用没有领域意义的字段作为id 区分对象identity和equality
	 *     id用来代表数据库中的行,最好不参与对象equals id属性最好具备required,constant,unique
	 *     一般属性很难同时具备这三个特性,而且使用自然属性容易出现问题,推荐surrogate id
	 * @GeneratedValue:设置id生成策略 可以使用标准JPA支持的generator,
	 *                          可以在entity上通过hibernate的GenericGenerator注解命名hibernate提供的generator
	 *                          ,然后在 JPA的generator中引用
	 */
	@Id
	private Long id;
	/**
	 * Fetch策略 Entity的集合属性,默认lazy load,降低内存开销,保证系统性能 定义parent
	 * entity为集合属性拥有者,collection entity为集合属性中的实体
	 * 
	 * @Fetch(FetchMode.SELECT):默认fetch策略,可以用在lazy load和eager load中 parent
	 *                                             entity被加载,collection
	 *                                             entity在被访问时才加载 分别针对parent
	 *                                             entity和collection
	 *                                             entity进行查询,生成独立query 在lazy
	 *                                             load中,collection
	 *                                             entity只有被访问时才查询加载 在eager
	 *                                             load中,parent
	 *                                             entity和collection
	 *                                             entity依次被加载,所以产生N+1问题 parent
	 *                                             entity加载,1条query,collection
	 *                                             entity有N个,N条query
	 * @Fetch(FetchMode.JOIN):只能用在eager load中 parent entity在加载时同时加载collection
	 *                                  entitty,产生一条outer join查询
	 * @Fetch(FetchMode.SUBSELECT):对已加载的实体实例的所有集合属性使用一条子查询获取对应记录
	 * @BatchSize(size = 10): 对加载到内存中的多个实体实例的Collection属性lazy load的batch size
	 *                 假如内存中加载了N个CoursePlan实例 BatchSize应用在Set<Attribute>someSet上
	 *                 则对应每10个CoursePlan实例,产生一条SQL语句,查询其对应的Attribute记录
	 *                 如果不使用BatchSize
	 *                 则每个实例的Collection属性都产生一条独立的SQL语句,总共N+1条查询,影响性能
	 */

	/*
	 * Cascade策略: save-update,delete,delete-orphan,save-update
	 * 这些来自hibernate的cascade type,不能和jpa的cascade type混用 使用jpa cascade
	 * type可能会导致级联操作失效 entity被保存时,collectin entity也被保存 delete: parent parent
	 * entity被删除时,collection entity被全部删除 delete-orphan: collection
	 * entity中个部分被删除时,在保存parent entity时从collection entity表中删除对应记录
	 */

	/*
	 * OneToOne optional:对于对象被持久化时 如果为true,关系的另一端可以为null,parent entity依然被保存
	 * 如果为false,关系的另一端不可以为null,parent entity被保存时???
	 */

	/*
	 * Column和JoinColumn的nullable时针对数据库schema的,如果为false,数据库属性NotNull
	 */

	/*
	 * one-to-one mapping 设置fetch策略,cacade策略 OneToOne mappedBy属性指示到关联另外一端查找配置信息
	 * JoinColumn注解用在拥有外键的类的字段上,表明本实体拥有一个外键
	 */
	@OneToOne(optional = false)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "courseId", nullable = false)
	private Course course;
	@OneToOne
	@JoinColumn(name = "semesterId", nullable = false)
	private Semester semester;
	/*
	 * many-to-many mapping ManyToOne mappedBy属性指示到关联另外一端查找配置信息 JoinTable
	 * joinColumns指示本端参与新表的字段 JoinTable inverseJoinColumns指示另一端参与新表的字段
	 * 如果many-to-many mapping的关系上存在属性
	 * 增加一个中间对象Middle,将many-to-many转化为两个many-to-one
	 */
	@ManyToMany
	@JoinTable(name = "T_COURSE_PLAN_TEACHER", joinColumns = { @JoinColumn(name = "coursePlanId", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "teacherId", nullable = false) })
	private Set<Teacher> teachers;
	/*
	 * one-to-many mapping 可以设置fetch策略,cacade策略
	 * 双向关系中,在One端的关联上使用OneToMany注解,设置mappedBy,表明到关联另一端查找配置
	 * 在many端的关联ManyToOne注解,同时设置JoinColumn,表明该端拥有外键
	 * 单向关系中,在many端使用ManyToOne,设置JoinColumn配置外键
	 */
	@OneToMany(mappedBy = "coursePlan", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private Set<CourseSelection> courseSelections;
	@OneToMany(mappedBy = "coursePlan")
	private Set<AssistanceSelection> assistanceSelections;
	@OneToMany(mappedBy = "coursePlan")
	private Set<Assignment> assignments;

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public Set<AssistanceSelection> getAssistanceSelections() {
		return assistanceSelections;
	}

	public Course getCourse() {
		return course;
	}

	public Set<CourseSelection> getCourseSelections() {
		return courseSelections;
	}

	public Long getId() {
		return id;
	}

	public Semester getSemester() {
		return semester;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public void setAssistanceSelections(
			Set<AssistanceSelection> assistanceSelections) {
		this.assistanceSelections = assistanceSelections;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setCourseSelections(Set<CourseSelection> courseSelections) {
		this.courseSelections = courseSelections;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
}
