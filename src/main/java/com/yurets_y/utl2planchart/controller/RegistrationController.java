package com.yurets_y.utl2planchart.controller;


import com.yurets_y.utl2planchart.entities.Role;
import com.yurets_y.utl2planchart.entities.User;
import com.yurets_y.utl2planchart.forms.RegistrationForm;
import com.yurets_y.utl2planchart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/users/registration")
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registration(RegistrationForm registrationForm, Model model) {

//        model.addAttribute("regForm", regForm);
        model.addAttribute("roles", Role.values());
        return "users/registration";
    }

    @PostMapping
    public String addNewUser(
            @Valid RegistrationForm registrationForm,
            BindingResult bindingResult,
            Model model) {

        boolean hasErrors = false;

        if (userService.nameIsBusy(registrationForm.getUsername())) {
            bindingResult.rejectValue("username","error.username","пользователь с таким именем уже существует!");
            hasErrors = true;
        }

        if(userService.emailIsBusy(registrationForm.geteMail())){
            bindingResult.rejectValue("email","error.eMail","указанный электронный ящик уже используется!");
            hasErrors = true;
        }
        if (!registrationForm.getPass().equals(registrationForm.getPassConfirm())){
            bindingResult.rejectValue("pass","error.pass","пароли не совпадают");
            bindingResult.rejectValue("passConfirm","error.passConfirm","пароли не совпадают");
            hasErrors = true;
        }


        if(bindingResult.hasErrors() || hasErrors){
            System.out.println("has errors!");
            return "users/registration";
        }
//        If everything is OK:

        User user = new User();
        user.setUsername(registrationForm.getUsername());
        user.setPassword(registrationForm.getPass());
        user.setEmail(registrationForm.geteMail());


        System.out.println("User was added to database");


        userService.addNewUser(user);

//        Set<String> roles = Arrays
//                .stream(Role.values())
//                .map(Role::name)
//                .collect(Collectors.toSet());
//        for (String key : form.keySet()) {
//            if (roles.contains(key)) {
//                user.getRoles().add(Role.valueOf(key));
//            }
//        }
//        userRepository.save(user);
//        model.addAttribute("roles", Role.values());

        model.addAttribute("reg_message", "User " + user.getUsername() + "successfully registered!");
        return "redirect:/";
    }
}
