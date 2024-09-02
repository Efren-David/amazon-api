package com.amazonapi.amazonapi.Service;

import com.amazonapi.amazonapi.Dto.OrderInDto;
import com.amazonapi.amazonapi.Dto.OrderOutDto;
import com.amazonapi.amazonapi.Entity.Order;
import com.amazonapi.amazonapi.Entity.Product;
import com.amazonapi.amazonapi.Entity.User;


import java.util.List;


public interface OrderService {
    OrderOutDto addOrder(OrderInDto orderDto, Product product, User user);

    List<Order> findOrders(User user);

    List<Order> getAllOrders();
}
