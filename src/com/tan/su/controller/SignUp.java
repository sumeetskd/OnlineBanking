package com.tan.su.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tan.su.beans.SignUpCls;
import com.tan.su.bo.SignUpBusinessInterface;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private ConfigurableApplicationContext configure;

	public void init(ServletConfig config) throws ServletException {
		configure = new ClassPathXmlApplicationContext("com/tan/su/resources/springConfig.xml");
	}

	public void destroy() {
		configure.close();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String ac = request.getParameter("account");
		 String cif = request.getParameter("cif");
		 String branchCode = request.getParameter("branch");
		 String country = request.getParameter("country");
		 String mobileNo = request.getParameter("mobile");
		 String facilityRequired = request.getParameter("facility");
		 
		 SignUpCls signUpCls = new SignUpCls();
		 signUpCls.setAccountNo(ac);
		 signUpCls.setCif(cif);
		 signUpCls.setBranchCode(branchCode);
		 signUpCls.setCountry(country);
		 signUpCls.setMobileNo(mobileNo);
		 signUpCls.setFacilityRequired(facilityRequired);
		 SignUpBusinessInterface signUpBo = (SignUpBusinessInterface) configure.getBean("signUpBo");
		 String accNo = signUpBo.save(signUpCls);
		 if(accNo.equals(signUpCls.getAccountNo())) {
			 response.getWriter().print("Account Number " + accNo + " added");
		 }
		 
	}

}
