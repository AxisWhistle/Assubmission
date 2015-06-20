package com.axis.assubmission.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column
	private String province;
	@Column
	private String city;
	@Column
	private String area;
	@Column
	private String street;
	@Column
	private String detail;
	public String getArea() {
		return area;
	}
	public String getCity() {
		return city;
	}
	public String getDetail() {
		return detail;
	}
	public String getProvince() {
		return province;
	}
	public String getStreet() {
		return street;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	

}
