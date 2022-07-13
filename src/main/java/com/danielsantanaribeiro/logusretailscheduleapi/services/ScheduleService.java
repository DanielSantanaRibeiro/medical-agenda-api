package com.danielsantanaribeiro.logusretailscheduleapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Schedule;
import com.danielsantanaribeiro.logusretailscheduleapi.repository.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public List<Schedule> findAll(){
		//need to return orderByScheduleDateTime
		return scheduleRepository.findAll(Sort.by(Direction.ASC, "scheduleDatetime"));
	}
	
	public Schedule findById(Long id) {	
		Optional<Schedule> obj = scheduleRepository.findById(id); 
		return obj.orElse(null);
	}
	
	public Schedule save(Schedule newSchedule) {
		newSchedule.setId(null);
		//Cannot save a schedule for a patient who already have schedule on the new schedule date 
		/*
		 * SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd"); String
		 * ymdScheduleDate = ymdFormat.format(newSchedule.getScheduleDatetime());
		 * List<Schedule> returnList = findByNameAndDate(newSchedule.getPatientName(),
		 * ymdScheduleDate); if(returnList.isEmpty()) { //TODO RETURN ERROR return null;
		 * }
		 */
		return scheduleRepository.save(newSchedule);
	}
	
	/*
	 * public List<Schedule> findByNameAndDate(String patientName, String
	 * scheduleDate) { return scheduleRepository.findByNameAndDate(patientName,
	 * scheduleDate); }
	 */

}
