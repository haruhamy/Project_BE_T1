package com.javaweb.dto.response;

import java.util.List;

public class ErrorDetailResponse {
	private String error;
	private  List<String> detail;
	public String getError() {
		return error;
	}
	public List<String> getDetail() {
		return detail;
	}
	public void setError(String error) {
		this.error = error;
	}
	public void setDetail(List<String> detail) {
		this.detail = detail;
	}
}
