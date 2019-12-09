package com.dev.dto;

public class BoardDTO {
	private int seq;
	private int user_seq;
	private String title;
	private String content;
	private String registered_at;
	private int hit;
	
	public BoardDTO(int seq, int user_seq, String title, String content, String registered_at, int hit) {
		this.seq = seq;
		this.user_seq = user_seq;
		this.title = title;
		this.content = content;
		this.registered_at = registered_at;
		this.hit = hit;
	}

	public int getSeq() {
		return seq;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getRegistered_at() {
		return registered_at;
	}

	public int getHit() {
		return hit;
	}
}
