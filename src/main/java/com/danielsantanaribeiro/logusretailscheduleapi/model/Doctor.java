package com.danielsantanaribeiro.logusretailscheduleapi.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "name")
	private String name;
	
	@Column(nullable = false, name = "crm")
	private String crm;
	
	@OneToMany(mappedBy = "doctor")
	private List<Schedule> doctorSchedule;
	
	public Doctor() {
		
	}
	public Doctor (String name, String crm) {
		this.name = name;
		this.crm = crm;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public List<Schedule> getDoctorSchedule() {
		return doctorSchedule;
	}
	public void setDoctorSchedule(List<Schedule> doctorSchedule) {
		this.doctorSchedule = doctorSchedule;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return Objects.equals(id, other.id);
	}
	
}
