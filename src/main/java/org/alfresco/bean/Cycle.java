package org.alfresco.bean;

public class Cycle {
	
	String street;
	Integer seconds;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getSeconds() {
		return seconds;
	}
	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}
	@Override
	public String toString() {
		return "Cycle [street=" + street + ", seconds=" + seconds + "]";
	}

}
