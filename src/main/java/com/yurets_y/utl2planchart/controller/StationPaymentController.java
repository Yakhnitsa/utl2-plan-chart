package com.yurets_y.utl2planchart.controller;


import com.yurets_y.utl2planchart.entities.OrderForm;
import com.yurets_y.utl2planchart.forms.StationPaymentForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class StationPaymentController {

    @GetMapping("/station-payment")
    public String getPage(StationPaymentForm stationPaymentForm, Model model){


        return "other/station-payment";
    }

    @PostMapping("/station-payment")
    public String postPage(
            @Valid StationPaymentForm stationPaymentForm,
            BindingResult bindingResult,
            Model model){

        model.addAttribute("paymentForm", stationPaymentForm);
        System.out.println("sucess!");
        return "other/station-payment";
    }
}
