package com.danielsantanaribeiro.logusretailscheduleapi.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
	public String listar(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {	
		//TODO - return schedules by date
		return "Data informada: " + date;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Schedule> scheduleById(@PathVariable Integer id) {	
		Long idLong = Long.valueOf(id);
		//TODO - NOT FOUND exception - Use exception handler
		Schedule obj = scheduleService.findById(idLong);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<?> createSchedule (@RequestBody @Valid Schedule schedule){		
		// TODO - Exception handler when is not possible to save
		schedule = scheduleService.save(schedule);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(schedule.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"name", "date"})
	public List<Schedule> getScheduleByNameAndByDate (
			@RequestParam(value="name") String name,
			@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {				
		
		return scheduleService.findByPatientNameAndDate(name, date);
	}
	
	
}
