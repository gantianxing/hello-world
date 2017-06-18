package com.sky.locale.web.controller.user;

import com.sky.locale.web.controller.formatter.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by gantianxing on 2017/6/8.
 */

@Controller
public class UserController {
    @RequestMapping(value="add")
    public String addUser(Model model) {
        model.addAttribute(new User());
        return "/user/UserForm";
    }

    @RequestMapping(value="save")
    public String saveUser(@ModelAttribute User user, BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println("Code:" + fieldError.getCode()
                    + ", field:" + fieldError.getField());
            return "/user/UserForm";
        }

        // save product here

        model.addAttribute("user", user);


//        User newUser = new User();
//        newUser.setName("xioa");
//        newUser.setBirthday(LocalDate.now());
//        newUser.setMoney(12345.678);
//        model.addAttribute("newUser",newUser);
        return "/user/UserInfo";
    }
}
