package com.danielsantanaribeiro.logusretailscheduleapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Doctor;
import com.danielsantanaribeiro.logusretailscheduleapi.repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	
	public List<Doctor> findAll(){
		return doctorRepository.findAll();
	}
	
	public Doctor save(Doctor doctor) {
		doctor.setId(null);
		return doctorRepository.save(doctor);		
	}
}
