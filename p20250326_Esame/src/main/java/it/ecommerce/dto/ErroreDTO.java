package it.ecommerce.dto;

public class ErroreDTO {
	
	private String msg;
	
	public ErroreDTO() {}

	public ErroreDTO(String msg) {
		super();
		this.msg = "Error: " + msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = "Error: " + msg;
	}

}
