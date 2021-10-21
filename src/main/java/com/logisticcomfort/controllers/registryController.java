package com.logisticcomfort.controllers;

import com.logisticcomfort.DAO.PersonDAO;
import com.logisticcomfort.model.Person;
import com.logisticcomfort.model.Role;
import com.logisticcomfort.model.User;
import com.logisticcomfort.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class registryController {

    private final PersonDAO personDAO;

    @Autowired
    public registryController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("person", new Person());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("person") @Valid Person person,
                          BindingResult bindingResult){
//        User userFromDb =  userRepo.findByUsername(user.getUsername());
//
////        if(userFromDb != null){
////            //если такой пользователь есть
////        }
//
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
//        userRepo.save(user);
//        return "redirect:/login";

//        if(bindingResult.hasErrors())
//            return "/registration";

        personDAO.Save(person);
        return "login";

    }

    @GetMapping()
    public String main(){
        return "hello";
    }
}
