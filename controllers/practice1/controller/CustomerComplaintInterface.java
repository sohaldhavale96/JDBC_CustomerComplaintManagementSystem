package practice1.controller;
import practice1.exceptions.CustomerException;
import practice1.models.Complaints;

public interface CustomerComplaintInterface {
	void addComplaint(Complaints c) throws CustomerException;
	void updateComplaint(int id, String status) throws CustomerException;
	void viewAllComplaint() throws CustomerException;
	void viewComplaint(int id) throws CustomerException;
	void deleteComplaint(int id) throws CustomerException;
}
