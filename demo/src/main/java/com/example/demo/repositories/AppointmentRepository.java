package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Appointment;
import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Patient;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	
	  @Query("select c from Appointment c where case_id.patient_id=:patient_id")
	  public List<Appointment> getAppointmentByPatient(Patient patient_id);
	 
	  @Query("select c from Appointment c where case_id.counsellor_id=:counsellor_id")
	  public List<Appointment> getAllAppointmentByCounsellor(Counsellor counsellor_id);
	  
	  @Query("select c from Appointment c where case_id.counsellor_id=:counsellor_id and status=false")
	  public List<Appointment> getRunningAppointmentByCounsellor(Counsellor counsellor_id);
	  
	  @Query("select c from Appointment c where case_id.counsellor_id=:counsellor_id and status=true ")
	  public List<Appointment> getCompletedAppointmentByCounsellor(Counsellor counsellor_id);
	 /* 
	  @Query("select c from Appointment c where case_id.patient_id=:patient_id")
	  public List<Appointment> getAllAppointmentByPatient(Patient patient_id);
	  
	  @Query("select c from Appointment c where case_id.patient_id=:patient_id and status=false")
	  public List<Appointment> getRunningAppointmentByPatient(Patient patient_id);
	  
	  @Query("select c from Appointment c where case_id.patient_id=:patient_id and status=true")
	  public List<Appointment> getCompletedAppointmentByPatient(Patient patient__id);
	*/
	  @Query("select c from Appointment c where case_id.patient_id=:patient_id and status=false")
	  public List<Appointment>  getRunningAppointmentByPatient(Patient patient_id);
	  
	  
	  
}
