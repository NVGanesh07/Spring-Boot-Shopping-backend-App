package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Customer;
import com.shopping.service.CustomerDaoService;
import com.shopping.util.DButil;

@Service
public class CustomerDaoServiceImpl implements CustomerDaoService {

	ArrayList<Customer> customerList = new ArrayList<Customer>();

	private static Connection connection = null;
	Customer currentCustomer = new Customer();

	public CustomerDaoServiceImpl() {
		try {
			connection = DButil.getConnection();
			System.out.println("connection: " + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Customer> getCustomers() {
		customerList.clear();
		String getCustomerQuery = "SELECT * FROM customer;";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(getCustomerQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Customer cust = new Customer();
				cust.setCustomerid(rs.getInt(1));
				cust.setCustomerName(rs.getString(2));
				cust.setGender(rs.getString(3));
				cust.setContact(rs.getLong(4));
				cust.setEmail(rs.getString(5));
				cust.setAddress(rs.getString(6));
				cust.setPincode(rs.getInt(7));
				cust.setUsername(rs.getString(8));
				cust.setPassword(rs.getString(9));
				customerList.add(cust);
				

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public void addCustomer(Customer customer) {
		int customerid = customer.getCustomerid();
		String customerName = customer.getCustomerName();
		String Gender = customer.getGender();
		long contactNo = customer.getContact();
		String email = customer.getEmail();
		String address = customer.getAddress();
		int pincode = customer.getPincode();
		String username = customer.getUsername();
		String password = customer.getPassword();
		
	
		String insertQuery = "INSERT INTO CUSTOMER VALUE("+customerid+",'"+customerName+"','"+Gender+"',"+contactNo+",'"+email+"','"+address+"',"+pincode+",'"+username+"','"+password+"')";

		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Customer Added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public boolean customerLoginValidation(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("Username: "+username+" Password: "+password );
		boolean flag =false;
		String loginQuery = "SELECT * FROM customer where username = '"+username+"';";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(loginQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				if(rs.getString(8).equals(username) && rs.getString(9).equals(password)) {
					
				flag = true;
				System.out.println("Login Succussfull");
				currentCustomer.setCustomerid(rs.getInt(1));
				currentCustomer.setCustomerName(rs.getString(2));
				currentCustomer.setGender(rs.getString(3));
				currentCustomer.setContact(rs.getLong(4));
				currentCustomer.setEmail(rs.getString(5));
				currentCustomer.setAddress(rs.getString(6));
				currentCustomer.setPincode(rs.getInt(7));
				currentCustomer.setUsername(rs.getString(8));
				currentCustomer.setPassword(rs.getString(9));
				customerList.add(currentCustomer);
				}
				else {
					System.out.println("Invalid Customer Data");
				}
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("flag:"+flag);
		return flag;
	}
	
	

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		int customerid = customer.getCustomerid();
		String customerName = customer.getCustomerName();
		String Gender = customer.getGender();
		long contactNo = customer.getContact();
		String email = customer.getEmail();
		String address = customer.getAddress();
		int pincode = customer.getPincode();
		String username =customer.getUsername();
		String password =customer.getPassword();
		
		
		String updateQuery = "UPDATE customer SET customerName = '"+customerName+"',"
				+ "Gender = '"+Gender+"',"
				+ "contactNo = "+contactNo+","
				+ "email = '"+email+"',"
				+ " address = '"+address+"',"
				+ "pincode = "+pincode+", "
				+ "username = '"+username+"',"
				+ "password = '"+password+"' WHERE customerid = '"+customerid+"';";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Customer Data updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteCustomer(String username) {
		// TODO Auto-generated method stub

		String deleteQuery = "DELETE FROM CUSTOMER WHERE username = '"+username+"'";
		
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Custemer data deleted successfully");
		} catch (SQLException e) {
			
			e.printStackTrace();

		
 	   }
	}
}