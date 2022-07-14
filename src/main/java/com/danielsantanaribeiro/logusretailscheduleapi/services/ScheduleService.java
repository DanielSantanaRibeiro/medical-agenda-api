package com.danielsantanaribeiro.logusretailscheduleapi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Schedule;
import com.danielsantanaribeiro.logusretailscheduleapi.repository.ScheduleRepository;
import com.danielsantanaribeiro.logusretailscheduleapi.services.exceptions.MaxNumberOfScheduleByDayException;
import com.danielsantanaribeiro.logusretailscheduleapi.services.exceptions.ObjectNotFoundException;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	public List<Schedule> findAll() {
		return scheduleRepository.findAll(Sort.by(Direction.ASC, "scheduleDate")
				.and(Sort.by(Direction.ASC, "scheduleTime")));	
	}

	public Schedule findById(Long id) {
		Optional<Schedule> obj = scheduleRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found for ID: " + id));
	}

	public Schedule save(Schedule newSchedule) {
		newSchedule.setId(null);
		List<Schedule> patientScheduleList = scheduleRepository.findByPatientNameAndScheduleDate(newSchedule.getPatientName(), newSchedule.getScheduleDate());
		if(patientScheduleList.size() > 0) {
			throw new MaxNumberOfScheduleByDayException("Patient reached the maximum number of medical appointment by day");
		}		
		return scheduleRepository.save(newSchedule);
	}

	public List<Schedule> findByPatientNameAndDate(String patientName, LocalDate date) {
		return scheduleRepository.findByPatientNameAndScheduleDate(patientName, date);
	}
	
	public List<Schedule> findByPatientName(String patientName) {
		return scheduleRepository.findByPatientName(patientName);
	}
	
	public List<Schedule> findByDate(LocalDate date) {
		List<Schedule> listOfSchedules = scheduleRepository.findByScheduleDate(date);
		if(listOfSchedules.isEmpty()) 
			throw new ObjectNotFoundException("Object list not found for date: " + date);
		return listOfSchedules;
	}
	

}
