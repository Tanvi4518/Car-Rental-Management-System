package com.example.demo.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Repository.carRepo;
import com.example.demo.UserEntity.AddVehicle;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.service.carService;


@Controller
@RequestMapping("/")
public class carController {

    @Autowired
	carService service;

    @Autowired
    carRepo carrepo;

    @RequestMapping(path = {"/addcar", "/addcar/{id}"})
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		
		System.out.println("editEmployeeById" + id);
		if (id.isPresent()) {
			AddVehicle entity = service.getCarById(id.get());
			model.addAttribute("employee", entity);
		} else {
			model.addAttribute("employee", new AddVehicle());
		}
		
		
		return "AddCar";
	}



    @RequestMapping(path = "/createCar", method = RequestMethod.POST)
	public String createOrUpdateEmployee(AddVehicle customer,Model model) 
	{
		System.out.println("createOrUpdateEmployee ");
		
		service.CarSave(customer);

        List<AddVehicle> list = service.getAllCars();

		model.addAttribute("cars", list);
		
		return "DisplayAllCar";
	}

    @GetMapping("/allcar")
    public String allCars(){
          return "DisplayAllCar";
    }

	@GetMapping("/displaycars")
	public String getAllCars(Model model) {
		List<AddVehicle> list = service.getAllCars();

		model.addAttribute("cars", list);
		return "DisplayAllCar";
	}
    
}
