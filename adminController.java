package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;
// import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Repository.adminCarRepo;
//import com.example.demo.Repository.carRepo;
import com.example.demo.UserEntity.AddVehicle;
//import com.example.demo.UserEntity.UserRegister;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.service.adminService;

// import com.example.demo.Repository.AdminRepo;
// import com.example.demo.UserEntity.AdminRegister;
// import com.example.demo.exception.RecordNotFoundException;
// import com.example.demo.service.adminService;

@Controller
@RequestMapping("/")
public class adminController {

	// @RequestMapping(path = {"/edit", "/edit/{id}"})
	// public String editEmployeeById(Model model, @PathVariable("id")
	// Optional<Long> id)
	// throws RecordNotFoundException
	// {

	// System.out.println("editEmployeeById" + id);
	// if (id.isPresent()) {
	// AdminRegister entity = service.getEmployeeById(id.get());
	// model.addAttribute("employee", entity);
	// } else {
	// model.addAttribute("employee", new AdminRegister());
	// }

	// return "RegisterCustomer";
	// }

	// @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
	// public String createOrUpdateEmployee(AdminRegister customer,Model model)
	// {
	// System.out.println("createOrUpdateEmployee ");

	// service.CustomerSave(customer);

	// List<AdminRegister> list = service.getAllEmployees();

	// model.addAttribute("employees", list);

	// return "DisplayAll";
	// }

	// @RequestMapping("/login2")
	// public String login2()
	// {
	// // System.out.println("getAllEmployees");

	// return "logingo";
	// }

	@Autowired
	adminService service;

	@Autowired
	adminCarRepo carrepo;

	@GetMapping("/login")
	public String showLoginPage() {
		return "AdminLogin";
	}

	@PostMapping("/login")
	public String processLogin(@RequestParam("username") String username,
			@RequestParam("password") String password,
			RedirectAttributes redirectAttributes) {

		// Perform authentication check
		if (username.equals("admin") && password.equals("admin")) {
			// Redirect to admin dashboard
			return "redirect:/admin/dashboard";
		} else {
			// Display error message
			redirectAttributes.addFlashAttribute("errorMessage", "Invalid username or password");
			return "redirect:/login";
		}
	}

	@GetMapping("/admin/dashboard")
	public String showAdminDashboard() {
		return "adminDashboard";
	}

	@GetMapping("/logout")
	public String adminLogout() {
		return "AdminLogin";
	}

	@RequestMapping("/goprofile")
	public String goprofile() {
		return "Myprofile";
	}

	@RequestMapping("/displaycars2")
	public String carList() {
		return "DisplayAllCar2";
	}

    @RequestMapping("/displayuser")
	public String UserList() {
		return "DisplayUser";
	}

    // @GetMapping("/displayuser")
	// public String getAllUsers(Model model) {
	// 	List<UserRegister> list = service.getAllUsers();

	// 	model.addAttribute("employees", list);
	// 	return "DisplayUser";
	// }

	// @RequestMapping("/addcar")
	// public String addcar() {
	// return "AddCar";
	// }

	@GetMapping("/displaycars2")
	public String getAllEmployees(Model model) {
		List<AddVehicle> list = service.getAllEmployees();

		model.addAttribute("employees", list);
		return "DisplayAllCar2";
	}

	// @RequestMapping()
	// public String getAllEmployees()
	// {
	// System.out.println("getAllEmployees");

	// return "AddCar";
	// }

	@RequestMapping(path = { "/addcar2", "/addcar2/{id}" })
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id)
			throws RecordNotFoundException {

		System.out.println("editEmployeeById" + id);
		if (id.isPresent()) {
			AddVehicle entity = service.getEmployeeById(id.get());
			model.addAttribute("employee", entity);
		} else {
			model.addAttribute("employee", new AddVehicle());
		}

		return "Add2Car";
	}

	@RequestMapping(path = "/createEmployee2", method = RequestMethod.POST)
	public String createOrUpdateEmployee(AddVehicle customer, Model model) {
		System.out.println("createOrUpdateEmployee ");

		service.CustomerSave(customer);

		List<AddVehicle> list = service.getAllEmployees();

		model.addAttribute("employees", list);

		return "DisplayAllCar2";
	}

	@RequestMapping(path = "/delete3/{id}")
	public String deleteCarById2(Model model, @PathVariable("id") Long id)
			throws RecordNotFoundException {

		System.out.println("deleteEmployeeById" + id);



		service.deleteCarById(id);

		List<AddVehicle> list = service.getAllEmployees();

		model.addAttribute("employees", list);
		
		return "DisplayAllCar2";
	}

}
