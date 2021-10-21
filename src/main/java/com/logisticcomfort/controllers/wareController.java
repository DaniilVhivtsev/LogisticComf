package com.logisticcomfort.controllers;
//
//import com.logisticcomfort.model.User;
import com.logisticcomfort.model.Warehouse;
import com.logisticcomfort.repos.CompanyRepo;
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

@Controller
@RequestMapping("/add")
public class wareController {

    private final CompanyRepo companyRepo;
//    private final UserRepo userRepo;
    private final WarehouseRepo warehouseRepo;

    @Autowired
    public wareController(CompanyRepo companyRepo, WarehouseRepo warehouseRepo) {
        this.companyRepo = companyRepo;
//        this.userRepo = userRepo;
        this.warehouseRepo = warehouseRepo;
    }

    @GetMapping("/warehouse")
    public String createWarehouse(Model model){
        model.addAttribute("warehouse", new Warehouse());
        return "create/warehouse";
    }

    @PostMapping("/warehouse")
    public String CreateWare(@ModelAttribute("warehouse") @Valid Warehouse warehouse,
                             BindingResult bindingResult){

//        var set = new HashSet<User>();
//        set.add(user);

        warehouse.setId(warehouseRepo.count() + 1);
//        warehouse.setAuthor(set);
//        user.setWarehouse(warehouse);
//
//        userRepo.save(user);

        return "redirect:/";
    }
}
