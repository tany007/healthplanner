
package com.ibm.healthplanner.model;

public class PatientName {
	
	private String firstName ;
	private String lastName;
	
	public PatientName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public PatientName() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("class PatientName {\n");
	    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
	    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
	    sb.append("}");
	    return sb.toString();
    }
	
	private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }

}