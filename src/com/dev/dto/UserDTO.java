package com.dev.dto;

public class UserDTO {
	private int seq;
	private String id;
	private String password;
	private String name;
	private int gender;
	private String salt;
	public UserDTO(int seq, String id, String password, String name, int gender, String salt) {
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.salt = salt;
	}

	public int getSeq() {
		return seq;
	}

	public String getSalt() {
		return salt;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public int getGender() {
		return gender;
	}
	
}
