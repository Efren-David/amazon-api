package com.amazonapi.amazonapi.Controller;


import com.amazonapi.amazonapi.Dto.ErrorResponse;
import com.amazonapi.amazonapi.Dto.OrderInDto;
import com.amazonapi.amazonapi.Dto.OrderOutDto;

import com.amazonapi.amazonapi.Entity.Order;
import com.amazonapi.amazonapi.Entity.Product;
import com.amazonapi.amazonapi.Entity.User;
import com.amazonapi.amazonapi.Exception.ProductNotFoundException;
import com.amazonapi.amazonapi.Exception.UserNotFoundException;
import com.amazonapi.amazonapi.Service.OrderService;
import com.amazonapi.amazonapi.Service.ProductService;
import com.amazonapi.amazonapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/user/{userId}/orders")
    public ResponseEntity<OrderOutDto> addOrder(@PathVariable Long userId, @RequestBody OrderInDto orderDto)
        throws ProductNotFoundException, UserNotFoundException{
        User user = userService.findUser(userId);
        Product product = productService.findProduct(orderDto.getProductId());
        OrderOutDto orderOutDto = orderService.addOrder(orderDto, product, user);
        return new ResponseEntity<>(orderOutDto, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
   public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }













    // TODO Delete order

        // TODO Modify order

        // TODO Deliver order



        @ExceptionHandler(ProductNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleException(ProductNotFoundException pnfe) {
            ErrorResponse errorResponse = new ErrorResponse(101, pnfe.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleException(UserNotFoundException unfe) {
            ErrorResponse errorResponse = new ErrorResponse(101, unfe.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

}
