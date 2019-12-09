package com.dev.dto;

public class BoardListDTO {
	private int bSeq;
	private String bTitle;
	private String bContent;
	private String uId;
	private String registered_at;
	private int bHit;
	
	
	public BoardListDTO(int bSeq, String bTitle,String content, String uId, String registered_at, int bHit) {
		super();
		this.bSeq = bSeq;
		this.bTitle = bTitle;
		this.uId = uId;
		this.bHit = bHit;
		this.registered_at = registered_at;
		this.bContent = content;
	}
	
	public int getbSeq() {
		return bSeq;
	}
	public String getbContent() {
		return bContent;
	}
	public String getbTitle() {
		return bTitle;
	}
	public int getbHit() {
		return bHit;
	}
	public String getRegistered_at() {
		return registered_at;
	}
	public String getuId() {
		return uId;
	}
}
