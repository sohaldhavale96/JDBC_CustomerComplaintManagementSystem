package practice1.models;

import practice1.controller.ComplaintController;

enum Status{
	solved,
	unsolved,
	in_view
};

enum Gender{
	male,
	female
};

public class Complaints {
	private String name;
	private String phone;
	private String complaint;
	private Status status;
	private Gender gender;
	
	public Complaints() {
		name = "";
		phone = "";
		complaint = "";
		status = Status.unsolved;
		gender = null;
	}
	
	public Complaints(String name, String phone, String complaint, String gender) {
			this.name = name;
			this.phone = phone;
			this.complaint = complaint;
			this.gender = Gender.valueOf(gender.toLowerCase()); 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
