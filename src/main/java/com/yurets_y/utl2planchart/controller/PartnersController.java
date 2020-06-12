package com.yurets_y.utl2planchart.controller;

import com.yurets_y.utl2planchart.entities.Partner;
import com.yurets_y.utl2planchart.service.PartnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("partners")
public class PartnersController {

    @Autowired
    private PartnersService partnersService;

    @GetMapping
    public String showPartnersList(Model model) {
        //TODO
        return "other/partners-list";
    }

    @GetMapping("add-partner")
    public String addPartnerGet(Partner partner, Model model) {
        //TODO
        return "other/partners-list";
    }

    @PostMapping("add-partner")
    public String addPartnerPost(@Valid Partner partner, Model model) {

        model.addAttribute("edit-partner",true);
        //TODO
        return "other/partners-list";
    }

    @GetMapping("edit")
    public String editPartner(Model model,
                              @RequestParam("partnerId") @Valid Partner partner){

        model.addAttribute("edit-partner",partner);
        //TODO
        return "redirect:/partners";
    }

    @GetMapping("delete")
    public String deletePartner(Model model,
                              @RequestParam("partnerId") Partner partner){

        partnersService.delete(partner);
        model.addAttribute("partners-list",partnersService.getAllById());


        return "redirect:/partners";//TODO реализовать!!!
    }
}
