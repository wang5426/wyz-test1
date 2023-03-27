package com.hdp.utils;

import java.io.Serializable;

public class ResponseEntity implements Serializable{

	
	private int code;
	private String status;
	private Object data;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static<T> ResponseEntity success() {
		return new ResponseEntity(ResponeseCode.SUCCESS);
	}

	public static<T> ResponseEntity success(int code) {
		return new ResponseEntity(code);
	}
	public static<T> ResponseEntity success(int code,T data) {
		return new ResponseEntity(code,data);
	}
	
	public static<T> ResponseEntity success(String status) {
		return new ResponseEntity(status);
	}
	
	public static<T> ResponseEntity success(String status,Object data) {
		return new ResponseEntity(status,data);
	}
	
	private ResponseEntity(int code,Object data) {
		this.code=code;
		this.data=data;
	}
	private ResponseEntity(int code) {
		this.code=code;
	}
	
	private ResponseEntity(String status) {
		this.code=ResponeseCode.SUCCESS;
		this.status = status;
	}
	
	private ResponseEntity(String status,Object data) {
		this.code=ResponeseCode.SUCCESS;
		this.status = status;
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ResponseEntity [code=" + code + ", status=" + status + ", data=" + data + "]";
	}
	

}
