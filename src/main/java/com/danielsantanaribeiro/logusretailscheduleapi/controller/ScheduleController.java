package com.danielsantanaribeiro.logusretailscheduleapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Schedule;
import com.danielsantanaribeiro.logusretailscheduleapi.repository.ScheduleRepository;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Schedule> scheduleList() {
		return scheduleRepository.findAll();		
	}

	@RequestMapping(method = RequestMethod.GET, params = "date")
	public String listar(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {		
		return "Data informada: " + date;
	}
	
	@PostMapping
	public Schedule createSchedule (@RequestBody Schedule schedule){		
		return scheduleRepository.save(schedule);
	}
	
	
}
