package com.danielsantanaribeiro.logusretailscheduleapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Schedule implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String patient_name;
	private String doctor_crm;
	private String doctor_name;
	
	@Column(name="DATE_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
	private Date schedule_datetime;
	
	private Integer clinic_number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getDoctor_crm() {
		return doctor_crm;
	}

	public void setDoctor_crm(String doctor_crm) {
		this.doctor_crm = doctor_crm;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public Date getSchedule_datetime() {
		return schedule_datetime;
	}

	public void setSchedule_datetime(Date schedule_datetime) {
		this.schedule_datetime = schedule_datetime;
	}

	public Integer getClinic_number() {
		return clinic_number;
	}

	public void setClinic_number(Integer clinic_number) {
		this.clinic_number = clinic_number;
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
		Schedule other = (Schedule) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
