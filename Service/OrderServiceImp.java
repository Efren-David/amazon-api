package com.amazonapi.amazonapi.Service;

import com.amazonapi.amazonapi.Dto.OrderInDto;
import com.amazonapi.amazonapi.Dto.OrderOutDto;
import com.amazonapi.amazonapi.Entity.Order;
import com.amazonapi.amazonapi.Entity.Product;
import com.amazonapi.amazonapi.Entity.User;
import com.amazonapi.amazonapi.Repository.OrderResository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;


@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderResository orderResository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public OrderOutDto addOrder(OrderInDto orderDto, Product product, User user){
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setProduct(product);
        order.setUser(user);
        modelMapper.map(orderDto, order);
        Order newOrder = orderResository.save(order);

        OrderOutDto orderOutDto = new OrderOutDto();
        modelMapper.map(newOrder, orderOutDto);
        return orderOutDto;
    }

    @Override
    public List<Order> findOrders(User user) {
        return orderResository.findByUser(user);
    }

    public  List<Order> getAllOrders(){
        return orderResository.findAll();
    }




}
