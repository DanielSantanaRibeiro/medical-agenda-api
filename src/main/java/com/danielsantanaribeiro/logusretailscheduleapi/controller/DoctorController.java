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

import com.danielsantanaribeiro.logusretailscheduleapi.model.Doctor;
import com.danielsantanaribeiro.logusretailscheduleapi.services.DoctorService;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@GetMapping
	public ResponseEntity<List<Doctor>> doctorList(){
		return ResponseEntity.ok().body(doctorService.findAll());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Doctor> scheduleById(@PathVariable Integer id) {	
		Long idLong = Long.valueOf(id);
		Doctor obj = doctorService.findById(idLong);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<URI> save(@RequestBody Doctor doctor){		
		doctor = doctorService.save(doctor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(doctor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
