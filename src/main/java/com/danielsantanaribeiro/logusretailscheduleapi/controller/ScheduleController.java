package com.danielsantanaribeiro.logusretailscheduleapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "Olá, mundo!";
	}

	@RequestMapping(method = RequestMethod.GET, params = "nome")
	public String listar(@RequestParam(value = "nome") String nome) {
		return "Olá, " + nome;
	}

}
