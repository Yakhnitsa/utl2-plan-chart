package com.yurets_y.utl2planchart.service;

import com.yurets_y.utl2planchart.entities.ChartEntity;
import com.yurets_y.utl2planchart.entities.Order;
import com.yurets_y.utl2planchart.entities.Station;
import com.yurets_y.utl2planchart.repositories.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TestOrderService implements OrderService{
    @Autowired
    StationsRepository stationsRepository;

    @Override
    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();

        Station odessa = stationsRepository.findByCodeEquals(400409);
        Station chernomorska = stationsRepository.findByCodeEquals(403002);
        Station chernomorsk = stationsRepository.findByCodeEquals(402103);

        Station chernigiv = stationsRepository.findByCodeEquals(325104);
        Station priluki = stationsRepository.findByCodeEquals(429002);
        Station poltava = stationsRepository.findByCodeEquals(444905);
        Station viry = stationsRepository.findByCodeEquals(448501);

        Order order1 = new Order();
        order1.setSendStation(chernigiv);
        order1.setReceiveStation(odessa);
        order1.setNote("Экспортрер ....");

        Order order2 = new Order();
        order2.setSendStation(poltava);
        order2.setReceiveStation(chernomorska);
        order2.setNote("Экспортрер ....");

        Order order3 = new Order();
        order3.setSendStation(priluki);
        order3.setReceiveStation(chernomorsk);
        order3.setNote("Экспортрер ....");

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);


        return orders;
    }

    @Override
    public List<Order> getOrdersByPeriod(Date start, Date end) {

        List<Order> orderList = getOrders();
        for(Order order: orderList){
            //TODO
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByMonth(Integer year, Integer month) {
        Calendar startPeriod = new GregorianCalendar(year, month -1, 1);
        int daysInMonth= startPeriod.getActualMaximum(Calendar.DAY_OF_MONTH);
        Calendar endPeriod = new GregorianCalendar(year,month-1, daysInMonth);

        List<Order> orderList = getOrders();
        Calendar calendar = new GregorianCalendar(year,month,1);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));

        for(Order order : orderList){
            Set<ChartEntity> chartEntities = order.getChartElements();
            for(int day = 1 ; day <= daysInMonth; day++){
                calendar.set(Calendar.DAY_OF_MONTH,day);
                ChartEntity chartEntity = new ChartEntity(calendar.getTime());
                if(!chartEntities.contains(chartEntity)){
                    chartEntities.add(chartEntity);
                }
            }
        }
        return orderList;
    }
}
