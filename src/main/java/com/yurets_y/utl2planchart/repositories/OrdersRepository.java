package com.yurets_y.utl2planchart.repositories;

import com.yurets_y.utl2planchart.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order,Integer> {


}
