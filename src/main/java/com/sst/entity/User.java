package com.sst.entity;

import com.sst.utils.Entity;

import java.io.Serializable;
import java.util.Date;



public class User extends Entity implements Serializable {


	private Integer id;

	private String openid;

	private String name;

	private String headImg;

	private String phone;

	private String sign;

	private Integer sex;

	private String city;

	private Date createTime;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", openid='" + openid + '\'' +
				", name='" + name + '\'' +
				", headImg='" + headImg + '\'' +
				", phone='" + phone + '\'' +
				", sign='" + sign + '\'' +
				", sex='" + sex + '\'' +
				", city='" + city + '\'' +
				", createTime=" + createTime +
				'}';
	}
}