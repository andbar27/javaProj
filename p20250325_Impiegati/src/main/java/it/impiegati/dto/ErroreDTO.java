package it.impiegati.dto;

public class ErroreDTO {
	
	private String msg;
	
	public ErroreDTO() {}

	public ErroreDTO(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
