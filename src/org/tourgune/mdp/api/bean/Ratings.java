package org.tourgune.mdp.api.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ratings")
public class Ratings {

	String status;
	List<RatingsBean> destination;
	List<RatingsBean> competitors;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<RatingsBean> getDestination() {
		return destination;
	}
	public void setDestination(List<RatingsBean> destination) {
		this.destination = destination;
	}
	public List<RatingsBean> getCompetitors() {
		return competitors;
	}
	public void setCompetitors(List<RatingsBean> competitors) {
		this.competitors = competitors;
	}
	
	
}
