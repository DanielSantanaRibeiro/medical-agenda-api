package com.danielsantanaribeiro.logusretailscheduleapi.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Schedule;
import com.danielsantanaribeiro.logusretailscheduleapi.services.ScheduleService;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Schedule>> scheduleList() {
		
		return ResponseEntity.ok(scheduleService.findAll());				
	}

	@RequestMapping(method = RequestMethod.GET, params = "date")
	public ResponseEntity<List<Schedule>> findByDate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {	
		List<Schedule> listOfSchedulesByDate = scheduleService.findByDate(date);
		return ResponseEntity.ok().body(listOfSchedulesByDate);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Schedule> scheduleById(@PathVariable Integer id) {	
		Long idLong = Long.valueOf(id);
		Schedule obj = scheduleService.findById(idLong);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"patient_id", "date"})
	public ResponseEntity<List<Schedule>> getScheduleByNameAndDate (
			@RequestParam(value="patient_id") Integer patient_id,
			@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		Long patinent_lid = Long.valueOf(patient_id);
		List<Schedule> listOfSchedules = scheduleService.findbyIdAndDate(patinent_lid, date);
		return ResponseEntity.ok().body(listOfSchedules);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "patient_name")
	public ResponseEntity<List<Schedule>> getScheduleByName (
			@RequestParam(value="patient_name") String patient_name) {		
		List<Schedule> listOfSchedules = scheduleService.findByPatientName(patient_name);
		return ResponseEntity.ok().body(listOfSchedules);
	}
	
	@PostMapping
	public ResponseEntity<?> createSchedule (@RequestBody @Valid Schedule schedule){		
		schedule = scheduleService.save(schedule);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(schedule.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
