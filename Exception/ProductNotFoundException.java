package com.amazonapi.amazonapi.Exception;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(String message){
        super(message);
    }

    public ProductNotFoundException(Long productId){
        super("Product " + productId + " not found");
    }

    public ProductNotFoundException(){
        super("Product not found");
    }
}
