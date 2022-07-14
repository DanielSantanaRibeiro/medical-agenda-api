package com.danielsantanaribeiro.logusretailscheduleapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Patient;
import com.danielsantanaribeiro.logusretailscheduleapi.services.PatientService;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public ResponseEntity<List<Patient>> findAll(){
		return ResponseEntity.ok().body(patientService.findAll());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Patient> findById(@PathVariable Integer id){
		Long idLong = Long.valueOf(id);
		Patient patient = patientService.findById(idLong);
		return ResponseEntity.ok().body(patient);
	}
	
	@PostMapping
	public ResponseEntity<URI> save(@RequestBody Patient patient){
		patient = patientService.save(patient);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patient.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
