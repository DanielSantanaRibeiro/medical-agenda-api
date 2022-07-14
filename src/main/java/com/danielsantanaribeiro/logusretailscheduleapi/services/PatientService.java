package com.danielsantanaribeiro.logusretailscheduleapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Patient;
import com.danielsantanaribeiro.logusretailscheduleapi.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> findAll(){
		return patientRepository.findAll();
	}
	
	public Patient save(Patient user) {
		return patientRepository.save(user);		
	}
}
