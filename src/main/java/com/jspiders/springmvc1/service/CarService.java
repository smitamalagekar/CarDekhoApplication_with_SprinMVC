package com.jspiders.springmvc1.service;

import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import com.jspiders.springmvc1.dao.CarDAO;
import com.jspiders.springmvc1.dto.CarDTO;
import com.jspiders.springmvc1.dto.UserDTO;

@Component
public class CarService {

	@Autowired
	private CarDAO carDAO;


	public  CarDTO addCar(String name, String brand, double price) {
		CarDTO carDTO=new CarDTO();
		carDTO.setName(name);
		carDTO.setBrand(brand);
		carDTO.setPrice(price);
		carDAO.addCar(carDTO);
		return carDTO;
	}
	public List<CarDTO> findAllCars(){
		List<CarDTO> cars=carDAO.findAllCars();
		
			if(cars!=null && cars.size()>0) {
				return cars;
			}
			else {
				return null;
			}
			
		}
	public List<CarDTO> findAllCarByUser(UserDTO foundUser) {
		List<CarDTO> cars=carDAO.findAllCarsByUser(foundUser.getId());
		if(cars!=null && cars.size()>0) {
			return cars;
		}
		else {
			return null;
		}
	}
	public void deleteCar(UserDTO foundUser, int carId) {
		  carDAO.deleteCar(foundUser.getId(),carId);
		
	}
	public void updateCar(int id, String name, double price, String brand) {
		CarDTO car=new CarDTO();
		car.setId(id);
		car.setName(name);
		car.setBrand(brand);
		car.setPrice(price);
	    carDAO.updateCar(car);
		
		
	}
	public CarDTO findCarById(int id) {
		return carDAO.findCarById(id);
	}

    public List<CarDTO> findAllCarsByPrice(double low,double high) {
    	List<CarDTO> cars=carDAO.findAllCarsByPrice(low,high);
    	if(cars!=null && cars.size()>0) {
    		return cars;
    	}
    	else {
    		return null;
    	}
    }
}
