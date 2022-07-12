package com.danielsantanaribeiro.logusretailscheduleapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(method = RequestMethod.GET, params = "nome")
	public String listar(@RequestParam(value = "nome") String nome) {		
		return "Olá, " + nome;
	}
	
	
	
	
}
