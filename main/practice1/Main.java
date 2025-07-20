package practice1;
import java.sql.Connection;
import java.util.Scanner;

import practice1.controller.ComplaintController;
import practice1.exceptions.CustomerException;
import practice1.models.Complaints;
import practice1.utils.DBConnection;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.print("\nChoose one option from the following : "
					+"\n1. Add complaint"
					+"\n2. Update status"
					+"\n3. View all complaints"
					+"\n4. View complaint"
					+"\n5. Delete complaint"
					+"\n6. Exit"
					+"\nChoose one option from above : "
			);
			try {
				choice = Integer.parseInt(sc.nextLine());
				Complaints complaint1;
				ComplaintController cc;
				switch(choice) {
					case 1:
						System.out.println("\nAdd complaint.");
						System.out.print("\nEnter name of customer : ");
						String name = sc.nextLine();
						System.out.println("\nEnter phone number of customer : ");
						String phone = sc.nextLine();
						System.out.println("\nEnter complaint : ");
						String complaint = sc.nextLine();
						System.out.println("Enter gender of customer : ");
						String gender = sc.nextLine();
						complaint1 = new Complaints(name,phone,complaint,gender);
						cc = new ComplaintController();
						cc.addComplaint(complaint1);
						System.out.println("Added successfully!");
						break;
					case 2:
						System.out.println("Update complaint status");
						System.out.println("Enter id of complaint : ");
						int id = Integer.parseInt(sc.nextLine());
						System.out.println("Update status of complaint (solved, unsolved, in_view): ");
						String status = sc.nextLine();
						cc = new ComplaintController();
						cc.updateComplaint(id, status);
						System.out.println("Complaint updated successfully!");
						break;
					case 3:
						System.out.println("View all complaints");
						cc = new ComplaintController();
						cc.viewAllComplaint();
						break;
					case 4:
						System.out.println("Enter id of complaint : ");
						id = Integer.parseInt(sc.nextLine());
						cc = new ComplaintController();
						cc.viewComplaint(id);
						break;
					case 5:
						System.out.println("Enter id of complaint : ");
						id = Integer.parseInt(sc.nextLine());
						cc = new ComplaintController();
						cc.deleteComplaint(id);
						break;
					case 6:
						System.exit(1);
						break;
					default:
						throw new CustomerException("Please choose correct option.(1-5)");
				}
			}catch(CustomerException e) {
				System.out.println("Error : "+e.getMessage());
			}catch(Exception e) {
				System.out.println("Enter number only.");
			}
		}
	}

}
