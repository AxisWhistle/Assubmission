package com.axis.assubmission.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ACCOUNT")
public class Account {
	public static final Character SEX_FEMALE = 'f';
	public static final Character SEX_MALE = 'm';
	public static final Character SEX_UNKNOWN = 'u';
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column
	private Character sex;

	/**
	 * Value Type的实现方式: 在实现Value type的类上使用Embeddable注解 在拥有Value type
	 * object的类的关联上使用Embedded注解 如果拥有方拥有多个value
	 * type关联,可以通过AttributeOverride注解更改字段名称
	 */
	@Column
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "province", column = @Column(name = "homeAddressProvince")),
			@AttributeOverride(name = "city", column = @Column(name = "homeAddressCity")),
			@AttributeOverride(name = "area", column = @Column(name = "homeAddressArea")),
			@AttributeOverride(name = "street", column = @Column(name = "homeAddressStreet")),
			@AttributeOverride(name = "detail", column = @Column(name = "homeAddressDetail")) })
	private Address homeAddress;
	@Embedded
	private Address permanentAddress;

	public Account() {
		super();
	}

	public Account(String username, String password, Character sex) {
		this.username = username;
		this.password = password;
		this.sex = sex;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public Character getSex() {
		return sex;
	}

	public String getUsername() {
		return username;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
