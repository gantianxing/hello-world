package com.sky.locale.web.controller.converter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    
    @RequestMapping(value="/add-employee")
    public String inputEmployee(Model model) {
        model.addAttribute(new Employee());
        return "/converter/EmployeeForm";
    }

    @RequestMapping(value="/save-employee")
    public String saveEmployee(@ModelAttribute Employee employee, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return "/converter/EmployeeForm";
        }
        
        // save employee here
        
        model.addAttribute("employee", employee);
        return "/converter/EmployeeDetails";
    }
}
