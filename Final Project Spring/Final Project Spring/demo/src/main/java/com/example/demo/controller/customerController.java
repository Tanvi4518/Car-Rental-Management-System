package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Repository.CustomerRepo;
import com.example.demo.UserEntity.UserRegister;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.service.customerService;

@Controller
@RequestMapping("/")
public class customerController {
    
    @Autowired
	customerService service;

    @Autowired
    CustomerRepo customerRepo;

    @RequestMapping
	public String getAllEmployees() 
	{	
		// System.out.println("getAllEmployees");
		

		
		return "list-employees";
	}

    @RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		
		System.out.println("editEmployeeById" + id);
		if (id.isPresent()) {
			UserRegister entity = service.getEmployeeById(id.get());
			model.addAttribute("employee", entity);
		} else {
			model.addAttribute("employee", new UserRegister());
		}
		
		
		return "RegisterCustomer";
	}



    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
	public String createOrUpdateEmployee(UserRegister customer,Model model) 
	{
		System.out.println("createOrUpdateEmployee ");
		
		service.CustomerSave(customer);

        List<UserRegister> list = service.getAllEmployees();

		model.addAttribute("employees", list);
		
		return "DisplayAll";
	}

    
    @RequestMapping("/login2")
	public String login2() 
	{	
		// System.out.println("getAllEmployees");
		
		return "logingo";
	}

	@RequestMapping("/login1")
	public String login1(UserRegister s) {
		Optional<UserRegister> itr = customerRepo.findByMobileNumber(s.getMobileNumber());
		if (itr.isEmpty()) {
			return "logingo";
			// if account not exist
		} else if (itr.get().getPassword().equals(s.getPassword())) {
			// if correct info
			return "Dashboard";
		}
		// wrong info
		return "logingo";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		
		System.out.println("deleteEmployeeById" + id);
		
		service.deleteEmployeeById(id);;
		return "redirect:/";
	}


}
