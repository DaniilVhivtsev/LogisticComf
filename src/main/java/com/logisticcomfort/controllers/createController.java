package com.logisticcomfort.controllers;

import com.logisticcomfort.model.Company;
import com.logisticcomfort.model.User;
import com.logisticcomfort.repos.CompanyRepo;
import com.logisticcomfort.repos.UserRepo;
import com.logisticcomfort.repos.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashSet;

@Controller
@RequestMapping("/create")
public class createController {

    private final CompanyRepo companyRepo;
    private final UserRepo userRepo;
    private final WarehouseRepo warehouseRepo;
    @Autowired
    public createController(CompanyRepo companyRepo, UserRepo userRepo, WarehouseRepo warehouseRepo) {
        this.companyRepo = companyRepo;
        this.userRepo = userRepo;
        this.warehouseRepo = warehouseRepo;
    }

    @GetMapping("/company")
    public String createCompany(Model model){
        model.addAttribute("company", new Company());
        return "create/company";
    }

    @PostMapping("/company")
    public String Create(@ModelAttribute("company") @Valid Company company,
                         BindingResult bindingResult,
                         @AuthenticationPrincipal User user){

//        if(bindingResult.hasErrors())
//            return "create/company";

        var set = new HashSet<User>();
        set.add(user);

        company.setId(companyRepo.count() + 1);
        company.setAuthor(set);
        user.setCompany(company);

        userRepo.save(user);

        return "redirect:/";
    }


}
