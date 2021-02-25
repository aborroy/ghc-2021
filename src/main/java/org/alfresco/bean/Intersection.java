package org.alfresco.bean;

import java.util.List;

public class Intersection {
	
	Integer id;	
	List<Cycle> cycles;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Cycle> getCycles() {
		return cycles;
	}
	public void setCycles(List<Cycle> cycles) {
		this.cycles = cycles;
	}
	@Override
	public String toString() {
		return "Intersection [id=" + id + ", cycles=" + cycles + ", getId()=" + getId() + ", getCycles()=" + getCycles()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
