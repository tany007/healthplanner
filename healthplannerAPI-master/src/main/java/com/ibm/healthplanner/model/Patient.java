package com.ibm.healthplanner.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@SuppressWarnings("serial")
@Document(collection = "patients")
public class Patient  extends BaseEntity{
	
	@JsonProperty("patientName")
	private PatientName name;
	
	private String gender;
	
	private double age;
	
	private String mailId;
	private String phone;
	private double height;
	private double weight;
	private double bmi;
	
	
	
	public Patient(){
		
	}
	public Patient(PatientName name, String gender,double age,String phone, 
			double height, double weight, 
			double bmi){
		
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		
	}
	
	public PatientName getName() {
		return name;
	}
	public void setName(PatientName name) {
		this.name = name;
		//System.out.println("PatientName : "+name.toString() +"FirstName: "+name.getFirstName());
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
		
}
	
