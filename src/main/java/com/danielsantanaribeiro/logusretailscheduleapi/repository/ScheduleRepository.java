package com.danielsantanaribeiro.logusretailscheduleapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	List<Schedule> findByPatientNameAndScheduleDate(String patientName, LocalDate scheduleDate);

	//List<Schedule> findByPatientName(String name);
	
	List<Schedule> findByScheduleDate(LocalDate date);
	
	/*
	 * @Query("SELECT obj FROM Schedule INNER JOIN Patient as pat WHERE pat.name = :name"
	 * ) List<Schedule> findByPatientName(@Param(value = "name") String name);
	 */
	
	List<Schedule> findByScheduleDateAndPatientId(LocalDate scheduleDate, Long patientName);

}
