package com.sky.locale.web.controller.formatter;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller

public class EmployeeController2 {
	
	@RequestMapping(value="add-employee1")
	public String inputEmployee(Model model) {
		model.addAttribute(new Employee());
		return "/formatter/EmployeeForm";
	}

	@RequestMapping(value="save-employee1")
	public String saveEmployee(@ModelAttribute Employee employee, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println("Code:" + fieldError.getCode() 
					+ ", field:" + fieldError.getField());
			return "/formatter/EmployeeForm";
		}
		
		// save product here
		
	    model.addAttribute("employee", employee);
		return "/formatter/EmployeeDetails";
	}
}
