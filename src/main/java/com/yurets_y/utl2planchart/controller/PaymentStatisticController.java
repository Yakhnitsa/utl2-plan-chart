package com.yurets_y.utl2planchart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("payment-statistic")
public class PaymentStatisticController {
     @GetMapping
    public String getStatistic(){
        return "payment_statistic/payment-statistic";
     }
}
