package com.danielsantanaribeiro.logusretailscheduleapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "patient_name")
	private String patientName;
	@Column(nullable = false, name = "doctor_crm")
	private String doctorCrm;
	@Column(nullable = false, name = "doctor_name")
	private String doctorName;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "schedule_datetime")
	private Date scheduleDatetime;
	
    @Column(nullable = false, name = "clinic_number")
    @NotNull(message = "Clinic number is mandatory!")
    private Integer clinicNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorCrm() {
		return doctorCrm;
	}

	public void setDoctorCrm(String doctorCrm) {
		this.doctorCrm = doctorCrm;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Date getScheduleDatetime() {
		return scheduleDatetime;
	}

	public void setScheduleDatetime(Date scheduleDatetime) {
		this.scheduleDatetime = scheduleDatetime;
	}

	public Integer getClinicNumber() {
		return clinicNumber;
	}

	public void setClinicNumber(Integer clinicNumber) {
		this.clinicNumber = clinicNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
