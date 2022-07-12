package com.danielsantanaribeiro.logusretailscheduleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

}
