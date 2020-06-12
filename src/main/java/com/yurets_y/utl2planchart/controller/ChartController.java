package com.yurets_y.utl2planchart.controller;


import com.yurets_y.utl2planchart.entities.Order;
import com.yurets_y.utl2planchart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("chart")
public class ChartController {

    @Autowired
    private OrderService orderService;
    @GetMapping
    public String get(){
        return "other/chart";
    }

    @PostMapping
    public String post(){
        return "other/chart";
    }

    @ResponseBody
    @GetMapping("rest")
    public RestChartBody getOrders(@RequestParam(required = false) Integer year,
                                 @RequestParam(required = false) Integer month
                                 ){
        Calendar currentPeriod = Calendar.getInstance();
        if(year != null && month != null){
            currentPeriod.set(year,month,0);
        }

        RestChartBody response = new RestChartBody();
        response.setCurrentPeriod(currentPeriod.getTime());
        List<Order> orderList = orderService.getOrdersByMonth(2019,6);
        response.setOrderList(orderList);

        return response;
    }
    @ResponseBody
    @PostMapping("rest")
    public Order postOrder(@RequestBody Order order){
        System.out.println(order);
        return order;
    }

    static class RestChartBody{
        private Date currentPeriod;
        private List<Order> orderList;

        public Date getCurrentPeriod() {
            return currentPeriod;
        }

        public void setCurrentPeriod(Date currentPeriod) {
            this.currentPeriod = currentPeriod;
        }

        public List<Order> getOrderList() {
            return orderList;
        }

        public void setOrderList(List<Order> orderList) {
            this.orderList = orderList;
        }
    }
}
