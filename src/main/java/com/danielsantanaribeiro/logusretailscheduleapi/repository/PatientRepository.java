package com.danielsantanaribeiro.logusretailscheduleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielsantanaribeiro.logusretailscheduleapi.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
