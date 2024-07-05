package com.jspiders.springmvc1.controller;

import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc1.dto.CarDTO;
import com.jspiders.springmvc1.dto.UserDTO;
import com.jspiders.springmvc1.service.CarService;
import com.jspiders.springmvc1.service.UserService;

@Controller   
public class CarController {
  
	@Autowired                                      //inject the carService class
	private CarService carService;  				//it is an dependencies thats why it is noted with @Autowired
	@Autowired
	private UserService userService;
	

	@RequestMapping(path = "/add_page",method = RequestMethod.GET)
	public String getAddPage(HttpSession httpSession) {
		UserDTO foundUser=(UserDTO) httpSession.getAttribute("user");
		if(foundUser!=null) {
			return "add_car";
		}
		return "sign_in";
	}
		
	@RequestMapping(path = "/add_car" ,method = RequestMethod.POST)                           //requestMapping is use to map 
	public String addCar(@RequestParam(name="name") String name,@RequestParam(name="brand") String brand,
			@RequestParam(name="price") double price ,ModelMap modelMap,HttpSession httpSession) {//ModelMap is use to the model data
		 UserDTO foundUser=(UserDTO)httpSession.getAttribute("user");
		 if(foundUser!=null) {
			 CarDTO addedCar=carService.addCar(name, brand, price);
			 userService.updateUser(foundUser,addedCar);
			 modelMap.addAttribute("message","car is added successfully");
			 return "add_car";
		 }else {
			 return "sign_in";
		 }   
	}                                    //here we add the addCar method to the service Controller.
	                                     //using the modelMap we can send the some data along with add_car view 
	                                     //method to the Dispatcher it will check if there is any
	     
	
	@RequestMapping(path="/cars",method= RequestMethod.GET)
	public String getCars(ModelMap modelMap,HttpSession httpSession) {
		UserDTO foundUser=(UserDTO) httpSession.getAttribute("user");
		if(foundUser!=null) {
			List<CarDTO> cars=carService.findAllCars();
			if(cars!=null) {
				modelMap.addAttribute("cars", cars);
			}
			else {
				modelMap.addAttribute("message", "cars is not available");
			}
			return "cars";
		}else {
			return "sign_in";
		}
	}
	@RequestMapping(path = "/home",method = RequestMethod.GET)
	public String homePage(HttpSession httpSession) {
		UserDTO foundUser=(UserDTO) httpSession.getAttribute("user");
		if(foundUser!=null) {
			return "home";
		}else {
			return "sign_in";
		}	
	}
	@RequestMapping(path = "/my_cars", method = RequestMethod.GET )
	public String findAllCarByUser(ModelMap modelMap,HttpSession httpSession) {
		UserDTO foundUser=(UserDTO)httpSession.getAttribute("user");
		if(foundUser!=null) {
			List<CarDTO> cars=carService.findAllCarByUser(foundUser);
			if(cars!=null) {
				modelMap.addAttribute("cars",cars);
			}
			else {
				modelMap.addAttribute("message","cars are not available");
				
			}
			return "my_cars";
		}
		else {
		
		return "sign_in";
		}
	}
	
	
	@RequestMapping(path = "/delete_car", method = RequestMethod.POST)
	public String deleteCar(@RequestParam(name = "id") int id, ModelMap modelMap, HttpSession httpSession) {
		UserDTO foundUser = (UserDTO) httpSession.getAttribute("user");
		carService.deleteCar(foundUser, id);
		List<CarDTO> cars = carService.findAllCarByUser(foundUser);
		if (cars != null) {
			modelMap.addAttribute("cars", cars);
			modelMap.addAttribute("message", "Car details deleted");
		} else {
			modelMap.addAttribute("message", "Cars not available");
		}
		return "my_cars";
	}
	
	@RequestMapping(path = "/update_car",method = RequestMethod.POST)
	public String updateCar(@RequestParam(name="id") int id,@RequestParam(name="name") String name,@RequestParam(name="brand")String brand,@RequestParam(name="price")double price,ModelMap modelMap,HttpSession httpSession) {
		UserDTO foundUser=(UserDTO)httpSession.getAttribute("user");
		carService.updateCar(id,name,price,brand);
		List<CarDTO> cars=carService.findAllCarByUser(foundUser);
		modelMap.addAttribute("cars", cars);
		modelMap.addAttribute("message", "updated succesfully");
		return "my_cars";
		
	}
	
	@RequestMapping(path = "/edit_car" ,method = RequestMethod.POST)
	public String getEditpage(@RequestParam(name="id")int id,ModelMap modelMap) {
		CarDTO car=carService.findCarById(id);
		
		modelMap.addAttribute("car", car);
		
		return "edit_car";
		
	}
	
	@RequestMapping(path = "/search")
	public String findAllCarsByPrice(@RequestParam(name="low")double low,@RequestParam(name="high") double high,HttpSession httpSession,ModelMap modelMap) {
		
		UserDTO foundUser=(UserDTO) httpSession.getAttribute("user");
		if(foundUser!=null) {
			List<CarDTO> cars=carService.findAllCarsByPrice(low, high);
			if(cars!=null) {
				modelMap.addAttribute("cars",cars);
			}
			else {
				modelMap.addAttribute("message","car is not available");
			}
			
		}
		return "cars";
		
	}
	
	
	
	
}




//@RequestMapping(path = "/delete_car" ,method = RequestMethod.POST)
//public String deleteCar(@RequestParam(name="id") int id ,ModelMap modelMap,HttpSession httpSession) {
//	UserDTO foundUser=(UserDTO) httpSession.getAttribute("user");
//	carService.deleteCar(foundUser,id);
//	List<CarDTO> cars=carService.findAllCarByUser(foundUser);
//	if(cars!=null) {
//		 modelMap.addAttribute("cars",cars);
//		 modelMap.addAttribute("message", "car deleted succefully");
//	}
//	else {
//		modelMap.addAttribute("message", "car is not available");
//		
//	}
//	return "my_cars";
//	
//}








//@RequestMapping(path = "/add_page",method = RequestMethod.GET)
//public String getAddPage() {
//	return "add_car";
//}
//
//
//@RequestMapping(path = "/add_car" ,method = RequestMethod.POST)
//public String addCar(@RequestParam(name="name") String name,@RequestParam(name="brand") String brand,
//	@RequestParam(name="price") double price ,ModelMap modelMap) {
//		carService.addCar(name, brand, price);
//		modelMap.addAttribute("message","car is added successfully");
//		return "add_car";
//}