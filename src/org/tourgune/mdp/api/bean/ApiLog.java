package org.tourgune.mdp.api.bean;

import java.sql.Timestamp;

public class ApiLog {
	
	private int id;
	private String apiKey;
	private Timestamp callTime;
	private Float duration;
	private String controller;
	private String urlTarget;
	private String status;
	
	
	public ApiLog(String apiKey, Timestamp callTime, Float duration, String controller,
			String urlTarget, String status) {
		super();
		this.apiKey = apiKey;
		this.callTime = callTime;
		this.duration = duration;
		this.controller = controller;
		this.urlTarget = urlTarget;
		this.status = status;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getCallTime() {
		return callTime;
	}
	public void setCallTime(Timestamp callTime) {
		this.callTime = callTime;
	}
	public Float getDuration() {
		return duration;
	}
	public void setDuration(Float duration) {
		this.duration = duration;
	}
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public String getUrlTarget() {
		return urlTarget;
	}
	public void setUrlTarget(String urlTarget) {
		this.urlTarget = urlTarget;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
}
