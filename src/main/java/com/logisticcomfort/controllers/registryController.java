package com.logisticcomfort.controllers;

import com.logisticcomfort.model.Company;
import com.logisticcomfort.model.Role;
import com.logisticcomfort.model.User;
import com.logisticcomfort.repos.CompanyRepo;
import com.logisticcomfort.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

@Controller
public class registryController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user){
        User userFromDb =  userRepo.findByUsername(user.getUsername());



        if (userFromDb != null){
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        var set = new HashSet<User>();
        set.add(user);

        var company = new Company();
        company.setAuthor(set);
        company.setName("Industry");
        company.setId(userRepo.count());
        companyRepo.save(company);

        return "redirect:/login";
    }

    @GetMapping()
    public String main(@AuthenticationPrincipal User user){

//        for (var use: companyRepo.findById(1).getAuthor()
//        ){
//            System.out.println(use.getUsername());
//        }

        System.out.println(user.getUsername());
//        for (var user:companyRepo.findAllUsers()
//             ) {
//            System.out.println(user.getUsername());
//        }


        return "hello";
    }
}
