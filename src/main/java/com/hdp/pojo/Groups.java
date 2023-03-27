package com.hdp.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Groups implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String notes;

	private Set<Emp> sets = new HashSet<>();
	
	public Groups() {
	}

	public Groups(int id, String name, String notes, Set<Emp> sets) {
		super();
		this.id = id;
		this.name = name;
		this.notes = notes;
		this.sets = sets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Set<Emp> getSets() {
		return sets;
	}

	public void setSets(Set<Emp> sets) {
		this.sets = sets;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", notes=" + notes + ", sets=" + sets + "]";
	}
	

}
