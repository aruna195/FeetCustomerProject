package com.project.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.fleet.Customer;
import com.project.fleet.FleetInfo;

import CustomerDao.CustomerDaoImpl;
import FleetDao.FleetDaoImpl;


@Controller
public class HomeController {
	
	@GetMapping(value="/")

	public String showHomePage(Model model) throws SQLException {
		
		System.out.println("In HomePage");
		//return "home";
		
		 List<Customer> allCustomers = new CustomerDaoImpl().getAllCustomers();
		System.out.println(allCustomers);
			
		model.addAttribute("CustomerList", allCustomers);
		
		 return "customers"; 
		
				   //return "new_customer";
		
		
		
		/* List<FleetInfo> allFleetInfo = new FleetDaoImpl().getAllFleet();
		System.out.println(allFleetInfo);
			
		model.addAttribute("FleetList", allFleetInfo);		
		return "fleetlist";  */
		
	//	return "home"; 
		
		
		
	} 
	}


