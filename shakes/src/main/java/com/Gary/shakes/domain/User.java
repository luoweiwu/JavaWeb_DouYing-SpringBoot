package com.Gary.shakes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String telephone;
	//验证码 
	private String code;
	//状态是否激活
	private Integer state;
	
	private String name;
	private String wechat;
	private String card;
	
	protected User()
	{
		
	}
	
	public User(Long id,String username,String password,String telephone,String code,Integer state
			,String name,String wechat,String card)
	{
		this.id=id;
		this.username=username;
		this.password=password;
		this.telephone=telephone;
		this.code=code;
		this.state=state;
		this.name=name;
		this.wechat=wechat;
		this.card=card;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", telephone=" + telephone
				+ ", code=" + code + ", state=" + state + ", name=" + name + ", wechat=" + wechat + ", card=" + card
				+ "]";
	}

	
	
}
