package com.amazonapi.amazonapi.Repository;


import com.amazonapi.amazonapi.Entity.Order;
import com.amazonapi.amazonapi.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderResository extends CrudRepository<Order, Long > {
    List<Order> findAll();
    List<Order> findByUser(User user);


}
