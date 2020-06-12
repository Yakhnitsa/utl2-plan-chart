package com.yurets_y.utl2planchart.service;

import com.yurets_y.utl2planchart.entities.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {

    List<Order> getOrders();

    List<Order> getOrdersByPeriod(Date start, Date end);

    List<Order> getOrdersByMonth(Integer year, Integer month);
}
