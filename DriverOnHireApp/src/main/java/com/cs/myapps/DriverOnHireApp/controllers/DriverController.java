package com.cs.myapps.DriverOnHireApp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;
import com.cs.myapps.DriverOnHireApp.beans.Driver;
import com.cs.myapps.DriverOnHireApp.dao.DriverDao;



@Controller
public class DriverController {

	@RequestMapping("/driverform") 
	public ModelAndView getDriversList()
	{
		return new ModelAndView("driverform","command",new Driver());

	}

	@RequestMapping(value="/save",method = RequestMethod.POST)  
	public ModelAndView save(@ModelAttribute("driver") Driver driver){  
		//write code to save emp object  
		//here, we are displaying emp object to prove emp has data  
		driver.setId(driver.getEmail());
		System.out.println(" "+ driver.getName()+" "+driver.getEmail()+" "+driver.getCity()+" "+driver.getAvailable());  
		DriverDao dao = new DriverDao();
		dao.save(driver);
		//return new ModelAndView("empform","command",emp);//will display object data  
		return new ModelAndView("redirect:/viewAddedDriver");//will redirect to viewemp request mapping  
	}  
	
	/*@RequestMapping("/viewAddedDriver")  
    public ModelAndView confirmData(){ 		
		DriverDao dao = new DriverDao(); 
		List<Driver> driverList = dao.getAllDrivers();
		System.out.println("CH**:"+driverList.size());
		return new ModelAndView("viewDriver","driverList",driverList);  
    }  */
	
	@RequestMapping("/viewAddedDriver")  
    public ModelAndView getAllAvailableDrivers(){ 		
		DriverDao dao = new DriverDao(); 
		List<Driver> driverList = dao.getAllAvailableDrivers();
		System.out.println("CH**:"+driverList.size());
		return new ModelAndView("viewDriver","driverList",driverList);  
    }  
}
