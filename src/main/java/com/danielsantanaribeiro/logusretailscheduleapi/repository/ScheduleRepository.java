package com.danielsantanaribeiro.logusretailscheduleapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	List<Schedule> findByPatientName(String name);
	
	List<Schedule> findByScheduleDate(LocalDate date);
	
	List<Schedule> findByScheduleDateAndPatientId(LocalDate scheduleDate, Long patient_id);

}
