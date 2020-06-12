package com.yurets_y.utl2planchart.controller;


import com.yurets_y.utl2planchart.entities.Order;
import com.yurets_y.utl2planchart.entities.OrderForm;
import com.yurets_y.utl2planchart.entities.Station;
import com.yurets_y.utl2planchart.repositories.OrdersRepository;
import com.yurets_y.utl2planchart.repositories.StationsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class OrderController {
    private final OrdersRepository ordersRepository;
    private final StationsRepository stationsRepository;

    public OrderController(OrdersRepository ordersRepository, StationsRepository stationsRepository) {
        this.ordersRepository = ordersRepository;
        this.stationsRepository = stationsRepository;
    }

    @GetMapping("/orders")
    public String showOrders(Model model){
        model.addAttribute("station_list",stationsRepository.findAll());
        model.addAttribute("order_list",ordersRepository.findAll());
        return "order/orders";
    }

    @GetMapping("/createOrder")
    public String addOrderGet(OrderForm orderForm, Model model){

        model.addAttribute("station_list",stationsRepository.findAll());
        model.addAttribute("order_list",ordersRepository.findAll());

        return "order/createOrder";
    }

    @PostMapping("/createOrder")
    public String addOrderPost(@Valid OrderForm orderForm,
            BindingResult bindingResult,
            Model model){
        Station sndStation = stationsRepository.findFirstByCodeEquals(orderForm.getSendStationCode());
        Station rsvStation = stationsRepository.findFirstByCodeEquals(orderForm.getReceiveStationCode());

        Order transportOrder = new Order();
        transportOrder.setSendStation(sndStation);
        transportOrder.setReceiveStation(rsvStation);
        transportOrder.setNote(orderForm.getNote());

        ordersRepository.save(transportOrder);

        return "redirect:/orders";
    }
}
