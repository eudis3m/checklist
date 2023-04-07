package br.com.patio.projeto.errordto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ProjetoPatternError implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;
	private String message;
	private Long timestamp;
	
	@JsonInclude(Include.NON_NULL)
	private String detailMessage;
	
	@JsonInclude(Include.NON_EMPTY)
	private List<String> errorsDetails = new ArrayList<String>();
	
	public ProjetoPatternError() {
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public List<String> getErrorsDetails() {
		return errorsDetails;
	}

	public void setErrorsDetails(List<String> errorsDetails) {
		this.errorsDetails = errorsDetails;
	}
	
	public void addErrorDetail(String field, String message) {
		String msg = field.concat(": ").concat(message).toString();
		this.errorsDetails.add(msg);
	}
}
