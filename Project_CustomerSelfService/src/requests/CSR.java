package requests;

import java.sql.Date;

public class CSR {
	private Date request_date;
	private int type,request_id;
	private String detail,response,status,username;
	public Date getRequest_date() {
		return request_date;
	}
	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public CSR(Date request_date, int type, int request_id, String detail, String response, String status,
			String username) {
		super();
		this.request_date = request_date;
		this.type = type;
		this.request_id = request_id;
		this.detail = detail;
		this.response = response;
		this.status = status;
		this.username = username;
	}
	public CSR() {
		super();
	}
	
}
