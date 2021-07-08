package com.tan.su.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tan.su.beans.OpenAccount;
import com.tan.su.bo.OpenAccountBusinessInterface;

@WebServlet("/openAccount")
public class OpeningAccount extends HttpServlet {
	ConfigurableApplicationContext cfg ;
	public void init(ServletConfig config) throws ServletException {
		cfg = new ClassPathXmlApplicationContext("com/tan/su/resources/springConfig.xml");
	}

	
	public void destroy() {
		cfg.close();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 Random random = new Random();
		 long max = 78945619999l;
		 long min = 78945611111l;
		 long accountNymber = min + (long)(random.nextDouble() * (max - min));
		 long cifSuffix = min + (long)(random.nextDouble() * (max - min));
		 String cif = "SBI" + cifSuffix;
		 String branch = req.getParameter("branch");
		 String customerType = req.getParameter("customer");
		 String seniorCitizen = req.getParameter("sen");
		 String minor = req.getParameter("minor");
		 String selfDesignation = req.getParameter("degSelf");
		 String firstName = req.getParameter("fname");
		 String middleName = req.getParameter("mname");
		 String lastName = req.getParameter("lname");
		 String nomineeDesignation = req.getParameter("deg");
		 String nomineeFirstName = req.getParameter("Fname");
		 String nomineeMiddleName = req.getParameter("Mname");
		 String nomineeLastName = req.getParameter("Lname");
		 String dateOfBirth = req.getParameter("date");
		 String gender = req.getParameter("gender");
		 String nationality = req.getParameter("country");
		 String maritialStatus = req.getParameter("marry");
		 String uid = req.getParameter("uid");
		 String address = req.getParameter("address");
		 String landmark = req.getParameter("landmark");
		 String city = req.getParameter("city");
		 String pincode = req.getParameter("pincode");
		 String email = req.getParameter("email");
		 String state = req.getParameter("state");
		 String telephone = req.getParameter("telephone");
		
		OpenAccount acc = new OpenAccount();
		acc.setAccountNumber(accountNymber);
		acc.setCif(cif);
		acc.setBranch(branch);
		acc.setCustomerType(customerType);
		acc.setSeniorCitizen(seniorCitizen);
		acc.setMinor(minor);
		acc.setSelfDesignation(selfDesignation);
		acc.setFirstName(firstName);
		acc.setMiddleName(middleName);
		acc.setLastName(lastName);
		acc.setNomineeDesignation(nomineeDesignation);
		acc.setNomineeFirstName(nomineeFirstName);
		acc.setNomineeMiddleName(nomineeMiddleName);
		acc.setNomineeLastName(nomineeLastName);
		acc.setDateOfBirth(dateOfBirth);
		acc.setGender(gender);
		acc.setLandmark(landmark);
		acc.setNationality(nationality);
		acc.setMaritialStatus(maritialStatus);
		acc.setUid(uid);
		acc.setAddress(address);
		acc.setCity(city);
		acc.setPincode(pincode);
		acc.setEmail(email);
		acc.setState(state);
		acc.setTelephone(telephone);
		
		OpenAccountBusinessInterface bo = (OpenAccountBusinessInterface) cfg.getBean("openAccountBo");
		long i = bo.saveCustomerDetails(acc);
		if (i == acc.getAccountNumber()) {
			res.getWriter().print("Account No is: " + acc.getAccountNumber() + " \n");
			res.getWriter().print("cif code is: " + acc.getCif());
		}
		
	}

}
