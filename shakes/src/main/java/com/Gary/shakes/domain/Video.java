package com.Gary.shakes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Video {
	
	//主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//风格
	private String style;
	//名字
	private String name;
	//封面名字
	private String covername;
	//视频名字
	private String videoname;
	//视频id
	private String fileid;
	//视频的url
	private String url;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	
	protected Video()
	{
		
	}
	
	public Video(String name,String style,String covername,String videoname,String fileid,String url)
	{
		this.name=name;
		this.style=style;
		this.covername = covername;
		this.videoname = videoname;
		this.fileid = fileid;
		this.url = url;
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStyle() {
		return style;
	}


	public void setStyle(String style) {
		this.style = style;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCovername() {
		return covername;
	}


	public void setCovername(String covername) {
		this.covername = covername;
	}


	public String getVideoname() {
		return videoname;
	}


	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}


	public String getFileid() {
		return fileid;
	}


	public void setFileid(String fileid) {
		this.fileid = fileid;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}
