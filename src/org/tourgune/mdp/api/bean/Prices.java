package org.tourgune.mdp.api.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="prices")
public class Prices {

	String status;
	List<PriceBean> destination;
	List<PriceBean> competitors;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PriceBean> getDestination() {
		return destination;
	}

	public void setDestination(List<PriceBean> destination) {
		this.destination = destination;
	}

	public List<PriceBean> getCompetitors() {
		return competitors;
	}

	public void setCompetitors(List<PriceBean> competitors) {
		this.competitors = competitors;
	}
	
	
}
