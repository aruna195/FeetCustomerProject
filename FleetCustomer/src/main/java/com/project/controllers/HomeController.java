package com.project.controllers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.fleet.Customer;
import com.project.fleet.FleetInfo;

import CustomerDao.CustomerDao;
import CustomerDao.CustomerDaoImpl;
@Controller

public class HomeController {
		@Autowired
	private CustomerDao customerDao;

	@RequestMapping(value = "/")
	public String showHomePage(Model model) throws SQLException {

		System.out.println("In HomePage");

		
		
		List<Customer> allCustomers = new CustomerDaoImpl().getAllCustomers();
		System.out.println(allCustomers);
			
		model.addAttribute("CustomerList", allCustomers);
		
		return "customers";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String newCustomerPage(Model model) throws SQLException{
		Customer newCustomer = new Customer();
		

		model.addAttribute("customer", newCustomer);
		
		return "newcustomerform";

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String newCustomerPage(@RequestParam String searchId, Model model) throws SQLException{
		Customer customer = customerDao.getCustomer(Integer.parseInt(searchId));
		List customers = new ArrayList();
		customers.add(customer);
		
		model.addAttribute("CustomerList", customers);

		return "customers";

	}

	@PostMapping(value = "/save")
	public String  save(@RequestParam("customerId") String id, @RequestParam("customerName") String name, 
			@RequestParam("address_line_1") String address_line_1,
			@RequestParam("city") String city,
			@RequestParam("postal_code") String postal_code,
			@RequestParam("state") String state,
			@RequestParam("country") String country,
			@RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude,
			@RequestParam("business_phone") String business_phone,
			@RequestParam("personal_phone") String personal_phone,
			ModelMap modelMap) 
	{
		System.out.println("In SAVE*********************************************");
		Customer customer = new Customer();
		customer.setCustomerId(Integer.parseInt(id));
		customer.setCustomerName(name);
		customer.setAddress_line_1(address_line_1);
		customer.setBusiness_phone(business_phone);
		customer.setPersonal_phone(personal_phone);
		customer.setState(state);
		customer.setCity(city);
		customer.setPostal_code(postal_code);
		System.out.println("Country" + country);
		customer.setCountry(country);
		customer.setLatitude(Double.parseDouble(latitude));
		customer.setLongitude(Double.parseDouble(longitude));
		customer.setBusiness_phone(business_phone);
		customer.setPersonal_phone(personal_phone);
		
		customerDao.createCustomer(customer);
		
		return "redirect:/";
	
		
	
	} 
	

	@RequestMapping(value = "/edit/{customerId}")
	public String editCustomer(@PathVariable int customerId, Model model) {
		
		Customer customer = customerDao.getCustomer(customerId);
		 //Integer.parseInt(customer.getCustomerId());
	    
		
		
		
		model.addAttribute("customer", customer);
	return "customers";
		
		
	}
@RequestMapping(value = "/editsave", method = RequestMethod.PUT)
	
public String  editsave(@ModelAttribute Customer customer) {
	customerDao.updateCustomer(customer);
	
	return "redirect:/customers";
}
	
	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable int id) {

		System.out.println("In DELETE............................");
		customerDao.deleteCustomer(id);

		return "redirect:/";
	

} 
}






	
		
		

