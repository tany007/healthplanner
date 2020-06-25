package com.ibm.healthplanner.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.healthplanner.exception.ResourceExistsException;
import com.ibm.healthplanner.exception.ResourceNotFoundException;
import com.ibm.healthplanner.model.GetPatientResponse;
import com.ibm.healthplanner.model.Patient;

import com.ibm.healthplanner.repository.HealthPlannerRepository;

@Service
@Transactional
public class HealthPlannerServiceImpl implements HealthPlannerService {
	
	private static final Logger log = LoggerFactory.getLogger(HealthPlannerServiceImpl.class);
	
	@Autowired
	HealthPlannerRepository userRepository;
	public void createUser(Patient user) {
		
		Optional<Patient> patient = userRepository.findPatientByName(user.getName());
		if(!patient.isPresent()) {

		    String id = "P" + "-" + System.currentTimeMillis();
		    user.setId(id);
		    double bmi = 0;
			double weight = user.getWeight();
			double height = user.getHeight();
			bmi = (weight / (height * height))*10;
			user.setBmi(bmi);
			log.info("BMI for the patient is {} ", user.getBmi());
			
			/*if((user.getAllergies()).equalsIgnoreCase("yes")) {
				user.setAllergicFrom(user.getAllergicFrom());
			}*/
					
			userRepository.save(user);
		}else {
			log.info ("User Already exists!!");
			throw new ResourceExistsException("User "+ user.getName().getFirstName() + " " +user.getName().getLastName() 
							+ " Already exists!!");
		}
	
}

public GetPatientResponse getAllUser() {
	
	GetPatientResponse patietData = new GetPatientResponse();
	patietData.setPatients((List<Patient>) userRepository.findAll());
	return patietData;
}


 public Optional<Patient> findPatientById(String id) { 
	  return userRepository.findById(id); 
  }

public void update(Patient newPatient, String id) {
	
	Optional<Patient> patient = findPatientById(newPatient.getId()); 
	Patient ptn = new Patient();
	  if(patient.isPresent()) {  
		  
		  ptn = patient.get();
		  ptn.setId(newPatient.getId());
		  ptn.setName(newPatient.getName());
		  ptn.setGender(newPatient.getGender());
		  ptn.setAge(newPatient.getAge());
		  ptn.setMailId(newPatient.getMailId());
		  ptn.setPhone(newPatient.getPhone());
		  ptn.setWeight(newPatient.getWeight());
		  ptn.setHeight(newPatient.getHeight());
		  ptn.setBmi(newPatient.getBmi());
	  }
	  else {
		  throw new ResourceNotFoundException("User ID "+ newPatient.getId() + " does not exits");
	  }
	 userRepository.save(ptn);	
}

  public void deleteUserById(String id) { 
	  
	  Optional<Patient> user = findPatientById(id);
	  if (user.isPresent()) { 
		  userRepository.deleteById(id);
	  } else {
		  throw new ResourceNotFoundException("User ID "+ id + " does not exits!!");
	  }
	  
	  
  }
 

}