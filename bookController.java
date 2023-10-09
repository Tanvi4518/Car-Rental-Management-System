package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Repository.bookRepo;
import com.example.demo.UserEntity.BookVehicle;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.service.bookService;

@Controller
@RequestMapping("/")
public class bookController {
    
    @Autowired
	bookService service;

    @Autowired
    bookRepo bookrepo;

    @RequestMapping(path = {"/booknow", "/booknow/{id}"})
    public String editCarById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		
		// System.out.println("editCarById" + id);
		if (id.isPresent()) {
			BookVehicle entity = service.getBookingById(id.get());
			model.addAttribute("employee", entity);
		} else {
			model.addAttribute("employee", new BookVehicle());
		}
		
		
		return "Bookcar";
	}



    @RequestMapping(path = "/createbook2", method = RequestMethod.POST)
	public String createOrUpdateEmployee(BookVehicle customer,Model model) 
	{
		System.out.println("createOrUpdateEmployee ");
		
		service.BookSave(customer);

        List<BookVehicle> list = service.getAllBookings();

		model.addAttribute("books", list);
		
		return "DisplayAllBooking";
	}

    @GetMapping("/transation")
    public String allCars(){
           return "Transaction";
     }

     @RequestMapping(path = "/delete2/{id}")
     public String deleteCarById(Model model, @PathVariable("id") Long id)
             throws RecordNotFoundException {
 
         System.out.println("deleteEmployeeById" + id);
 
 
 
         service.deleteCarById(id);
 
         List<BookVehicle> list = service.getAllBookings();
 
         model.addAttribute("books", list);
         
         return "DisplayAllBooking";
     }
    
    
}
