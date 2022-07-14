package com.danielsantanaribeiro.logusretailscheduleapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Patient;
import com.danielsantanaribeiro.logusretailscheduleapi.repository.PatientRepository;
import com.danielsantanaribeiro.logusretailscheduleapi.services.exceptions.ObjectNotFoundException;

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
	
	public Patient findById(Long id) {
		Optional<Patient> obj = patientRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found for ID: " + id));
	}

}
