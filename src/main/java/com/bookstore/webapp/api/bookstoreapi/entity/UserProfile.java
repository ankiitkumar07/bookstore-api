package com.bookstore.webapp.api.bookstoreapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	private User user;
	
	@Column(name = "user_phone")
	private Long userPhone;
	
	@Column(name = "user_pic_path")
	private String userPicPath;
	
	public UserProfile() {
		super();
	}

	public UserProfile(User user, Long userPhone, String userPicPath) {
		super();
		this.user = user;
		this.userPhone = userPhone;
		this.userPicPath = userPicPath;
	}

	public Long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPicPath() {
		return userPicPath;
	}

	public void setUserPicPath(String userPicPath) {
		this.userPicPath = userPicPath;
	}

	@Override
	public String toString() {
		return "UserProfile [user=" + user + ", userPhone=" + userPhone + ", userPicPath=" + userPicPath + "]";
	}
	
	
}
