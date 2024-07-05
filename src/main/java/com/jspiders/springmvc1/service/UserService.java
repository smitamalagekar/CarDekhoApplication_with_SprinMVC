package com.jspiders.springmvc1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc1.dao.UserDAO;
import com.jspiders.springmvc1.dto.CarDTO;
import com.jspiders.springmvc1.dto.UserDTO;

@Component
public class UserService {
 
	@Autowired
	private UserDAO userDAO; 
	public UserDTO addUser(String email, String password) {
		UserDTO userDTO=new UserDTO();
		userDTO.setEmail(email);
		userDTO.setPassword(password);
		userDTO.setCars(new ArrayList<CarDTO>());	
		return userDAO.addUser(userDTO);
	}
	public UserDTO checkUser(String email,String password) {
		List<UserDTO> users=userDAO.findAllUser();
		UserDTO founduser=null;
		for(UserDTO user:users) {
			if(user.getEmail().equals(email)&& user.getPassword().equals(password) ) {
				 founduser=user;
				 break;
			}
		}
		return founduser;
	}
	
	
	public void updateUser(UserDTO foundUser,CarDTO addedCar) {
		userDAO.updateUser(foundUser.getId(),addedCar.getId());	
	}
}
