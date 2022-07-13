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

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	public List<Schedule> findAll() {
		// need to return orderByScheduleDateTime
		return scheduleRepository.findAll(Sort.by(Direction.ASC, "scheduleDate")
				.and(Sort.by(Direction.ASC, "scheduleTime")));	
	}

	public Schedule findById(Long id) {
		Optional<Schedule> obj = scheduleRepository.findById(id);
		return obj.orElse(null);
	}

	public Schedule save(Schedule newSchedule) {
		newSchedule.setId(null);
		//TODO - A given Patient cannot schedule two medical appointment at the same day 
		// schedule date
		/*
		 * SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd"); String
		 * ymdScheduleDate = ymdFormat.format(newSchedule.getScheduleDatetime());
		 * List<Schedule> returnList = findByNameAndDate(newSchedule.getPatientName(),
		 * ymdScheduleDate); if(returnList.isEmpty()) { //TODO RETURN ERROR return null;
		 * }
		 */
		return scheduleRepository.save(newSchedule);
	}

	public List<Schedule> findByPatientNameAndDate(String patientName, LocalDate date) {
		return scheduleRepository.findByPatientNameAndScheduleDate(patientName, date);
	}
	
	public List<Schedule> findByPatientName(String patientName) {
		return scheduleRepository.findByPatientName(patientName);
	}
	
	public List<Schedule> findByDate(LocalDate date) {
		return scheduleRepository.findByScheduleDate(date);	
	}
	

}
