package com.example.restfull.config;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {

	private HttpStatus status;
	private String errorCode;
	private String message;
	private String detail;
	private String path;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	// Builder

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static final class ApiErrorResponseBuilder {
		private HttpStatus status;
		private String errorCode;
		private String message;
		private String detail;
		private String path;

		public ApiErrorResponseBuilder() {
		}

		public static ApiErrorResponseBuilder anApiErrorResponse() {
			return new ApiErrorResponseBuilder();
		}

		public ApiErrorResponseBuilder withStatus(HttpStatus status) {
			this.status = status;
			return this;
		}

		public ApiErrorResponseBuilder withErrorCode(String errorCode) {
			this.errorCode = errorCode;
			return this;
		}

		public ApiErrorResponseBuilder withMessage(String message) {
			this.message = message;
			return this;
		}

		public ApiErrorResponseBuilder withDetail(String detail) {
			this.detail = detail;
			return this;
		}
		
		public ApiErrorResponseBuilder withPath(String path) {
			this.path = path;
			return this;
		}

		public ApiErrorResponse build() {
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			apiErrorResponse.status = this.status;
			apiErrorResponse.errorCode = this.errorCode;
			apiErrorResponse.detail = this.detail;
			apiErrorResponse.message = this.message;
			apiErrorResponse.path = this.path;
			return apiErrorResponse;
		}
	}
}