package practice1.controller;
import practice1.models.Complaints;
import java.sql.Connection;
import java.sql.ResultSet;

import practice1.utils.DBConnection;
import java.sql.Statement;
import java.sql.SQLException;
import practice1.exceptions.*;

public class ComplaintController implements CustomerComplaintInterface {
	@Override
	public void addComplaint(Complaints complaint) throws CustomerException {
	    try (Connection connection = DBConnection.getConnection();
	         Statement statement = connection.createStatement()) {

	        String query = "INSERT INTO complaints(name, phone, complaint, gender) VALUES ('"
	                + complaint.getName() + "', '"
	                + complaint.getPhone() + "', '"
	                + complaint.getComplaint() + "', '"
	                + complaint.getGender() + "');";

	        System.out.println("Executing query: " + query);
	        int rowsAffected = statement.executeUpdate(query);
	        System.out.println("Rows affected: " + rowsAffected);

	    } catch (SQLException e) {
	        throw new CustomerException("Error while adding complaint: " + e.getMessage());
	    }
	}

	@Override
	public void updateComplaint(int id, String status) throws CustomerException {
		try(Connection connection = DBConnection.getConnection()){
			Statement statement = connection.createStatement();
			String query = "UPDATE complaints SET status = '"+status+"'WHERE id = "+id+";";
			if(status.equals("solved")) {
				query = "UPDATE complaints SET status = '"+status+"', date_of_solved_complaint = CURRENT_TIMESTAMP WHERE id = "+id+";";
			}else if(status.equals("in_view")){
				query = "UPDATE complaints SET status = '"+status+"', date_of_solved_complaint = CURRENT_TIMESTAMP WHERE id = "+id+";";
			}
			int rowsAffected = statement.executeUpdate(query);
			System.out.println("Update success! "+rowsAffected+" row(s) affected.");
		}catch(SQLException e) {
			throw new CustomerException(e.getMessage());
		}
	}
	@Override
	public void viewAllComplaint() throws CustomerException {
		String query = "SELECT * FROM complaints;";
		try (
				Connection connection = DBConnection.getConnection();
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query);
		){
			while(result.next()) {
				System.out.println("ID : "+result.getInt("id"));
				System.out.println("name : "+result.getString("name"));
				System.out.println("phone : "+result.getString("phone"));
				System.out.println("complaint : "+result.getString("complaint"));
				System.out.println("status : "+result.getString("status"));
				System.out.println("gender : "+result.getString("gender"));
				System.out.println("date_of_raising_complaint : "+result.getString("date_of_raising_complaint"));
				System.out.println("date_of_solved_complaint : "+result.getString("date_of_solved_complaint"));
				System.out.println("============================================================================================");
			}
		}catch(SQLException e) {
			throw new CustomerException(e.getMessage());
		}
	}
	@Override
	public void deleteComplaint(int id) throws CustomerException{
		String query = "DELETE FROM complaints WHERE id = "+id;
		try(
			Connection connection = DBConnection.getConnection();
			Statement statement = connection.createStatement();
		){
			int rowsAffected = statement.executeUpdate(query);
			System.out.println("Complaint deleted!"+rowsAffected+" row(s) affected.");
		}catch(SQLException e) {
			throw new CustomerException(e.getMessage());
		}
	}
	@Override
	public void viewComplaint(int id) throws CustomerException {
		String query = "SELECT * FROM complaints WHERE id = "+id;
		try(
			Connection connection = DBConnection.getConnection();
			Statement statement = connection.createStatement();
		){
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				System.out.println("ID : "+result.getInt("id"));
				System.out.println("name : "+result.getString("name"));
				System.out.println("phone : "+result.getString("phone"));
				System.out.println("complaint : "+result.getString("complaint"));
				System.out.println("status : "+result.getString("status"));
				System.out.println("gender : "+result.getString("gender"));
				System.out.println("date_of_raising_complaint : "+result.getString("date_of_raising_complaint"));
				System.out.println("date_of_solved_complaint : "+result.getString("date_of_solved_complaint"));
				System.out.println("============================================================================================");
			}
		}catch(SQLException e) {
			throw new CustomerException(e.getMessage());
		}
	}
}
